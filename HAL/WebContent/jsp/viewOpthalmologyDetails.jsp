<%@page import="jkt.hms.masters.business.OpdOphthalmologyDetails"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasEmployeeDependent"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 /* var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}'; */
</script>
<!-- <script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script> -->

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<!-- <link href="css/style.css" rel="stylesheet" type="text/css" /> -->
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<title>Eye Care</title>
<%Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String currentTime = (String) utilMap.get("currentTime");
String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
				Map<String, Object> map = new HashMap<String, Object>();
// 				 List<HrTerminationProcess> hrTerminationProcessList = new ArrayList<HrTerminationProcess>();
				 /*List<TempTickattach> tempTicketAttachList = new ArrayList<TempTickattach>(); */
		
				String message = "";
				int hinId=0;
				int visitId=0;
				int inpatientId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
			
				if(request.getParameter("hinId")!=null){
					hinId=Integer.parseInt((String)request.getParameter("hinId"));
				}
				List<OpdOphthalmologyDetails> opdOphthalmologyDetails = new ArrayList<OpdOphthalmologyDetails>();
				if (map.get("opdOphthalmologyDetails") != null) {
					opdOphthalmologyDetails = (List<OpdOphthalmologyDetails>) map.get("opdOphthalmologyDetails");
				}
				System.out.println("opdOphthalmologyDetails"+opdOphthalmologyDetails.size());
				
				List patientDataList = new ArrayList();
				if(map.get("patientDataList") != null){
					patientDataList=(List)map.get("patientDataList");
				}
				
				Visit visit= null;
				
				if(patientDataList.size() >0){
					 visit=(Visit)patientDataList.get(0);
				}
				List<MasEmployeeDependent> med = null;
				if(map.get("med") != null){
					med = (List<MasEmployeeDependent>) map.get("med");
			    			}
		%>



<form name="opthalDetails" method="post" action="">

	<div class="Block">
	<div class="clear"></div>
	 <label>Employee No.</label>
			<%if(visit.getHin().getServiceNo()!= null){ %>
			<label class="value"><%=visit.getHin().getServiceNo() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %>
	<label>Patient Name</label>
	<label class="value"><%=visit.getHin().getPFirstName() %></label>
	<label>Relation</label>
			<%if(visit.getHin().getRelation()!= null){ %>
			<label class="value"><%=visit.getHin().getRelation().getNewRelationName() %></label>
			<%}else{ %>
			<label class="value">&nbsp;</label>
			<%} %> 
	<h4>Vision</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>Uncorrected</th><th>Pinhole</th><th>Best Corrected</th><th>Uncorrected</th><th>Pinhole</th><th>Best Corrected</th></tr>
	  <tr><th>Distance</th>
	  <td><select name="dist_r_uncorrected"><option value="">Select</option>
	    <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p</option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200</option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	    <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  
	  <td><select name="dist_r_pinhole"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRPinhole().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  
	  </select></td>
	  <td><select name="dist_r_best_corrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60")?"selected":"": ""%>>6/60 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRBestCorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  <td><select name="dist_l_uncorrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p</option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200</option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	    <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLUncorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
