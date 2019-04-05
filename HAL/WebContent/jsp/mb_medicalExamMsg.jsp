<%@page import="java.util.Map"%>
<%@page import="java.util.*" %>
<%@page import="java.util.HashMap"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	String message = "";
	String formName = "";
	String hinNo = "";
	String data = "";

	int id=0;
	int entryNo = 0;
	int visitId=0;
	String hinNoForreport=null;
	int visitNumberForReport=0;
	String serviceNoForReport=null;
	if(request.getAttribute("map") != null){
		map = (Map<String,Object>)request.getAttribute("map");
	}
	if(map.get("message") != null){
		message = (String)map.get("message");
	}
	int hin_id=0;
	if(map.get("hin_id") != null)
	  {
		hin_id= (Integer)map.get("hin_id");
	  }
	

	if(map.get("formName") != null){
		formName = (String)map.get("formName");
	}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	 }
	if (map.get("serviceNo") != null) {
		serviceNoForReport = (String) map.get("serviceNo");
 	}
	if (map.get("hinNoForreport") != null) {
		hinNoForreport = (String) map.get("hinNoForreport");
 	}
	if (map.get("data") != null) {
		data = (String) map.get("data");
 	}
	System.out.println("data-------jsp->>>>"+data);
	if (map.get("visitNumberForReport") != null) {
		visitNumberForReport = (Integer) map.get("visitNumberForReport");
 	}
	if (map.get("visitId") != null) {
		visitId = (Integer) map.get("visitId");
 	}
	String dgOrderNO="";
	 if (map.get("dgOrderNO") != null) {
		 dgOrderNO = (String) map.get("dgOrderNO");
	}
	String admissionStatus="n";
	if (map.get("admissionStatus") != null) {
		admissionStatus = (String) map.get("admissionStatus");
	}
	String directFlag="";
	if (map.get("directFlag") != null) {
		directFlag = (String) map.get("directFlag");
	}
	if(!message.equalsIgnoreCase("")){
	if(message.equalsIgnoreCase("You Can Forward Data After Submited By Medical Assistence")|| message.equalsIgnoreCase("Lab Result is not Found ! You Can Forward to Medical Officer After Lab Result.")){%>
<h4><%=message %></h4>

<input name="Back" type="hidden" value="Back" class="button"onclick="history.go(-1);return false;"/>
<% }else{%>
<h4><%=message %></h4>
<%} %>
<%} %>
<form name="message" method="post">
<div class="clear"></div>
<%		
		if(map.get("medExamId") != null){
			id = Integer.parseInt(map.get("medExamId").toString());
		}



		String medicalExamType = "";
		if(map.get("medicalExamType")!= null){
			medicalExamType = (String)map.get("medicalExamType");
		}
		String printReport = null;
		if(map.get("printReport")!= null){
			printReport = (String)map.get("printReport");
		} 
		String medicalType="";
		if(map.get("medicalType")!= null){
			medicalType = (String)map.get("medicalType");
		}
		List<String>  investigationReferToMH = new ArrayList<String>();
		
	 if(map.get("investigationReferToMHList")!= null)
	   {
		 investigationReferToMH = (List)map.get("investigationReferToMHList");
	   }
	 String  dentalReferToMH = "";
	 if(map.get("denatlToMH")!= null)
	 {
		 dentalReferToMH = (String)map.get("denatlToMH"); 
	 }
	%>
