<%@page import="jkt.hms.masters.business.TherapyDetails"%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>


<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.OpdQaMaster"%>
<%@page import="jkt.hms.masters.business.OpdQaTransation"%>


<%@page import="jkt.hms.util.HMSUtil"%>
<%-- <%@ taglib uri="http://www.owasp.org/index.php/Category:OWASP_CSRFGuard_Project/Owasp.CsrfGuard.tld" prefix="csrf" %>
<script type="text/javascript" language="javascript"  src="/hms/JavaScriptServlet">
</script> --%>
<script type="text/javascript">
/* var csrfTokenName='<csrf:tokenname />';
var csrfTokenValue='<csrf:tokenvalue />'; */
 var csrfTokenName='${_csrf.parameterName}';
 var csrfTokenValue='${_csrf.token}';
</script>
<script type="text/javascript"  src="/hms/jsp/js/csrfToken.js"></script>

<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/list.js"></script>
<%
				Map<String, Object> map = new HashMap<String, Object>();
				List<TherapyDetails> previousTherapyList=new ArrayList<TherapyDetails>();
				List<OpdQaTransation > questionnaireTransactionList = new ArrayList<OpdQaTransation>();
				//System.out.println("dd"+questionnaireList.size());
				String message = "";
				int visitId=0;
				if(request.getAttribute("map") != null){
					map = (Map) request.getAttribute("map");
				}
				if(map.get("message")!= null){
					message = (String)map.get("message");
				}
				if(map.get("previousTherapyList")!= null){
					previousTherapyList = (List<TherapyDetails>)map.get("previousTherapyList");
				}
				String departmentCodeForPhychiatrist = HMSUtil.getProperties("adt.properties", "departmentCodeForPhychiatrist");
				String dentalDepartmentCode = HMSUtil.getProperties("adt.properties", "departmentCodeForDental");		
			
				
//System.out.println("ff"+questionnaireTransactionList.size());
		%>
				



<input type="hidden" value="<%=visitId%>" id="visitId" name="visitId">
<div class="titleBg"> <h2>Previous <%=previousTherapyList.size()>0?departmentCodeForPhychiatrist.equalsIgnoreCase(previousTherapyList.get(0).getProcedureHeader().getVisit().getDepartment().getDepartmentCode())?"Therapy":dentalDepartmentCode.equalsIgnoreCase(previousTherapyList.get(0).getProcedureHeader().getVisit().getDepartment().getDepartmentCode())?"Dental Procedure":"":"" %> session List</h2></div>
<div class="clear"></div>

<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
		 <!--  <label>Referral Notes</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	<label>Advice</label><textarea type="text" name="doctorAdvice"  maxlength="200"class="large"></textarea>
		  	 -->
		  	<table>
		  	<tr><th>S.No</th>
		  	<th>Name</th>
		  	<th>Appointment Date/Time</th>
		  	<th>Status</th>
		  	<th>Remarks</th>
		  	</tr>
		  	
		  	<%
		  	int hbt=0;
		  	for(TherapyDetails therapyDt:previousTherapyList){ 
		  		
		  	%>
		  	<tr>
		  	<td><%=++hbt%></td>
		  	<td><%=therapyDt.getProcedure().getNursingName()%></td>
		  	<td><%=therapyDt.getAppointmentDate()!=null?HMSUtil.convertDateToStringTypeDateOnly(therapyDt.getAppointmentDate())+"/"+therapyDt.getAppointmentTime():""%></td>
		  	<td><%=therapyDt.getStatus().equalsIgnoreCase("y")?"Completed":"Not Completed"%></td>
		  	<td>
	           <%=therapyDt.getTherapyRemarks()!=null?therapyDt.getTherapyRemarks():""%>
		  	</td>
		  	</tr>
		  	<%} %>
		  	
		  	</table>
		  

</div>

<!-- <input name="add" type="button" class="button" value="Submit" onClick="jsImport();"/> -->


<input name="add" type="button" class="button" value="Close" onClick="window.close();"/>
<div class="clear"></div>
<div class="division"></div>


<div class="clear"></div>




<script language="javascript">

function jsImport()
{
/* 	if (document.getElementById('fileNameId').value == "")
	{
    	alert('Please select a file to Upload');
  	    return;
	} */
	//var fname = document.getElementById('fileNameId').value;
	var visitId= document.getElementById("visitId").value;
	//var ind1 = fname.lastIndexOf("\\");
	//var filename = fname.substring(ind1+1);
	//document.getElementById("fileName").value=filename;
	//document.getElementById("flag").value="y";
	document.submitQuestionnaire.method="post";
	submitForm('submitQuestionnaire','opd?method=submitPhychiatristAnswer&visitId='+visitId+'&'+csrfTokenName+'='+csrfTokenValue);
	
}

</script>