</select></td>
	  <td><select name="dist_l_pinhole"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	  <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLPinhole().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  <td><select name="dist_l_best_corrected"><option value="">Select</option>
	  <option value="6/6-20/25" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/6-20/25")?"selected":"": ""%>>6/6-20/25</option>
	    <option value="6/6p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/6p")?"selected":"": ""%>>6/6p </option>
	    <option value="6/9-20/30" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/9-20/30")?"selected":"": ""%>>6/9-20/30 </option>
	    <option value="6/9p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/9p")?"selected":"": ""%>>6/9p </option>
	    <option value="6/12-20/40" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/12-20/40")?"selected":"": ""%>>6/12-20/40 </option>
	    <option value="6/12p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/12p")?"selected":"": ""%>>6/12p </option>
	    <option value="6/18-20/50" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/18-20/50")?"selected":"": ""%>>6/18-20/50 </option>
	    <option value="6/18p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/18p")?"selected":"": ""%>>6/18p </option>
	    <option value="6/24-20/70" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/24-20/70")?"selected":"": ""%>>6/24-20/70</option>
	    <option value="6/24p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/24p")?"selected":"": ""%>>6/24p </option>
	    <option value="6/36-20/100" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/36-20/100")?"selected":"": ""%>>6/36-20/100 </option>
	    <option value="6/36p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/36p")?"selected":"": ""%>>6/36p </option>
	    
	    <option value="6/60-20/200" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/60-20/200")?"selected":"": ""%>>6/60-20/200 </option>
	    <option value="6/60p" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("6/60p")?"selected":"": ""%>>6/60p </option>
	    <option value="3/60" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("3/60")?"selected":"": ""%>>3/60 </option>
	    <option value="CF 5 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 5 mt")?"selected":"": ""%>>CF 5 mt </option>
	    <option value="CF 4 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 4 mt")?"selected":"": ""%>>CF 4 mt </option>
	    <option value="CF 3 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 3 mt")?"selected":"": ""%>>CF 3 mt </option>
	    <option value="CF 2 mt" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 2 mt")?"selected":"": ""%>>CF 2 mt </option>
	    <option value="CF 1 mts" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CF 1 mts")?"selected":"": ""%>>CF 1 mts </option>
	    <option value="CFCF" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("CFCF")?"selected":"": ""%>>CFCF </option>
	    <option value="PL +ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("PL +ve")?"selected":"": ""%>>PL +ve </option>
	    <option value="PL -ve" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("PL -ve")?"selected":"": ""%>>PL -ve </option>
	   <option value="NIG" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("NIG")?"selected":"": ""%>>NIG </option>
	   <option value="HM+" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLBestCorrected().equalsIgnoreCase("HM+")?"selected":"": ""%>>HM+ </option>
	  </select></td>
	  </tr>
	    <tr><th>Near</th>
	  <td><select name="near_r_uncorrected"><option value="">Select</option>
	  <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	   <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	   <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	    <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	    <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRUncorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_r_pinhole"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	 <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRPinhole().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_r_best_corrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	 <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRBestCorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_uncorrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	    <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	  <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	   <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLUncorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_pinhole"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	   <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	  <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLPinhole().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
	  <td><select name="near_l_best_corrected"><option value="">Select</option>
	   <option value="N4-J1" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N4-J1")?"selected":"": ""%>>N4-J1</option>
	     <option value="N5-J2" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N5-J2")?"selected":"": ""%>>N5-J2</option>
	   <option value="N6-J3" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N6-J3")?"selected":"": ""%>>N6-J3</option>
	  <option value="N7-J4" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N7-J4")?"selected":"": ""%>>N7-J4</option>
	   <option value="N8-J5" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N8-J5")?"selected":"": ""%>>N8-J5</option>
	   <option value="N9-J6" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N9-J6")?"selected":"": ""%>>N9-J6</option>
	   <option value="N10-J7" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N10-J7")?"selected":"": ""%>>N10-J7</option>
	    <option value="N11-J8" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N11-J8")?"selected":"": ""%>>N11-J8</option>
	   <option value="N12" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N12")?"selected":"": ""%>>N12</option>
	   <option value="N14" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N14")?"selected":"": ""%>>N14</option>
	   <option value="N18" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N18")?"selected":"": ""%>>N18</option>
	   <option value="N24" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N24")?"selected":"": ""%>>N24</option>
	   <option value="N36" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("N36")?"selected":"": ""%>>N36</option>
	   <option value="NOT Possible" <%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLBestCorrected().equalsIgnoreCase("NOT Possible")?"selected":"": ""%>>NOT Possible</option>
	  </select>
	  </td>
     </tr>	  
<!-- 	  <tr><th>Near</th>
	  <td><select name="near_r_uncorrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_r_pinhole"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_r_best_corrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_uncorrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_pinhole"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
	  <td><select name="near_l_best_corrected"><option value="">Select</option><option>N5</option><option>N6</option><option>N8</option><option>N10</option><option>N12</option><option>N14</option><option>N18</option><option>N14</option><option>N18</option><option>N24</option><option>N36</option></select></td>