<div class="clear"></div>
<% if(admissionStatus.equalsIgnoreCase("y")){
	%>
<h2>Do you want to Print Medical Case Sheet</h2>
<div class="division"></div>
<input type="button" name="report" class="button" id="report" value="Ok" accesskey="a"
 onclick="submitForm('message','medicalExam?method=printMedicalCaseSheetForMedicalExam&medExamId=<%=id %>&visitId=<%=visitId%>');"/>
<input type="button" name="report1" class="button" id="report1"	onClick="javascript:history.back();" value="NO"	accesskey="a" />
<div class="clear"></div>
<div class="division"></div>
<%} %>
<%if(id !=0 && printReport!=null && printReport.equalsIgnoreCase("yes")){ %>
 <div class="division"></div>
<%if(medicalType.equalsIgnoreCase("MedicalBoard") && medicalExamType.equalsIgnoreCase("Medical Board AFMSF 16")){ %>
 	 <%--
	<input type="button" name="report" class="button" id="report"	onclick="submitForm('message','/hms/hms/medicalExaminationBoard?method=printMedicalBoard&Id=<%=id%>&medicalExamType=<%=medicalExamType %>&visit_id=<%=visitId %>','checkTargetForYes');" />
	 --%>
<input type="hidden" name="button" value="Case Sheet" class="button"
	onclick="submitForm('message','/hms/hms/medicalExaminationBoard?method=printMedicalBoard&reportType=Specialist&Id=<%=id%>&medicalExamType=<%=medicalExamType %>&order_no=<%=dgOrderNO %>','checkTargetForYes');" />
<input type="button" name="report" class="buttonBig" id="report" onclick="printmedicalBoardForm16();" 
		value="Print AFMSF -16"	accesskey="a" />
		
		<div class="Clear"></div>
<label class="large2">Certificate for Commutation for Pension</label>
<input type="checkbox" id="p1" name="p1" value="p1" tabindex="1" />

<div class="clear"></div>
<label class="large2">Unwillingness Certificate For Treatment</label>
<input type="checkbox" id="p2" name="p2" value="p2" tabindex="1">

<div class="clear"></div>
<label class="large2">Acceptance Certificate</label>
<input type="checkbox" id="p3" name="p3" value="p3" tabindex="1">

<div class="clear"></div>
<label class="large2"> Certificate By Medical Board</label>
<input type="checkbox" id="p4" name="p4" value="p4" tabindex="1">
<div class="clear"></div>
<label class="large2">Weight Record Card</label>
<input type="checkbox" id="p5" name="p5" value="p5" tabindex="1">
<div class="clear"></div>
<label class="large2">Letter Of Caution(Case of Obesity)</label>
<input type="checkbox" id="p6" name="p6" value="p6" tabindex="1">
<div class="clear"></div>
<label class="large2">Certificate of Undertaking</label>
<input type="checkbox" id="p7" name="p7" value="p7" tabindex="1">

<div class="clear"></div>
<div class="division"></div>
<% 
if(request.getParameter("p1")!= null)
      {  %>   
	     <input type="hidden" id="p1" name="p1" value="p1" />    
       <%  }
   if(request.getParameter("p2")!= null)
     { %>    
	   <input type="hidden" id="p2" name="p2" value="p2" />    
    <%  }
   if(request.getParameter("p3")!= null)
   { %>    
	   <input type="hidden" id="p3" name="p3" value="p3" />    
  <%  }
   if(request.getParameter("p4")!= null)
   {  %>   
	   <input type="hidden" id="p4" name="p4" value="p4" />    
  <%  }
  
   if(request.getParameter("p5")!= null)
   { %>    
	   <input type="hidden" id="p5" name="p5" value="p5" />
	     
  <%  }
 
  
   if(request.getParameter("p6")!= null)
   { %>    
	   <input type="hidden" id="p6" name="p6" value="p6" />    
  <%  }
 
  
   if(request.getParameter("p6")!= null)
   { %>    
	   <input type="hidden" id="p6" name="p6" value="p6" />    
  <%  }%> 
	
	 <input type="hidden" id="serviceNoForReport" name="serviceNoForReport" value="<%=serviceNoForReport %>" /> 
<input type="button" name="yes" value="Print" class="button"	onclick="submitForm('message','/hms/hms/medicalBoard?method=printMedicalBoard&medExamId=<%=id %>&order_no=<%=dgOrderNO %>&hin_id=<%=hin_id%>&serviceNoForReport=<%=serviceNoForReport%>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('message','/hms/hms/medicalBoard?method=showMedicalOfficerAppointment');" />
	
<% }else if(medicalType.equalsIgnoreCase("MedicalBoard")){ %>
 <%--
<input type="button" name="report" class="button" id="report"	onclick="submitForm('message','/hms/hms/medicalExaminationBoard?method=printMedicalBoard&Id=<%=id%>&medicalExamType=<%=medicalExamType %>&visit_id=<%=visitId %>','checkTargetForYes');" />
<input type="button" name="hidden" value="Case Sheet" class="button"
onclick="submitForm('message','/hms/hms/medicalExaminationBoard?method=printMedicalBoard&reportType=Specialist&Id=<%=id%>&medicalExamType=<%=medicalExamType %>&order_no=<%=dgOrderNO %>','checkTargetForYes');" />
--%><input type="button" name="report" class="buttonBig" id="report"	onclick="submitFormForMBProceedingInitialAFMSFReport();" value="Print AFMSF -15"	accesskey="a" />
<input type="button" name="report" class="buttonBig" id="report" onclick="printmedicalBoardForm79();" 
		value="Print AFMSF -79"	accesskey="a" />	
<% }} %>
 <!--<input type="button" name="yes" value="Yes" class="button"
