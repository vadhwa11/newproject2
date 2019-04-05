<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>

<%
Map<String, Object> map = new HashMap<String, Object>();
String message = "";
String formName = "";
String hinNo = "";
int id=0;
int entryNo = 0;
int visitId=0;
int medExamId=0;
int hin_id=0;
 int unitId = 0;
String hinNoForreport=null;
int visitNumberForReport=0;
String serviceNoForReport=null;
if(request.getAttribute("map") != null){
	map = (Map<String, Object>)request.getAttribute("map");
}
if(map.get("message") != null){
	message = (String)map.get("message");
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
System.out.println("serviceNoForReport==="+serviceNoForReport);
if (map.get("hinNoForreport") != null) {
	hinNoForreport = (String) map.get("hinNoForreport");
}
System.out.println("hinNoForreport==="+hinNoForreport);
if (map.get("visitNumberForReport") != null) {
	visitNumberForReport = (Integer) map.get("visitNumberForReport");
}
System.out.println("visitNumberForReport==="+visitNumberForReport);
if (map.get("unitId") != null) {
	unitId = (Integer) map.get("unitId");
}
System.out.println("unitId==="+unitId);

if (map.get("visitId") != null) {
	visitId = (Integer) map.get("visitId");
}
System.out.println("visitId==="+visitId);
if(map.get("hin_id") != null)
  {
	hin_id= (Integer)map.get("hin_id");
  }
if(map.get("medExamId")!= null){
	medExamId = (Integer)map.get("medExamId");
	
}
String dgOrderNO="";
if (map.get("dgOrderNO") != null) {
 dgOrderNO = (String) map.get("dgOrderNO");
}
String investigationReferToMH = "";
if(map.get("investigationReferToMH") != null)
  {
	investigationReferToMH =(String) map.get("investigationReferToMH");
  }
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");

%>

<%@page import="java.util.Date"%>
<%@page import="jkt.hms.util.HMSUtil"%><form name="messageForAnnualExam" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<label class="large2">Medical Certificate IAF Personnel Proceeding Abroad For Less Than 30 Days</label>
<input type="checkbox" id="IAFPrint" name="IAFPrint" value="i" tabindex="1" />

<div class="clear"></div>
<label class="large2">Medical Certificate Service Personnel Proceeding Abroad</label>
<input type="checkbox" id="ProceedingAbroad" name="ProceedingAbroad" value="pa" tabindex="1">

<div class="clear"></div>
<label class="large2">Medical Certificate Fitness For Proceeding Abroad Families Of Service Personnel</label>
<input type="checkbox" id="FitnessProceedingAbroad" name="FitnessProceedingAbroad" value="fpa" tabindex="1">

<div class="clear"></div>
<label class="large2"> Medical Card</label>
<input type="checkbox" id="MedicalCard" name="MedicalCard" value="mc" tabindex="1">
<div class="clear"></div>
<label class="large2">Medical Fitness Certificate For Proceeding On Course</label>
<input type="checkbox" id="proceedingoncourse" name="proceedingoncourse" value="pc" tabindex="1">

<div class="clear"></div>
<label class="large2">Form- 44(AFMSF- 44)</label>
<input type="checkbox" id="form44Id" name="form44" onclick="displayForm44()"  tabindex="1">

<div class="clear"></div>
<div class="division"></div>
<% 
if(request.getParameter("IAFPrint")!= null)
      {  %>   
	     <input type="hidden" id="IAFPrint" name="IAFPrint" value="i" />    
       <%  }
   if(request.getParameter("ProceedingAbroad")!= null)
     { %>    
	   <input type="hidden" id="ProceedingAbroad" name="ProceedingAbroad" value="pa" />    
    <%  }
   if(request.getParameter("FitnessProceedingAbroad")!= null)
   { %>    
	   <input type="hidden" id="FitnessProceedingAbroad" name="FitnessProceedingAbroad" value="fpa" />    
  <%  }
   if(request.getParameter("MedicalCard")!= null)
   {  %>   
	   <input type="hidden" id="MedicalCard" name="MedicalCard" value="mc" />    
  <%  }
  
   if(request.getParameter("proceedingoncourse")!= null)
   { %>    
	   <input type="hidden" id="proceedingoncourse" name="proceedingoncourse" value="pc" />    
  <%  }%> 

<script>
function submitForm44(){
	submitForm('messageForAnnualExam','opd?method=showPatientForm44Report&hinNoForReport=<%=hinNoForreport %>&visitNumberForReport=<%=visitNumberForReport %>&serviceNoForReport=<%=serviceNoForReport%>&unitId=<%=unitId%>&date=<%=date%>','checkTargetForYes');
	checkTargetForNo();
}
function displayForm44(){
	//alert("sdfds");
	if(document.getElementById('form44Id').checked = true){
		document.getElementById('printForm44Id').style.display = 'block';
	}
}

</script>	
<input type="button" name="yes" value="Print" class="button" 	onclick="submitForm('messageForAnnualExam','/hms/hms/medicalExam?method=printAnnualMedicalExam&medExamId=<%=medExamId %>&order_no=<%=dgOrderNO %>&hin_id=<%=hin_id %>');" />
<input name="button1" type="button"	align="right" id="printForm44Id" class="button" value="Form 44" onclick="submitForm44();" style="display: none" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageForAnnualExam','/hms/hms/medicalExam?method=showMedicalOfficerAppointment');" />
<div class="clear"></div>
<div class="division"></div>
</form>