</tr>	  --> 
	</table>
	<div class="clear"></div>
	<%-- <label>IPD</label><input type="text" name="vision_ipd" maxlength="50" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getVisionIpd()!=null?opdOphthalmologyDetails.get(0).getVisionIpd():"": ""%>"/><label class="unit">mm</label> --%>
	<label>Fundus Glow</label><input type="text" class="large" name="vision_fundus" maxlength="50" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getVisionFundus()!=null?opdOphthalmologyDetails.get(0).getVisionFundus():"": ""%>"/>
	<div class="clear"></div><div class="clear"></div>
	
	
	<h4>Retinoscopy</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="2" style="text-align: center;">R.E.</th><th colspan="2"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th></th><th>Axis</th><th></th><th>Axis</th></tr>
	  <tr><th>V</th><td><input type="text" name="retinoscopy_re_v"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReV()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReV():"": ""%>" /></td><td><input value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReAxis()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReAxis():"": ""%>" name="retinoscopy_re_axis" maxlength="5"/></td><td><input type="text" name="retinoscopy_le_v"  maxlength="20"  value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeV()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeV():"": ""%>" /></td><td><input value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeAxis()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeAxis():"": ""%>" name="retinoscopy_le_axis" maxlength="5"/></td></tr>
	  <tr><th>H</th><td><input type="text" name="retinoscopy_re_h"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyReH()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyReH():"": ""%>" /></td><td></td><td><input type="text" name="retinoscopy_le_h"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinoscopyLeH()!=null?opdOphthalmologyDetails.get(0).getRetinoscopyLeH():"": ""%>" /></td><td></td></tr>
	   
	</table>
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	
	  <tr><th colspan="5" style="text-align: center;">R.E.</th><th colspan="5"style="text-align: center;">L.E.</th></tr>
	  <tr><th>Keratometry</th><th>Pachymetry</th><th>Non-contact Tonometry</th><th>Field of VN</th><th>IOL</th><th>Keratometry</th><th>Pachymetry</th><th>Non-contact Tonometry</th><th>Field of VN</th><th>IOL</th></tr>
	  <tr><td><input type="text"  size="30" name="re_keratometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReKeratometry()!=null?opdOphthalmologyDetails.get(0).getReKeratometry():"": ""%>" maxlength="40" size="6"/><label class="auto">D</label></td><td><input type="text" name="re_pachymetry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRePachymetry()!=null?opdOphthalmologyDetails.get(0).getRePachymetry():"": ""%>" maxlength="20" size="6"/><label class="auto">UM</label></td><td><input type="text" name="re_Non_contact_tonometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReNonContactTonometry()!=null?opdOphthalmologyDetails.get(0).getReNonContactTonometry():"": ""%>" maxlength="20"size="10"/><label class="auto">mm of Hg</label></td><td><input type="text" name="re_field_vn" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFieldVn()!=null?opdOphthalmologyDetails.get(0).getReFieldVn():"": ""%>"/></td><td><input type="text" name="iol_re" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getIolRe()!=null?opdOphthalmologyDetails.get(0).getIolRe():"": ""%>"/></td><td><input type="text" size="30" name="le_keratometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeKeratometry()!=null?opdOphthalmologyDetails.get(0).getLeKeratometry():"": ""%>"  maxlength="40"size="6"/><label class="auto">D</label></td><td><input type="text" name="le_pachymetry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLePachymetry()!=null?opdOphthalmologyDetails.get(0).getLePachymetry():"": ""%>"  maxlength="20"size="6"/><label class="auto">UM</label></td><td><input type="text" name="le_Non_contact_tonometry" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeNonContactTonometry()!=null?opdOphthalmologyDetails.get(0).getLeNonContactTonometry():"": ""%>"  maxlength="20"size="10"/><label class="auto">mm of Hg</label></td><td><input type="text" name="le_field_vn"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFieldVn()!=null?opdOphthalmologyDetails.get(0).getLeFieldVn():"": ""%>"/></td><td><input type="text" name="iol_le" maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getIolLe()!=null?opdOphthalmologyDetails.get(0).getIolLe():"": ""%>"/></td></tr>
	</table>
	</div>
	<h4>Spectacle Correction</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th></th><th colspan="3" style="text-align: center;">R.E.</th><th colspan="3"style="text-align: center;">L.E.</th></tr>
	  <tr><th></th><th>SPH</th><th>CYL</th><th>Axis</th><th>SPH</th><th>CYL</th><th>Axis</th></tr>
	  <tr><th>Dist</th><td><input type="text" name="dist_r_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRSph()!=null?opdOphthalmologyDetails.get(0).getDistRSph():"": ""%>" validate="R.E Dist SPH,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_r_cyl" name="dist_r_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRCyl()!=null?opdOphthalmologyDetails.get(0).getDistRCyl():"": ""%>" validate="R.E Dist CYL,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_r_axix" name="dist_r_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistRAxis()!=null?opdOphthalmologyDetails.get(0).getDistRAxis():"": ""%>"validate="R.E Dist Axix,string,no" maxlength="20"/></td><td><input type="text" name="dist_l_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLSph()!=null?opdOphthalmologyDetails.get(0).getDistLSph():"": ""%>" validate="L.E Dist SPH,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_l_cyl" name="dist_l_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLCyl()!=null?opdOphthalmologyDetails.get(0).getDistLCyl():"": ""%>" validate="L.E DistCYL,string,no" maxlength="20"/></td><td><input type="text" onblur="copyValues();" id="dist_l_axix" name="dist_l_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getDistLAxis()!=null?opdOphthalmologyDetails.get(0).getDistLAxis():"": ""%>" validate="L.E Dist Axix,string,no" maxlength="20"/></td></tr>
	  <tr><th>Near</th><td><input type="text" name="near_r_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRSph()!=null?opdOphthalmologyDetails.get(0).getNearRSph():"": ""%>" validate="R.E Near SPH,string,no" maxlength="20"/></td><td><input type="text" id="near_r_cyl"  name="near_r_cyl"value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRCyl()!=null?opdOphthalmologyDetails.get(0).getNearRCyl():"": ""%>" validate="R.E Near CYL,string,no" maxlength="20"/></td><td><input type="text"  id="near_r_axix" name="near_r_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearRAxis()!=null?opdOphthalmologyDetails.get(0).getNearRAxis():"": ""%>" validate="R.ENear Axix ,string,no" maxlength="20"/></td><td><input type="text" name="near_l_sph" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLSph()!=null?opdOphthalmologyDetails.get(0).getNearLSph():"": ""%>" validate="L.E Near SPH,string,no" maxlength="20"/></td><td><input type="text" id="near_l_cyl" name="near_l_cyl" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLCyl()!=null?opdOphthalmologyDetails.get(0).getNearLCyl():"": ""%>" validate="L.E Near CYL,string,no" maxlength="20"/></td><td><input type="text" id="near_l_axix" name="near_l_axix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getNearLAxis()!=null?opdOphthalmologyDetails.get(0).getNearLAxis():"": ""%>" validate="L.E Near Axix,string,no" maxlength="20"/></td></tr>
	</table>
	<label>IPD(50-70)</label> <input type="text" name="eye_ipd" maxlength="2" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getEyeIpd()!=null?opdOphthalmologyDetails.get(0).getEyeIpd():"": ""%>" validate="Eye IPD ,string,no">
	
	<label>Use</label><select name="eye_use"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getEyeUse()!=null && opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Constant")){%>
	    <option selected="selected">Constant</option>
	<%}else{%> 
	 <option>Constant</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 &&  opdOphthalmologyDetails.get(0).getEyeUse()!=null && opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Near")){%>
	<option selected="selected">Near</option>
	<%}else{%>
		<option>Near</option>
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getEyeUse()!=null &&  opdOphthalmologyDetails.get(0).getEyeUse().equalsIgnoreCase("Distance")){%>
	<option selected="selected" >Distance</option>
	<%}else{%>
	<option >Distance</option>
	<%} %>
	</select>
	<label>Type of Lens</label><select name="lensType"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Kryptok")){%>
	    <option selected="selected">Kryptok</option>
	<%}else{%> 
	 <option>Kryptok</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Executive/Bifocal")){%>
	<option selected="selected">Executive/Bifocal</option>
	<%}else{%>
		<option>Executive/Bifocal</option>
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLensType()!=null && opdOphthalmologyDetails.get(0).getLensType().equalsIgnoreCase("Progressive")){%>
	<option selected="selected" >Progressive</option>
	<%}else{%>
	<option >Progressive</option>
	<%} %>
	</select>

	<h4>On Examination:</h4>
	<h4>Anterior Segment</h4>
	<div class="cmntable">
		<table border="0" align="center" cellpadding="0" cellspacing="0">
		<!--   <tr><th colspan="13" style="text-align: center;">R.E.</th><th colspan="13"style="text-align: center;">L.E.</th></tr> -->
		  <tr><th></th><th>Eyebrow</th><th>Eyelid</th><th>Cornea</th><th>Conjunctiva</th><th>Fornix</th><th>Limbus</th><th>Sclera</th><th>Anterior Chamber</th><th>Iris</th><th>Pupils</th><th>Lens</th><th>Anterior</th><th>Vitreous</th><!-- <th>Eyebrow</th><th>Eyelid</th><th>Cornea</th><th>Conjunctiva</th><th>Fornix</th><th>Limbus</th><th>Sclera</th><th>Anterior Chamber</th><th>Iris</th><th>Pupils</th><th>Lens</th><th>Anterior</th><th>Vitreous</th> --></tr>
		  <tr><th>R.E</th><td><input type="text" name="re_eyebrow"  maxlength="20" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReEyebrow()!=null?opdOphthalmologyDetails.get(0).getReEyebrow():"N": "N"%>"/></td><td><input type="text" name="re_eyelid" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReEyelid()!=null?opdOphthalmologyDetails.get(0).getReEyelid():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_cornea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReCornea()!=null?opdOphthalmologyDetails.get(0).getReCornea():"N": "N"%>" maxlength="20" /></td><td><input type="text" name="re_conjunction" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReConjunction()!=null?opdOphthalmologyDetails.get(0).getReConjunction():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_fornix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFornix()!=null?opdOphthalmologyDetails.get(0).getReFornix():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_limbus" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReLimbus()!=null?opdOphthalmologyDetails.get(0).getReLimbus():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_sclera" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReSclera()!=null?opdOphthalmologyDetails.get(0).getReSclera():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_anterior_chamber" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReAnteriorChamber()!=null?opdOphthalmologyDetails.get(0).getReAnteriorChamber():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_iris" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReIris()!=null?opdOphthalmologyDetails.get(0).getReIris():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_pupils" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRePupils()!=null?opdOphthalmologyDetails.get(0).getRePupils():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_Lens" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReLens()!=null?opdOphthalmologyDetails.get(0).getReLens():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_anterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReAnterior()!=null?opdOphthalmologyDetails.get(0).getReAnterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_vitreous" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReVitreousAnterior()!=null?opdOphthalmologyDetails.get(0).getReVitreousAnterior():"N": "N"%>" maxlength="20"/></td></tr>
		  	       <tr><th>L.E.</th><td><input type="text" name="le_eyebrow" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeEyebrow()!=null?opdOphthalmologyDetails.get(0).getLeEyebrow():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_eyelid" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeEyelid()!=null?opdOphthalmologyDetails.get(0).getLeEyelid():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_cornea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeCornea()!=null?opdOphthalmologyDetails.get(0).getLeCornea():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_conjunction" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeConjunction()!=null?opdOphthalmologyDetails.get(0).getLeConjunction():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_fornix" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFornix()!=null?opdOphthalmologyDetails.get(0).getLeFornix():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_limbus" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeLimbus()!=null?opdOphthalmologyDetails.get(0).getLeLimbus():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_sclera" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeSclera()!=null?opdOphthalmologyDetails.get(0).getLeSclera():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_anterior_chamber" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeAnteriorChamber()!=null?opdOphthalmologyDetails.get(0).getLeAnteriorChamber():"N": "N"%>"maxlength="20"/></td><td><input type="text" name="le_iris"value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeIris()!=null?opdOphthalmologyDetails.get(0).getLeIris():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_pupils" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLePupils()!=null?opdOphthalmologyDetails.get(0).getLePupils():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_Lens" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeLens()!=null?opdOphthalmologyDetails.get(0).getLeLens():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_anterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeAnterior()!=null?opdOphthalmologyDetails.get(0).getLeAnterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_vitreous" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeVitreousAnterior()!=null?opdOphthalmologyDetails.get(0).getLeVitreousAnterior():"N": "N"%>" maxlength="20"/></td></tr>
	 
		</table>
	 </div>

	<h4>Posterior Segment</h4>
	<div class="cmntable">
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	<!--   <tr><th colspan="4" style="text-align: center;">R.E.</th><th colspan="4"style="text-align: center;">L.E.</th></tr> -->
	  <tr><th></th><th>Optic Disc</th><th>Fovea and Macula</th><th>Vitreous</th><th>Blood Vessels</th><th>Retina</th></tr>
	  <tr><th>R.E.</th><td><input type="text" name="re_optic_disc" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReOpticDisc()!=null?opdOphthalmologyDetails.get(0).getReOpticDisc():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_fovea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReFovea()!=null?opdOphthalmologyDetails.get(0).getReFovea():"N": "N"%>" maxlength="20"/><td><input type="text" name="re_vitreous_posterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReVitreousPosterior()!=null?opdOphthalmologyDetails.get(0).getReVitreousPosterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="re_blood_vessels" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getReBloodVessels()!=null?opdOphthalmologyDetails.get(0).getReBloodVessels():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="retina_re" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinaRe()!=null?opdOphthalmologyDetails.get(0).getRetinaRe():"N": "N"%>" maxlength="20"/></td></tr>
	  <tr><th>L.E.</th><td><input type="text" name="le_optic_disc" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeOpticDisc()!=null?opdOphthalmologyDetails.get(0).getLeOpticDisc():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_fovea" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeFovea()!=null?opdOphthalmologyDetails.get(0).getLeFovea():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_vitreous_posterior" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeVitreousPosterior()!=null?opdOphthalmologyDetails.get(0).getLeVitreousPosterior():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="le_blood_vessels" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getLeBloodVessels()!=null?opdOphthalmologyDetails.get(0).getLeBloodVessels():"N": "N"%>" maxlength="20"/></td><td><input type="text" name="retina_le" value="<%=opdOphthalmologyDetails.size()>0?opdOphthalmologyDetails.get(0).getRetinaLe()!=null?opdOphthalmologyDetails.get(0).getRetinaLe():"N": "N"%>" maxlength="20"/></td></tr>
	</table>
	</div>
	<h4>Colour Vision</h4>
	<table border="0" align="center" cellpadding="0" cellspacing="0">
	  <tr><th colspan="1" style="text-align: center;">R.E.</th><th colspan="1"style="text-align: center;">L.E.</th></tr>
	  <tr><td>
	  
	  	  <select name="re_colour_vision"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getReColourVision()!=null && opdOphthalmologyDetails.get(0).getReColourVision().equalsIgnoreCase("Normal")){%>
	    <option selected="selected">Normal</option>
	<%}else{%> 
	 <option>Normal</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getReColourVision()!=null && opdOphthalmologyDetails.get(0).getReColourVision().equalsIgnoreCase("Defective")){%>
	<option selected="selected">Defective</option>
	<%}else{%>
		<option>Defective</option>
	<%}%>
	</select>
	  
	  </td>
	  <td>
	  	  <select name="le_colour_vision"><option value="">Select</option>
	<%
	if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLeColourVision()!=null && opdOphthalmologyDetails.get(0).getLeColourVision().equalsIgnoreCase("Normal")){%>
	    <option selected="selected">Normal</option>
	<%}else{%> 
	 <option>Normal</option>
	
	<%}if(opdOphthalmologyDetails.size()>0 && opdOphthalmologyDetails.get(0).getLeColourVision()!=null && opdOphthalmologyDetails.get(0).getLeColourVision().equalsIgnoreCase("Defective")){%>
	<option selected="selected">Defective</option>
	<%}else{%>
		<option>Defective</option>
	<%}%>
	</select>
	  
	  </td></tr>
	  

	  
	  
	  </table>
	  
	
	</div>
