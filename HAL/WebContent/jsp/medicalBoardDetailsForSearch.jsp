
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
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
function check(){
var SDate = document.dailyDoctorWise.<%= FROM_DATE%>.value;
var EDate = document.dailyDoctorWise.<%= TO_DATE %>.value;


var endDate =new Date(EDate.substring(6),(EDate.substring(3,5) - 1) ,EDate.substring(0,2))
var startDate =new Date(SDate.substring(6),(SDate.substring(3,5) - 1) ,SDate.substring(0,2))


if(startDate > endDate)
{
alert("Please ensure that the To Date is greater than or equal to the From Date.");
document.calldate.next_day.focus();
return false;
}
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
	List<MasRank> rankList = new ArrayList<MasRank>();
	if (map.get("rankList") != null) {
		rankList = (List) map.get("rankList");
	}

	List<MasDepartment> searchMasDepartmentList = new ArrayList<MasDepartment>();
	List<MasEmployee> searchMasEmployeeList = new ArrayList<MasEmployee>();
	List<MasMedicalExaminationReportOnEntry> medicalBoardDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>(); 
	List<MasMedicalExaminationDetail> masMedicalExamDetailsList = new ArrayList<MasMedicalExaminationDetail>();
	if(map.get("searchMasDepartmentList")!=null)
		searchMasDepartmentList = (List) map.get("searchMasDepartmentList");
	if(map.get("searchMasEmployeeList")!=null)
		searchMasEmployeeList = (List) map.get("searchMasEmployeeList");
	int visitId=0;
	int deptId = 0;
	if(session.getAttribute("deptId") != null){
		deptId = (Integer)session.getAttribute("deptId");
	}
	String message ="";
	   if (map.get("message") != null) 
		{
		   message =(String) map.get("message");
		}
	   System.out.println("medicalExamDetailList--->>>"+map.get("masMedicalExamDetailsList") );
	   if(map.get("masMedicalExamDetailsList") != null)
	    {
		   medicalBoardDetailList = (List)map.get("masMedicalExamDetailsList") ; 
		   System.out.println("medicalBoardDetailListSize in =====>>>>"+medicalBoardDetailList.size());
	    }
	     
	   if (map.get("masMedicalExamDetailsList") != null)
	   {
		   masMedicalExamDetailsList = (List) map.get("masMedicalExamDetailsList");
			
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
<div class="titleBg"><h2>Pers Med Details</h2>
</div>
<!--<div class="Block">
<label>Service No.</label>
<input name="<%=SERVICE_NO %>" type="text" tabindex="1" maxlength="10"  />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Search" onClick="submitProtoAjaxWithDivName('MedicalExamDetails','medicalExam?method=getMedicalExamDetails','m')" />
<input tabindex="1" name="Button" type="button" class="buttonBig" value="Add Recd" onClick="submitForm('MedicalExamDetails','medicalExam?method=getPatientDetailAndAddMedicalExam');"  />

</div>-->
<div class="clear"></div>

<%--
<input name="<%=SERVICE_NO %>" type="text" tabindex="1" maxlength="10"  onchange="submitProtoAjaxWithDivName('MedicalExamDetails','medicalExam?method=getMedicalExamDetails');"/>
--%>
<%

if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
if (map.get("medicalDetailList") != null) {
	medicalDetailList = (List) map.get("medicalDetailList");
	
}

if(map.get("masMedicalExamDetailsList") != null)
{
	masMedicalExamDetailsList=(List<MasMedicalExaminationDetail>)map.get("masMedicalExamDetailsList");
}
MasMedicalExaminationReportOnEntry medExam=null;
int length=medicalDetailList.size();

if(medicalDetailList!= null && medicalDetailList.size()>0)
{
	medExam=medicalDetailList.get(length-1);
}
if(map.get("medicalDetailList") != null)
  {
	
    if(medExam!=null)
    {
    %>
    <div class="Block">
    <label>Service No.</label>
    <label class="value"><%=medExam.getYearlySerialNo() %></label>
       <label>Rank</label>
        <%if(medExam.getRank()!= null)
        { %>
           <label class="value"><%=medExam.getRank().getRankName() %></label>
         <%}else{ %>
      <label class="value">&nbsp;</label><%} %>          			 
           			 
     <label>Name</label>
     <%if(medExam.getNameInFull()!= null)
     { %>
        <label class="value"><%=medExam.getNameInFull() %></label>
    <%}else{ %>
            <label class="value">&nbsp;</label><%} %> 			 
           	 <div class="clear"></div>		 
            <label>Branch/Trade</label>
           <%if(medExam.getTrade()!= null)
            { %>
              <label class="value"><%=medExam.getTrade().getTradeName() %></label>
            <%}
           		 else
           		 { %>
              		<label class="value">&nbsp;</label><%} %>
             		
              		 <label>Age</label>
            <%if(medExam.getVisit().getAge()!= null)
            { %>
              <label class="value"><%=medExam.getVisit().getAge() %></label>
         		  <%}else
          			 { %>
             			<label class="value">&nbsp;</label><%} %>
        				 <label class="medium4">Height</label>
       		<%if(medExam.getHeight()!= null)
       		 { %>
                <label class="valueSmall"><%=medExam.getHeight() %></label>
       		 <%}
      			  else{ %>
            			<label class="valueSmall">&nbsp;</label><%} %>
            			<label class="unit2">cm</label>
            			
            			
            				<label class="medium4">Weight</label>
 	<%if(medExam.getWeight()!= null)
 	{ %>
          <label class="valueSmall"><%=medExam.getWeight() %></label>
       <%}else
       { %><label class="valueSmall">&nbsp;</label><%} %>
       <label class="unit2">kg</label>
            				 <div class="clear"></div>        			
          
           			
					 		
					 <%-- <label>Command</label>
 		<%if(medExam.getCommand()!= null)
 		{ %>
			<label class="value"><%=medExam.getCommand().getCommandName() %></label>
            <%}else
            { %>
                   <label class="value">&nbsp;</label><%} %>
                 <label>Check Suffix</label>
      <%if(medExam.getVisit().getHin().getPrefix()!= null)
      { %>
           <label class="value"><%=medExam.getVisit().getHin().getPrefix() %></label>
           <%}else
           { %>
              <label class="value">&nbsp;</label>
              <%} %>
              --%>
      
     <%--  <label>DOE/DOC</label>
    <%if(medExam.getDateofcommun() != null)
    { %>
   <label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getDateofcommun()) %></label>
       <%}
        else
        { %>
           <label class="value">&nbsp;</label><%} %>--%>         
		
         
           <div class="clear"></div>
            <label>Gender</label>
           <%if(medExam.getVisit().getHin().getSex()!= null)
   { %>
         <label class="value"><%=medExam.getVisit().getHin().getSex().getAdministrativeSexName() %></label>
    <%}
        else
          { %>
              <label class="value">&nbsp;</label>
              <%} %>
           
            <label>Present Unit</label>
           <% if(medExam.getUnit().getUnitName()!= null )
            	{ %>
            	      <label class="value"><%=medExam.getUnit().getUnitName()%></label>			 
            	 <%} 
            	 else {%>
           <label class="value">&nbsp;</label>			 
            	<%} %>           
           
    <label>Blood Group</label>
   <%if(medExam.getVisit().getHin().getBloodGroup()!= null)
    { %>
         <label class="value"><%=medExam.getVisit().getHin().getBloodGroup().getBloodGroupName()%></label>
    <%}
        else{ %>
            <label class="value">&nbsp;</label>
           <%} %>
           
           <div class="clear"></div>
     <label>Present Med Cat</label>
    <%if(medExam.getPresentMedicalCategory()!= null)
    { %>
       <label class="value"><%=medExam.getPresentMedicalCategory().getCategories() %></label>
    <%}
        else
        { %>
           <label class="value">&nbsp;</label>
           <%} %>
           
    <label>Date of Category</label>   
           <%if(medExam.getDateValidated() != null)
         	 { %>
             	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getDateValidated()) %></label>
         	 <%}
         		 else
         			 { %>
           				 <label class="value">&nbsp;</label><%} %>
             
            <label>Place of Category</label>   
            <%if(medExam.getCategoryplace() != null)
 	     	{ %>
			     <label class="value"><%=medExam.getCategoryplace()%></label>
 		      <%}
 		         else
 		         { %>
                    <label class="value">&nbsp;</label><%} %>
           
             <div class="clear"></div>
             
            <label>Next Due Date</label>
   <%if(medExam.getDateOfReporting()!= null)
   {
	 Calendar ca1 = Calendar.getInstance();
     Date vdate=medExam.getDateOfReporting();
     ca1.setTime(vdate);
     ca1.add(Calendar.YEAR, 1); 
     String month1=String.valueOf((ca1.get(Calendar.MONTH)));
	 String date1=String.valueOf(ca1.get(Calendar.DATE));
	 String year1=String.valueOf(ca1.get(Calendar.YEAR));
	 if(month1.length()<2){
			month1="0"+month1;
		}
		if(date1.length()<2){
			date1="0"+date1;
		}
		 String ser =date1+"/"+month1+"/"+year1;	
     %>
      <label class="value"><%=ser %></label>
     <%}
   else{ %>
        <label class="value">&nbsp;</label><%} %>
            
             
   <label>Period</label>
  <%if(medExam.getTotalService()!= null)
  { %>
     <label class="value"><%=medExam.getTotalService() %></label>
   <%}
        else
          { %>
             <label class="value">&nbsp;</label>
             <%} %>
        
   <label>Waiver</label>
  <%if(medExam.getWaiver()!= null)
   { %>
       <label class="value"><%=medExam.getWaiver() %></label>
    <%}
    else
      { %>
        <label class="value">&nbsp;</label>
        <%} %>
   
      </div> 
        <div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
            <li><a href="#" rel="country1" >Medical Details</a></li>
           <li><a href="#" rel="country2" >Weight Details</a></li>
          <%--  <li><a href="#" rel="country3">Life Style Factors</a></li>
             <li><a href="#" rel="country4">Disability </a></li>--%>
                </ul>
   <div id="country1" class="tabcontentIn">
   <div class="cmntable">
   <table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
   <tr>
      <th></th>
      <th>Date</th>
      <th>Unit</th>
       <th>Med Board Type</th>
       <th>Age</th>
       <th>Waist</th>
       <th>Hip</th>
       <th>WHR</th>
       <th>Pulse</th>
       <th>BP</th>
      <th>Med Cat</th>
      <th>Period</th>
      <th>Disability</th>
      <th>Remarks</th>
      <th></th>
   </tr>
 <% if (medicalDetailList != null && medicalDetailList.size() > 0){
    for (MasMedicalExaminationReportOnEntry medical : medicalDetailList){
    	visitId = medical.getVisit().getId();
  %>
 <tr>
 
     <input type="hidden" name="hinId" value="<%=medical.getHin().getId() %>" id="hinId"/>
 <input type="hidden" name="visitId" value="<%=medical.getVisit().getId() %>" id="visitId"/>
  <input type="hidden" name="masExam_Id" value="<%=medical.getId() %>" id="masExam_Id"/>
  <input type="hidden" name="folderName" value="hearing" id="folderName"/>
  <td>
  <input type="radio" name="radioForDetail" value=<%=medical.getId()%> onclick="fillMedExamId(this)" />
  </td>
   <% if(medical.getDateMedicalBoardExam()!=null) {%>
     <td>
     
     <%=HMSUtil.changeDateToddMMyyyy(medical.getDateMedicalBoardExam())%></td>
    <% }else {%> <td></td>
            <% }%>
  <% if(medical.getUnit().getUnitName()!=null)
   {%>
      <td><%=medical.getUnit().getUnitName()%></td>
    <% }else{%>
    <td></td> <% }%>
    <% if(medical.getMedicalType()!= null)
    { %><td><%=medical.getMedicalType() %></td>
    <% } else {%><td></td>
     <% } %>
     <% if(medical.getHin().getAge() != null)
     {%><td><%=medical.getHin().getAge() %></td>
     <% } else {%>
     <td></td><%} %>
     <% if(medical.getWaist()!= null)
     { %><td><%=medical.getWaist() %></td>
     <% } else { %>
     <td></td><%} %>
     <% if(medical.getHips()!= null)
       {%><td><%=medical.getHips()%></td>
       <%} else { %>
       <td></td><%}%>
       <% if(medical.getWhr()!= null) 
       {%><td><%=medical.getWhr()%></td>
       <%} else { %><td></td><%}%>
       <% if(medical.getPulseRates()!= null)
        {%><td><%= medical.getPulseRates()%></td>
        <% } else {%><td></td><%}%>
        <% if(medical.getBp() != null)
        	{%><td><%=medical.getBp()%></td>
        	<% } else { %><td></td><%}%>
          <% if(medical.getPresentMedicalCategory()!=null) {%>
         <td><%=medical.getPresentMedicalCategory().getCategories()%></td>
     <% }else{%>
                  <td></td>
              <% }%>
     <% if(medical.getPeriod()!=null)
     {%>
        <td><%=medical.getPeriod()%></td>
      <% }
           else{%>
              <td></td>
              <% }%>
              <td>NA</td>
              
     <% if(medical.getRemarks()!=null)
      {%>
           <td><%=medical.getRemarks()%></td>
      <% }
            else{%>
             <td></td>
            <% }%>
            <td>
<input type="button" class="button" name="impbutton" value="View"
							onClick="viewPatientDocuments();" /></td>    
          </tr>
      <%}
    
  }%>
      </table>
</div>
</div>

<div id="country2" class="tabcontentIn">
<div class="cmntable">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>

<th>Date</th>
<th>Unit</th>
<th>Weight</th>
<th>Ideal Weight</th>
<th>Over Weight</th>

</tr>

<%
if (medicalDetailList != null && medicalDetailList.size() > 0) 
{ 
for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
			
%>
<tr>
<% if(medical.getDateOfReporting()!=null){%>
<td><%=HMSUtil.changeDateToddMMyyyy(medical.getDateOfReporting())%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getUnit().getUnitName()!=null){%>
<td><%=medical.getUnit().getUnitName()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getWeight()!=null){%>
<td><%=medical.getWeight()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getIdealweight()!=null){%>
<td><%=medical.getIdealweight()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getOverweight()!=null && !medical.getOverweight().equals("null")){%>
<td><%=medical.getOverweight()%></td>
<% }else{%>
<td></td>
<% }%>

</tr>
<%}}%>

</table>
</div>
</div>


<div id="country3" class="tabcontentIn">
<div class="cmntable">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
  <th>Date</th>
  <th>Unit</th>
  <th>Smoker</th>
  <th>Alcohol</th>
  <th>Allergy</th>
  <th>Personality</th>

</tr>

<%
if (medicalDetailList != null && medicalDetailList.size() > 0) { 
for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
			
%>
<tr>
<% if(medical.getDateOfReporting()!=null){%>
<td><%=HMSUtil.changeDateToddMMyyyy(medical.getDateOfReporting())%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getUnit().getUnitName()!=null){%>
<td><%=medical.getUnit().getUnitName()%></td>
<% }else{%>
<td></td>
<% }%>
<% 
String smoke="";
if(medical.getHin().getSmokerLess10()!=null)
{
	if(medical.getHin().getSmokerLess10().equalsIgnoreCase("y"))
	{
		smoke="Smoker < 10";
	}
}	
if(medical.getHin().getSmokerMore10()!=null)
{
	if(medical.getHin().getSmokerMore10().equalsIgnoreCase("y"))
	{
		smoke="Smoker > 10";
	}
}	

%>
<td><%=smoke%></td>
<% if(medical.getHin().getAlcohol()!=null){%>
<td><%=medical.getHin().getAlcohol()%></td>
<% }else{%>
<td></td> 
<% }%>
<% if(medical.getAllergies()!=null){%>
<td><%=medical.getHin().getDrugAllergies()%></td>
<% }else{%>
<td></td>
<% }%>
<td></td>

</tr>
<%}}%>

