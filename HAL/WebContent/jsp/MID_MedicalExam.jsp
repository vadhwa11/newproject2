
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

%>
<!--main content placeholder starts here-->
<script type="text/javascript" src="/hms/jsp/js/tabcontent.js">
/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>
<form name="budgetAndExpense" action="" method="post">
<div class="titleBg">
<h2>Medical Information Database</h2>
</div>
<div class="Block">
<label>Service No.</label>
<input name="<%=SERVICE_NO %>" type="text" tabindex="1" maxlength="10"  onchange="submitProtoAjaxWithDivName('budgetAndExpense','medicalExam?method=getMID_MedicalExam','m')"/>
</div>
<div class="clear"></div>

<%

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
if(map.get("medicalDetailList") != null)
  {
	
    if(medExam!=null)
    {%>
    <div class="Block">
         <label>Rank</label>
          <%if(medExam.getRank()!= null)
          { %>
             <label class="value"><%=medExam.getRank().getRankName() %></label>
          <%}
         	 else
          		{ %>
           			 <label class="value">&nbsp;</label><%} %>
           			 
           			 
     <label>Name</label>
     <%if(medExam.getNameInFull()!= null)
     { %>
        <label class="value"><%=medExam.getNameInFull() %></label>
    <%}
          else{ %>
            <label class="value">&nbsp;</label><%} %>
            
        <div class="clear"></div>
        
     <label>Branch</label>
           <%if(medExam.getTrade()!= null)
            { %>
              <label class="value"><%=medExam.getTrade().getTradeName() %></label>
            <%}
           		 else
           		 { %>
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
             		 <div class="clear"></div>
             		 
             		 
             		 
              		 <label>Age</label>
            <%if(medExam.getVisit().getAge()!= null)
            { %>
              <label class="value"><%=medExam.getVisit().getAge() %></label>
         		  <%}else
          			 { %>
             			<label class="value">&nbsp;</label><%} %>
             			
             			  <label>DOE/DOC</label>
    <%if(medExam.getCategorydate() != null)
    { %>
   <label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getCategorydate())%></label>
       <%}
        else
        { %>
           <label class="value">&nbsp;</label><%} %>
           <div class="clear"></div>
           
        				 <label class="auto">Height</label>
       		<%if(medExam.getHeight()!= null)
       		 { %>
                <label class="value"><%=medExam.getHeight() %></label>
       		 <%}
      			  else{ %>
            			<label class="value">&nbsp;</label><%} %>
            			<label class="unit">cm</label>
            			
            			
            			<label class="auto" >Weight</label>
 	<%if(medExam.getWeight()!= null)
 	{ %>
          <label class="value"><%=medExam.getWeight() %></label>
       <%}else
       { %>
          <label class="value">&nbsp;</label>
          <%} %>
            		<label class="unit">kg</label>
            		
            		 <label class="auto">Blood Group</label>
   <%if(medExam.getVisit().getHin().getBloodGroup()!= null)
    { %>
         <label class="value"><%=medExam.getVisit().getHin().getBloodGroup().getBloodGroupName()%></label>
    <%}
        else{ %>
            <label class="value">&nbsp;</label>
           <%} %>
            	 <div class="clear"></div>
            	 				
            			<label>Date of Cat</label>
          <%if(medExam.getDateValidated()!= null)
         	 { %>
             	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam.getDateValidated()) %></label>
         	 <%}
         		 else
         			 { %>
           				 <label class="value">&nbsp;</label><%} %>
           				 
           				 
           				 <label>Present Med Cat</label>
    <%if(medExam.getPresentMedicalCategory()!= null)
    { %>
       <label class="value"><%=medExam.getPresentMedicalCategory().getCategories() %></label>
    <%}
        else
        { %>
           <label class="value">&nbsp;</label>
           <%} %> 
           				 
           				 
           				 
           				 
           				 <div class="clear"></div>
						<label>Last Medical At</label>
 		<%if(medExam.getLastame()!= null)
 		{ %>
			<label class="value"><%=medExam.getLastame() %></label>
 		<%}
 		         else
 		         { %>
                    <label class="value">&nbsp;</label><%} %>
                    
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
                <div class="clear"></div>
           
					<label>Command Med Info</label>
 		<%if(medExam.getCommand()!= null)
 		{ %>
			<label class="value"><%=medExam.getCommand().getCommandName() %></label>
            <%}else
            { %>
                   <label class="value">&nbsp;</label><%} %>
                   

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
		// String ser = year1+"-"+month1+"-"+date1;
		 String ser = date1+"/"+month1+"/"+year1;	
     %>
      <label class="value"><%=ser %></label>
     <%}
   else{ %>
        <label class="value">&nbsp;</label><%} %>
          <div class="clear"></div>
      </div> 
        <div class="clear"></div>
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
      <th>BP</th>
      <th>Pulse</th>
      <th>Height</th>
      <th>Waist</th>
      <th>Hip</th>
      <th>WHR</th>
      <th>UNIT</th>
      <th>CATEGORY</th>
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
     <td><%=HMSUtil.changeDateToddMMyyyy(medical.getDateOfReporting())%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
            
             <% if(medical.getBp()!=null)
   {%>
     <td><%=medical.getBp()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
             <% if(medical.getPulseRates()!=null)
   {%>
     <td><%=medical.getPulseRates()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
             <% if(medical.getHeight()!=null)
   {%>
     <td><%=medical.getHeight()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
             <% if(medical.getWaist()!=null)
   {%>
     <td><%=medical.getWaist()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
             <% if(medical.getHips()!=null)
   {%>
     <td><%=medical.getHips()%></td>
    <% }
         else
             {%>
                 <td></td>
            <% }%>
             <% if(medical.getWhr()!=null)
   {%>
     <td><%=medical.getWhr()%></td>
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
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" class="button" value="Add" name="add"/>
<input type="button" class="button" value="Edit" name="edit" onClick="submitForm('budgetAndExpense','medicalExam?method=editMID_MedicalExam&serviceNo='+<%=medExam.getServiceNo()%>);"/>
<input type="button" class="button" value="Search" name="search" />
<input type="button" class="button" value="Print History" name="print" />
<% }}else{%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<center><h4>Medical Information Database Not Found</h4></center>
<% }%>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>
	
 


<div id="m"></div>

</form>