<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> --%>

	 <input id="visitId" name="visitId" type="hidden" value="<%=visit.getId()%>" />  
		 <input name="consultationDate" type="hidden" value="<%=currentDate%>" />
	     <input name="consultationTime" type="hidden" value="<%=currentTime%>" /> 
		
<div class="clear"></div>

<input name="Submit11" type="button" tabindex="1" align="right"
		class="button" value="Submit"onclick="submitForm('opthalDetails','opd?method=submitOphthalmolgyDetails');"/> <input
		name="Reset" type="reset" tabindex="1" align="right" class="button"
		value="Reset" onclick="resetdata()" />
<div class="division"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="bottom"><label>Changed By </label> <label
	class="value"><%=userName %></label> <label>Changed Date </label> <label
	class="value"><%=currentDate %></label> <label>Changed Time </label> <label
	class="value"><%=currentTime%></label></div>

       </form>
       
       
 <script language="javascript">

function copyValues()
{
	
	document.getElementById("near_r_cyl").value= document.getElementById("dist_r_cyl").value;
	document.getElementById("near_r_axix").value = document.getElementById("dist_r_axix").value;
	
	document.getElementById("near_l_axix").value = document.getElementById("dist_l_axix").value;
	document.getElementById("near_l_cyl").value = document.getElementById("dist_l_cyl").value;
}

</script>