</table>
</div>
</div>

<div id="country4" class="tabcontentIn">
<div class="cmntable">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
<th>Disability</th>
</tr>
<%
if (masMedicalExamDetailsList != null && masMedicalExamDetailsList.size() > 0) 
{ 
for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExamDetailsList) 
{		
%>
<tr>
<% if(masMedicalExaminationDetail.getIllness()!=null)
{ %>
<td><%=masMedicalExaminationDetail.getIllness()%></td>
<% }else{%>
<td></td>
<% }%>
</tr>
<%}}else{%>
<tr><td>No Record Found.</td></tr>
<%} %>
</table>
</div>
</div>
<% }}else{%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<center><h4>Medical Board Details Not Found</h4></center>
<% }%>

<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
	
<div id="m"></div>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="back.history();" />
<input type="button" name="printReport" id="print"	onclick="submitFormForMBProceedingInitialAFMSFReport();"  value="print Report"	class="buttonBig" accesskey="a" />
</form>
<script type="text/javascript">
function viewPatientDocuments()
{
  hin_id=document.getElementById("hinId").value;
  visit_id=document.getElementById("visitId").value;
  masExam_Id=document.getElementById("masExam_Id").value;
  folderName='hearing';
  document.MedicalExamDetails.method="post";
  submitForm('MedicalExamDetails','medicalExam?method=viewUploadDocumentsDetails&hinId='+hin_id+'&visitId='+visit_id+'&masExam_Id='+masExam_Id+'&folderName='+folderName);
   	
}
function submitFormForMedicalBoardReport()
{
	var flag = validateRadioForVisitNo();
	 
	if(flag == false)
		{ alert("true Flage in SubmitFormForMedicalBoardReport");
		return false;
	     }
    else{ 
		    submitForm('MedicalExamDetails','medicalExam?method=printInitialMedicalBoardReport');
	    }
	
}
function validateRadioForVisitNo(){
	
	for(var i = 0; i < document.getElementsByName('radioForDetail').length; i++){
		if(document.getElementsByName('radioForDetail')[i].checked == true){
			return true;
		}		
		}
		alert("Please select one row");
	return false;
}
function fillMedExamId(printValueObj){
	var allValues = printValueObj.value;
	document.getElementById('medExamId').value = allValues;
}
function printmedicalBoardForm16(){

	 var url='/hms/hms/medicalBoard?method=generateMedicalBoardForm16&visitId=<%=visitId%>';
	 newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");

	}
function submitFormForMBProceedingInitialAFMSFReport(){
   
	 var url='/hms/hms/medicalBoard?method=generateProceedingInitialAFMSFReport&visitId=<%=visitId%>';
// alert("url---"+url);
	 newwindow=window.open(url,'ar',"left=2,top=100,height=500,width=500,status=1,scrollbars=1,resizable=0");

	}

</script>