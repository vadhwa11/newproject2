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
if (map.get("hinNoForreport") != null) {
	hinNoForreport = (String) map.get("hinNoForreport");
	System.out.println("jsp  hinNoForreport---"+hinNoForreport);
}
if (map.get("visitNumberForReport") != null) {
	visitNumberForReport = (Integer) map.get("visitNumberForReport");
}
if (map.get("visitId") != null) {
	visitId = (Integer) map.get("visitId");
}
if(map.get("medExamId")!= null){
	medExamId = (Integer)map.get("medExamId");
	
}
String dgOrderNO="";
if (map.get("dgOrderNO") != null) {
 dgOrderNO = (String) map.get("dgOrderNO");
}
if(map.get("hin_id") != null)
{
	hin_id=(Integer) map.get("hin_id");
	}

%>
<form name="messageForAnnualExam" method="post">

<h4><%=message %></h4>
<div class="Clear"></div>
<label class="large2">Medical Certificate IAF Personnel Proceeding Abroad For Less Than 30 Days </label>
<input type="checkbox" id="IAFPrint" name="IAFPrint" value="i" tabindex="1" />

<div class="clear"></div>
<label class="large2">Medical Certificate Service Personnel Proceeding Abroad</label>
<input type="checkbox" id="ProceedingAbroad" name="ProceedingAbroad" value="pa" tabindex="1">

<div class="clear"></div>
<label class="large2">Medical Certificate Fitness For Proceeding Abroad Families Of Service Personnel</label>
<input type="checkbox" id="FitnessProceedingAbroad" name="FitnessProceedingAbroad" value="fpa" tabindex="1">

<div class="clear"></div>
<label class="large2">Medical Card</label>
<input type="checkbox" id="MedicalCard" name="MedicalCard" value="mc" tabindex="1">
<div class="clear"></div>
<label class="large2">Medical Fitness Certificate For Proceeding On Course</label>
<input type="checkbox" id="proceedingoncourse" name="proceedingoncourse" value="pc" tabindex="1">

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


<input type="button" name="yes" value="Print" class="button"	onclick="submitForm('messageForAnnualExam','/hms/hms/medicalExam?method=printAnnualMedicalExam&medExamId=<%=medExamId %>&order_no=<%=dgOrderNO %>&hin_id=<%=hin_id %>');" />
<input type="button" name="no" value="No" class="button"	onclick="submitForm('messageForAnnualExam','/hms/hms/medicalExam?method=showApprovingAWatingList');" />

<div class="clear"></div>
<div class="division"></div>

</form>
<script type="text/javascript">

</script>