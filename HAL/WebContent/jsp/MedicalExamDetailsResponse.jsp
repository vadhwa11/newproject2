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
<script type="text/javascript" src="/hms/jsp/js/jquery-1.2.6.pack.js"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

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
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/tabcontent.css" />
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	Map<String,Object> map = new HashMap<String,Object>();
	//System.out.println("map==========>>>>>>>>in MedicalExamDetailResponse"+request.getAttribute("map"));
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("medicalDetailList") != null) {
		medicalDetailList = (List) map.get("medicalDetailList");
		
	}
	MasMedicalExaminationReportOnEntry medExam=null;
	int length=medicalDetailList.size();
	

	if(medicalDetailList!= null && medicalDetailList.size()>0)
	{
		medExam=medicalDetailList.get(length-1);
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

<form name="MedicalExamDetails12" method="post" action="">
  <div class="Block">
    <%if(medExam!=null)
    {%>
         <label>Rank</label>
          <%if(medExam.getRank()!= null)
          { %>
             <label class="value"><%=medExam.getRank().getRankName() %></label>
          <%}
         	 else
          		{ %>
           			 <label class="value">&nbsp;</label><%} %>
           			 <label>Branch</label>
           <%if(medExam.getTrade()!= null)
            { %>
              <label class="value"><%=medExam.getTrade().getTradeName() %></label>
            <%}
           		 else
           		 { %>
              		<label class="value">&nbsp;</label><%} %>
             		 <div class="clear"></div>
              		 <label>Age(yr)</label>
            <%if(medExam.getVisit().getAge()!= null)
            { %>
              <label class="value"><%=medExam.getVisit().getAge() %></label>
         		  <%}else
          			 { %>
             			<label class="value">&nbsp;</label><%} %>
        				 <label>Height(cm)</label>
       		<%if(medExam.getHeight()!= null)
       		 { %>
                <label class="value"><%=medExam.getRank().getRankName() %></label>
       		 <%}
      			  else{ %>
            			<label class="value">&nbsp;</label><%} %>
            			<label>Date Of Cat</label>
          <%if(medExam.getDateValidated()!= null)
         	 { %>
             	<label class="value"><%=medExam.getDateValidated() %></label>
         	 <%}
         		 else
         			 { %>
           				 <label class="value">&nbsp;</label><%} %>
           				 <div class="clear"></div>
						<label>Last Medical At</label>
 		<%if(medExam.getLastame()!= null)
 		{ %>
			<label class="value"><%=medExam.getLastame() %></label>
 		<%}
 		         else
 		         { %>
                    <label class="value">&nbsp;</label><%} %>
					<label>Command Med Info</label>
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
      <div class="clear"></div>
     <label>Name</label>
     <%if(medExam.getNameInFull()!= null)
     { %>
        <label class="value"><%=medExam.getNameInFull() %></label>
    <%}
          else{ %>
            <label class="value">&nbsp;</label><%} %>
     

   <label>Gender</label>
   <%if(medExam.getVisit().getHin().getSex()!= null)
   { %>
         <label class="value"><%=medExam.getVisit().getHin().getSex().getAdministrativeSexName() %></label>
    <%}
        else
          { %>
              <label class="value">&nbsp;</label>
              <%} %>
       <label>Commissioned</label>
    <%if(medExam.getRank()!= null)
    { %>
   <label class="value"><%=medExam.getNameInFull() %></label>
       <%}
        else
        { %>
           <label class="value">&nbsp;</label><%} %>
           <div class="clear"></div>
			<label>Weight</label>
 	<%if(medExam.getWeight()!= null)
 	{ %>
          <label class="value"><%=medExam.getWeight() %></label>
       <%}else
       { %>
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
     <label>Category</label>
    <%if(medExam.getPresentMedicalCategory()!= null)
    { %>
       <label class="value"><%=medExam.getPresentMedicalCategory().getCategories() %></label>
    <%}
        else
        { %>
           <label class="value">&nbsp;</label>
           <%} %>
   <div class="clear"></div>
   <label>Periods</label>
  <%if(medExam.getRank()!= null)
  { %>
     <label class="value"><%=medExam.getRank().getRankName() %></label>
   <%}
        else
          { %>
             <label class="value">&nbsp;</label>
             <%} %>
        <label>DGMS(AIR)WAIVER</label>
  <%if(medExam.getRank()!= null)
   { %>
       <label class="value"><%=medExam.getRank().getRankName() %></label>
    <%}
    else
      { %>
        <label class="value">&nbsp;</label>
        <%} %>
   <label>Next Due Date</label>
   <%if(medExam.getDateValidated()!= null)
   {
	// System.out.println("validated date :"+medExam.getDateValidated());
	 Calendar ca1 = Calendar.getInstance();
     Date vdate=medExam.getDateValidated();
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
		 String ser = year1+"-"+month1+"-"+date1;	
     %>
      <label class="value"><%=ser %></label>
     <%}
   else{ %>
        <label class="value">&nbsp;</label><%} %>
          <div class="clear"></div>
          </div>
       <ul id="countrytabs" class="shadetabs">
            <li><a href="#" rel="country1" >Medical Details</a></li>
           <li><a href="#" rel="country2" >Weight Details</a></li>
           <li><a href="#" rel="country3">Life Style Factors</a></li>
      </ul>
   <div id="country1" class="tabcontentIn">
   <div class="cmntable">
   <table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
   <tr>
      <th>DATE</th>
      <th>UNIT</th>
      <th>CATEGORY</th>
      <th>PERIOD</th>
      <th>REMARKS</th>
   </tr>

 <%
  if (medicalDetailList != null && medicalDetailList.size() > 0)
  { 
    for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) 
    {			
  %>
 <tr>
   <% if(medical.getDateOfReporting()!=null)
   {%>
     <td><%=medical.getDateOfReporting()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
  <% if(medical.getUnit().getUnitName()!=null)
   {%>
      <td><%=medical.getUnit().getUnitName()%></td>
    <% }
         else{%>
               <td></td>
              <% }%>
   <% if(medical.getPresentMedicalCategory()!=null)
   {%>
         <td><%=medical.getPresentMedicalCategory().getCategories()%></td>
     <% }
         else
              {%>
                  <td></td>
              <% }%>
     <% if(medical.getRemarks()!=null)
     {%>
        <td><%=medical.getRemarks()%></td>
      <% }
           else{%>
              <td></td>
              <% }%>
     <% if(medical.getRemarks()!=null)
      {%>
           <td><%=medical.getRemarks()%></td>
      <% }
            else{%>
             <td></td>
            <% }%>
          </tr>
      <%}}%>
      </table>
</div>
</div>

<div id="country2" class="tabcontentIn">
<div class="cmntable">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>

<th>DATE</th>
<th>UNIT_NAME</th>
<th>WEIGHT</th>
<th>IBW</th>
<th>OVERWT</th>

</tr>

<%
if (medicalDetailList != null && medicalDetailList.size() > 0) { 
for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
			
%>
<tr>
<% if(medical.getDateOfReporting()!=null){%>
<td><%=medical.getDateOfReporting()%></td>
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
<% if(medical.getOverweight()!=null){%>
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
  <th>DATE</th>
  <th>UNIT_NAME</th>
  <th>SMOKE</th>
  <th>ALCO</th>
  <th>ALLERGY</th>
  <th>PERSONALITY</th>

</tr>

<%
if (medicalDetailList != null && medicalDetailList.size() > 0) { 
for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
			
%>
<tr>
<% if(medical.getDateOfReporting()!=null){%>
<td><%=medical.getDateOfReporting()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getUnit().getUnitName()!=null){%>
<td><%=medical.getUnit().getUnitName()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getCoronaryRiskFactor()!=null){%>
<td><%=medical.getCoronaryRiskFactor()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getCoverTest()!=null){%>
<td><%=medical.getCoverTest()%></td>
<% }else{%>
<td></td> 
<% }%>
<% if(medical.getAllergies()!=null){%>
<td><%=medical.getAllergies()%></td>
<% }else{%>
<td></td>
<% }%>
<% if(medical.getRemarks()!=null){%>
<td><%=medical.getRemarks()%></td>
<% }else{%>
<td></td>
<% }%>

</tr>
<%}}%>

</table>
</div>
</div>
<% }else{%>
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
</form>

