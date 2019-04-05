<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="java.net.URL"%>
<%@page import="jkt.hms.util.HMSUtil"%> 
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>

<%@page import="jkt.hms.masters.business.MasMedicalExaminationDetail"%>
<%@page import="jkt.hms.masters.business.Users"%><script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
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
	String userName="";
	if(session.getAttribute("userName")!=null)
	 userName=(String)session.getAttribute("userName");
	
	Users user = (Users)session.getAttribute("users");
	Integer empId =user.getEmployee().getId();
	int unitId=0;
	if (map.get("unitId") != null) {
		unitId = (Integer) map.get("unitId");
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
	String message ="";
	   if (map.get("message") != null) 
		{
		   message =(String) map.get("message");
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

<form name="MedicalExamDetails" method="post" action="">
<div class="titleBg"><h2>Pers Med DETAILS</h2>
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
List<MasMedicalExaminationDetail> masMedicalExamDetailsList=null;
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
	String serviceNo="";
  
    if( medExam!= null && medExam.getServiceNo()!= null)
     {
    	serviceNo=medExam.getServiceNo();
     }

      %>
    <div class="Block">
    <label>Service No.</label>
    
    <label class="value"><%=serviceNo %></label>
         <label>Rank</label>
          <%if(medExam!= null && medExam.getRank()!= null)
          { %>
             <label class="value"><%=medExam.getRank().getRankName() %></label>
          <%}
         	 else
          		{ %>
           			 <label class="value">&nbsp;</label><%} %>
           			 
           			 
           <label>Name</label>
     <%if(medExam != null && medExam.getNameInFull()!= null)
     { %>
        <label class="value"><%=medExam.getNameInFull() %></label>
    <%}
          else{ %>
            <label class="value">&nbsp;</label><%} %> 			 
           			 
           	 <div class="clear"></div>		 
           	      			 
            <label>Branch/Trade</label>
           <%if( medExam != null && medExam.getTrade()!= null)
            { %>
              <label class="value"><%=medExam.getTrade().getTradeName() %></label>
            <%}
           		 else
           		 { %>
              		<label class="value">&nbsp;</label><%} %>
             		
              		 <label>Age</label>
            <%if( medExam != null && medExam.getVisit().getAge()!= null)
            { %>
              <label class="value"><%=medExam.getVisit().getAge() %></label>
         		  <%}else
          			 { %>
             			<label class="value">&nbsp;</label><%} %>
        				 <label class="medium4">Height</label>
       		<%if(medExam != null && medExam.getHeight()!= null)
       		 { %>
                <label class="valueSmall"><%=medExam.getHeight() %></label>
       		 <%}
      			  else{ %>
            			<label class="valueSmall">&nbsp;</label><%} %>
            			<label class="unit2">cm</label>
            			
            		<label class="medium4">Weight</label>
 	<%if(medExam != null &&  medExam.getWeight()!= null)
 	{ %>
          <label class="valueSmall"><%=medExam.getWeight() %></label>
       <%}else
       { %>
          <label class="valueSmall">&nbsp;</label>
          <%} %>	
            <label class="unit2">kg</label>		
            			
          <div class="clear"></div>
            
             <label>Gender</label>
   <%if( medExam != null && medExam.getVisit().getHin().getSex()!= null)
   { %>
         <label class="value"><%=medExam.getVisit().getHin().getSex().getAdministrativeSexName() %></label>
    <%}
        else
          { %>
              <label class="value">&nbsp;</label>
              <%} %>				 
            	<label>Present Unit</label>
            	<% if(medExam != null && medExam.getUnit()!= null )
            	{ %>
            	      <label class="value"><%=medExam.getUnit().getUnitName()%></label>			 
            	 <%} 
            	 else {%>
           <label class="value">&nbsp;</label>			 
            	<%} %>
            	
            <label>Blood Group</label>
   <%if(medExam != null && medExam.getVisit().getHin().getBloodGroup()!= null)
    { %>
         <label class="value"><%=medExam.getVisit().getHin().getBloodGroup().getBloodGroupName()%></label>
    <%}
        else{ %>
            <label class="value">&nbsp;</label>
           <%} %>	
            	
            <div class="clear"></div> 	
            	
            <label>Present Med Cat</label>
    <%if(medExam != null && medExam.getHin().getCategory()!= null)
    { %>
       <label class="value"><%=medExam.getHin().getCategory().getCategories() %></label>
    <%}
        else
        { %>
           <label class="value">&nbsp;</label>
           <%} %> 	
            	
            	          	
            				 
         <label>Date of Category</label>
          <%if(medExam != null && medExam.getDateValidated()!= null)
         	 { %>
             	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getDateValidated()) %></label>
         	 <%}
         		 else
         			 { %>
           				 <label class="value">&nbsp;</label><%} %>
           			
						<label>Place of Category</label>
 		<%if(medExam != null && medExam.getCategoryplace() != null)
 		{ %>
			<label class="value"><%=medExam.getCategoryplace()%></label>
 		<%}
 		         else
 		         { %>
                    <label class="value">&nbsp;</label><%} %>
					<%-- <label>Command</label>
 		<%if(medExam.getCommand()!= null)
 		{ %>
			<label class="value"><%=medExam.getCommand().getCommandName() %></label>
            <%}else
            { %>
                   <label class="value">&nbsp;</label><%} %>--%>
                 <%--  <label>Check Suffix</label>
      <%if(medExam.getVisit().getHin().getPrefix()!= null)
      { %>
           <label class="value"><%=medExam.getVisit().getHin().getPrefix() %></label>
           <%}else
           { %>
              <label class="value">&nbsp;</label>
              <%} %>
              
               <label>DOE/DOC</label>
    <%if(medExam.getDateofcommun() != null)
    { %>
   <label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getDateofcommun()) %></label>
       <%}
        else
        { %>
           <label class="value">&nbsp;</label><%} %>
              --%>
			
           <div class="clear"></div>
    
    <label>Next Due Date</label>
   <%if(medExam != null && medExam.getDateOfReporting()!= null)
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
  <%if(medExam != null && medExam.getTotalService()!= null)
  { %>
     <label class="value"><%=medExam.getTotalService() %></label>
   <%}
        else
          { %>
             <label class="value">&nbsp;</label>
             <%} %>
      
   <label>Waiver</label>
  <%if(medExam != null && medExam.getWaiver()!= null)
   { %>
       <label class="value"><%=medExam.getWaiver() %></label>
    <%}
    else
      { %>
        <label class="value">&nbsp;</label>
        <%} %>
  
            <div class="clear"></div>
          </div> 
        <div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
            <li><a href="#" rel="country1" >Medical Details</a></li>
           <li><a href="#" rel="country2" >Weight Details</a></li>
            <%--<li><a href="#" rel="country3">Life Style Factors</a></li>
          <li><a href="#" rel="country4">Disability</a></li> --%>
      </ul>
   <div id="country1" class="tabcontentIn">
   <div class="cmntable">
   <table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
   <tr>
       <th></th>
       <th>Date</th>
       <th>Unit</th>
       <th>Med Exam/Med Board Type</th>
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
   </tr>

 <%
 int i=0;
  if (medicalDetailList != null && medicalDetailList.size() > 0)
  { 
    for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) 
    {			
  %>
 <tr>
 <td>
  <input type="radio" name="radioForDetail" value=<%=medical.getId()%> onclick="fillMedExamId(this)" />
  </td>
   <% if(medical.getDateOfCompletion()!=null)
   {%>
     <td><%=HMSUtil.changeDateToddMMyyyy(medical.getDateOfCompletion())%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
  <% if(medical.getUnit()!=null)
   {%>
      <td><%=medical.getUnit().getUnitName()%></td>
    <% }
         else{%>
             <td></td>
             
                  
              <% }%>
           
    <% if(medical.getMedicalExamType()!=null)
   {%> 
<td><%=medical.getMedicalExamType()%></td>
    <% }
         else{%>
             <td></td>                       
              <% }%>
  
        <% if(medical.getDateOfReporting()!=null && medical.getDateOfBirth()!=null)
   {
        	Date dateOfBirth = medical.getDateOfBirth();
        	Date dateOfrepo = medical.getDateOfReporting();
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(dateOfBirth);
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(dateOfrepo);
			int calculatedDays, calculatedMonth, calculatedYear;
			int cal1Days = cal1.get(Calendar.DATE);
			int cal2Days = cal2.get(Calendar.DATE);
			int cal1Month = cal1.get(Calendar.MONTH);
			int cal2Month = cal2.get(Calendar.MONTH);
			int cal1Year = cal1.get(Calendar.YEAR);
			int cal2Year = cal2.get(Calendar.YEAR);
			
			calculatedMonth = cal1Month - cal2Month;
			if (calculatedMonth == 1) {
				calculatedDays = cal2Days + (31 - cal1Days);
			} else {
				calculatedDays = cal2Days - cal1Days;
			}

			calculatedYear = cal2Year - cal1Year;
			int age = 0;
			if(calculatedMonth < -5)
				age=calculatedYear-1;
			else
				age = calculatedYear;

			
   %>     
   <td><%=age %></td>
   <% }
         else{%>
             <td></td>
             
                  
              <% }%>
             
   <% if(medical.getWaist()!=null)
   {%>
   <td><%=medical.getWaist()%></td>
   <% }
   else{%>
             <td></td>
                              
              <% }%>
              
     <% if(medical.getHips()!=null)
   {%>         
   <td><%=medical.getHips() %></td>
   <% }
   else{%>
 <td></td>
   <% }%>
   
   <% if(medical.getWhr()!=null)
   {%>         
   <td><%=medical.getWhr()%></td>
   <%}
   else  {%>
   <td></td>
   <%} %>
   
    <% if(medical.getPulseRates()!=null)
   {%>  
   <td><%=medical.getPulseRates() %></td>
   <%}
   else  {%>
   <td></td>
   <%} %>
   
   <% if(medical.getBp()!=null)
   {%> 
   <td><%=medical.getBp() %></td>
    <%}
   else  {%>
   <td></td>
   <%} %>  
   
   
   <% if(medical.getMedCatRec()!=null)
   {%>
         <td><%=medical.getMedCatRec()%></td>
     <% }
         else
              {%>
                  <td></td>
              <% }%>
     <% if(medical.getPeriod()!=null)
     {%>
        <td><%=medical.getPeriod()%></td>
      <% }
           else{%>
              <td></td>
              <% }%>
              
               <td>
                <%
                String disabilityString ="";
                if (masMedicalExamDetailsList != null && masMedicalExamDetailsList.size() > 0) 
                { 
                	int check=1;
                for (MasMedicalExaminationDetail masMedicalExaminationDetail : masMedicalExamDetailsList) {
                	if(medical.getId() == masMedicalExaminationDetail.getMasMedicalReport().getId()){
                	if(masMedicalExaminationDetail.getPrincipal()!=null)
        			{ 
        				if(check==1)
        				{
        					disabilityString=disabilityString+masMedicalExaminationDetail.getPrincipal();
        					check++;
        				}else
        				{
        					disabilityString=disabilityString+","+masMedicalExaminationDetail.getPrincipal();
        				}
        			 }
                	}
        		
        		   }             
                
                %>
               <%=disabilityString %></td>
              <%}else { %>
               <td></td>
                   <%} %>
              
     <% if(medical.getRemarks()!=null)
      { %>
           <td><%=medical.getRemarks()%></td>
      <% }
            else{%>
             <td></td>
            <% }%>

           <%--  <% if(medical.getMedicalExamType()!= null)
            	{
            	%>
            	<input type="hidden" name="medicalExamType" value=<%=medical.getMedicalExamType()%> />   
            	<%}%>
                --%>        	
            
          </tr>
      <%
    i++;  
    }
    
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
<% if(medical.getUnit()!=null){%>
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
  <th>Family History</th>

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
<% if(medical.getUnit()!=null){%>
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

<% if(medical.getHin().getFamilyHistory()!=null){%>

<td><%=medical.getHin().getFamilyHistory() %></td>
<%}else{ %>
<td></td><%} %>
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
<% if(masMedicalExaminationDetail.getPrincipal()!=null)
{ %>
<td><%=masMedicalExaminationDetail.getPrincipal()%></td>
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
<%--
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="back.history();" /> --%>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="submitForm('MedicalExamDetails','medicalBoard?method=medicalBoardDetails');"/> 
 
<input type="button" name="printReport" id="print"	onclick="submitFormForMedicalExamReport();" value="print Report"	class="buttonBig" accesskey="a" />
<% 
  }else{ %>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<center><h4>Medical Exam Details Not Found</h4></center>
<% }%>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
<div id="m"></div>
<input type="hidden" name="medExamId" id="medExamId" value="" />

</form>

<script type="text/javascript">
function submitFormForMedicalExamReport()
{
	var flag = validateRadioForVisitNo();
	
	if(flag == false)
		{ 
		return false;
	     }
    else{ 
		    submitForm('MedicalExamDetails','medicalExam?method=printAnnualMedicalExamReport');
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
</script>