onclick="submitForm('message','/hms/hms/medicalExaminationBoard?method=printMedicalBoard&Id=<%=id%>&medicalExamType=<%=medicalExamType %>&order_no=<%=dgOrderNO %>','checkTargetForYes');" />
<div class="clear"></div><div class="division"></div>-->
<%
try
{
	boolean flag=false;
	for(int i=0; i<investigationReferToMH.size(); i++ )
	{  
	if(flag==false)
	{
	if(investigationReferToMH.get(i).equals("y"))
   	{
   		flag=true;%>    
<input type="button" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="Print Investigation Requisition"	class="buttonBig2" accesskey="a" />
<!--<input type="button" name="yes" value="Print Dental Requisition" class="buttonBig" onclick="submitFormForDentalReport();"/>
<input type="button" name="blankReport" value="Blank Print Dental Requisition" class="buttonBig" onclick="submitFormForBlankDentalReport();"/>		
		
--><% }}}	
	 if(dentalReferToMH.equals("yes") && !data.equalsIgnoreCase("farwarded") )
	{ %>
	<input type="button" name="yes" value="Print Dental Requisition" class="buttonBig2" onclick="submitFormForDentalReport();"/>
	<% }%>
	<%if(directFlag.equalsIgnoreCase("N")){ %>
	<input type="button" value="Close" class="button"onclick="window.close()">
	<%} %>
	<%	
 }
catch(Exception e)
 { 
	e.printStackTrace();
} %>
 <!--<input type="button" name="no" value="No" class="button"
	onclick="submitForm('message','/hms/hms/medicalExam?method=showMedicalExaminationBoardJsp','checkTargetForNo');" />
-->
<input type="hidden" name="hinNoForreport" value="<%=hinNoForreport %>" id="hinNoForreport"/>
<div class="clear"></div>
<%
		if(formName != ""){
	%> <input type="button" value="Close" class="button"onclick="window.close()"> <%} %>
</form>
<script	type="text/javascript">
function submitFormForPrescriptionReport(){
	  var hinNoForreport12=document.getElementById('hinNoForreport').value;
	  var url='/hms/hms/medicalExam?method=showPatientInvestigationReport&Requestedjsp=MedicalExam&visitNumberForReport='+<%=visitNumberForReport%>+'&hinNoForReport='+hinNoForreport12+'&serviceNoForReport='+<%=serviceNoForReport%>+'&medExamId='+<%=id %>;
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	
	}
function submitFormForDentalReport(){
	//  var hinNoForreport12=document.getElementById('hinNoForreport').value;
	  var url='/hms/hms/medicalExam?method=generateDentalReport&visit_id=<%=visitId%>';
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	}
function printmedicalBoardForm16(){
	 var url='/hms/hms/medicalBoard?method=generateMedicalBoardForm16&visit_id=<%=visitId%>';
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	}
function printmedicalBoardForm79(){
	 var url='/hms/hms/medicalBoard?method=generateAFMSFR79eport&visit_id=<%=visitId%>';
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	}
function submitFormForMBProceedingInitialAFMSFReport(){
	 var url='/hms/hms/medicalBoard?method=generateProceedingInitialAFMSFReport&visitId=<%=visitId%>';
	 newwindow=window.open(url,'ar',"left=2,top=0,height=800,width=900,status=1,scrollbars=1,resizable=1");
	}
</script>
