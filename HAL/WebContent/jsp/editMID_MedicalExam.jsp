
<%@page import="jkt.hms.masters.business.MasMedicalExaminationReportOnEntry"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.Category"%><script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
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
<%@ page import="java.util.Properties"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>



<%@page import="jkt.hms.masters.business.MasBankMaster"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasCaLicence"%>

<%@page import="jkt.hms.masters.business.AviCa34"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<script	type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/tabcontentIn.js">
<!-- Script for tab content -->

/***********************************************
* Tab Content script v2.2- © Dynamic Drive DHTML code library (www.dynamicdrive.com)
* This notice MUST stay intact for legal use
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/
</script>

<script>
	<%Calendar calendar = Calendar.getInstance();
			String month = String.valueOf((calendar.get(Calendar.MONTH)) + 1);
			String date = String.valueOf(calendar.get(Calendar.DATE));
			int year = calendar.get(calendar.YEAR);
			if (month.length() < 2) {
				month = "0" + month;
			}
			if (date.length() < 2) {
				date = "0" + date;
			}%>
		serverdate = '<%=date + "/" + month + "/" + year%>'
	</script>


<%
	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String currentDate = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

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
<h2>Edit Medical Information Database</h2>
</div>
<%
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	List<MasMedicalExaminationReportOnEntry> medicalDetailList = new ArrayList<MasMedicalExaminationReportOnEntry>();
	if (map.get("medicalDetailList") != null) {
		medicalDetailList = (List) map.get("medicalDetailList");

	}
	List<MasUnit> unitList = null;
	List<Category> categoryList = null;

	if (map.get("unitList") != null) {
		unitList = (List<MasUnit>) map.get("unitList");
	}

	if (map.get("categoryList") != null) {
		categoryList = (List<Category>) map.get("categoryList");
	}

	MasMedicalExaminationReportOnEntry medExam = null;
	int length = medicalDetailList.size();

	if (medicalDetailList != null && medicalDetailList.size() > 0) {
		medExam = medicalDetailList.get(length - 1);
	}
	if (map.get("medicalDetailList") != null) {

		if (medExam != null) {
%>
    <div class="Block">
    <label>Service No.</label>
<input name="<%=SERVICE_NO%>" type="text" tabindex="1" maxlength="10" value="<%=medExam.getServiceNo()%>"/>

         <label>Rank</label>
          <%
          	if (medExam.getRank() != null) {
          %>
             <label class="value">
             
             <input name="<%=RANK_ID%>" type="text" tabindex="1" maxlength="10" value="<%=medExam.getRank().getId()%>" />
             
             <%=medExam.getRank().getRankName()%></label>
          <%
          	} else {
          %>
           			 <label class="value">&nbsp;</label><%
           			 	}
           			 %>
           			 
           			 
     <label>Name</label>
     <%
     	if (medExam.getNameInFull() != null) {
     %>
        <label class="value"> <input name="<%=FULL_NAME%>" type="hidden" tabindex="1" maxlength="10" value="<%=medExam.getNameInFull()%>" />
        <%=medExam.getNameInFull()%>
        
        </label>
    <%
    	} else {
    %>
            <label class="value">&nbsp;</label><%
            	}
            %>
            
        <div class="clear"></div>
        
     <label>Branch</label>
           <%
           	if (medExam.getTrade() != null) {
           %>
              <label class="value">
               <input name="<%=TRADE_ID%>" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getTrade().getId()%>" />
              <%=medExam.getTrade().getTradeName()%></label>
            <%
            	} else {
            %>
              		<label class="value">&nbsp;</label><%
              			}
              		%>
              		
              		
              		 <label>Gender</label>
   <%
   	if (medExam.getVisit().getHin().getSex() != null) {
   %>
         <label class="value">
         <input name="<%=SEX%>" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getVisit().getHin().getSex().getId()%>" />
         <%=medExam.getVisit().getHin().getSex()
								.getAdministrativeSexName()%></label>
    <%
    	} else {
    %>
              <label class="value">&nbsp;</label>
              <%
              	}
              %>
             		 <div class="clear"></div>
             		 
             		 
             		 
              		 <label>Age</label>
            <%
            	if (medExam.getVisit().getAge() != null) {
            %>
              <label class="value">
               <input name="apparentAge" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getVisit().getAge()%>" />
              <%=medExam.getVisit().getAge()%></label>
         		  <%
         		  	} else {
         		  %>
             			<label class="value">&nbsp;</label><%
             				}
             			%>
             			
             			  <label>DOE/DOC</label>
    <%
    	if (medExam.getCategorydate() != null) {
    %>
   <label class="value">
   <input name="<%=CATEGORIZATION_DATE%>" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getCategorydate()%>" />
   <%=HMSUtil.changeDateToddMMyyyy(medExam
								.getCategorydate())%></label>
       <%
       	} else {
       %>
           <label class="value">&nbsp;</label><%
           	}
           %>
           <div class="clear"></div>
           
        				 <label class="auto">Height</label>
       		<%
       			if (medExam.getHeight() != null) {
       		%>
                <label class="value">
                  
                <%=medExam.getHeight()%></label>
       		 <%
       		 	} else {
       		 %>
            			<label class="value">&nbsp;</label><%
            				}
            			%>
            			<label class="unit">cm</label>
            			
            			
            			<label class="auto" >Weight</label>
 	<%
 		if (medExam.getWeight() != null) {
 	%>
          <label class="value">
            <input name="<%=WEIGHT%>" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getWeight()%>" />
          <%=medExam.getWeight()%></label>
       <%
       	} else {
       %>
          <label class="value">&nbsp;</label>
          <%
          	}
          %>
            		<label class="unit">kg</label>
            		
            		 <label class="auto">Blood Group</label>
   <%
   	if (medExam.getVisit().getHin().getBloodGroup() != null) {
   %>
         <label class="value">
        <input name="<%=BLOOD_GROUP_ID%>" type="hidden" tabindex="1"
	maxlength="10" value="<%=medExam.getVisit().getHin().getBloodGroup().getId()%>" /> 
        <%=medExam.getVisit().getHin().getBloodGroup()
								.getBloodGroupName()%></label>
    <%
    	} else {
    %>
            <label class="value">&nbsp;</label>
           <%
           	}
           %>
            	 <div class="clear"></div>
            	 				
            			<label>Date of Cat</label>
          <%
          	if (medExam.getDateValidated() != null) {
          %>
             	<label class="value"><%=HMSUtil.changeDateToddMMyyyy(medExam
								.getDateValidated())%></label>
         	 <%
         	 	} else {
         	 %>
           				 <label class="value">&nbsp;</label><%
           				 	}
           				 %>
           				 
           				 
           				 <label>Present Med Cat</label>
    <%
    	if (medExam.getPresentMedicalCategory() != null) {
    %>
       <label class="value"><%=medExam.getPresentMedicalCategory()
								.getCategories()%></label>
    <%
    	} else {
    %>
           <label class="value">&nbsp;</label>
           <%
           	}
           %> 
           				 
           				 
           				 
           				 
           				 <div class="clear"></div>
						<label>Last Medical At</label>
 		<%
 			if (medExam.getLastame() != null) {
 		%>
			<label class="value"><%=medExam.getLastame()%></label>
 		<%
 			} else {
 		%>
                    <label class="value">&nbsp;</label><%
                    	}
                    %>
                    
                     <label>Periods</label>
  <%
  	if (medExam.getRank() != null) {
  %>
     <label class="value"><%=medExam.getRank().getRankName()%></label>
   <%
   	} else {
   %>
             <label class="value">&nbsp;</label>
             <%
             	}
             %>
        <label>DGMS(AIR)WAIVER</label>
  <%
  	if (medExam.getRank() != null) {
  %>
       <label class="value"><%=medExam.getRank().getRankName()%></label>
    <%
    	} else {
    %>
        <label class="value">&nbsp;</label>
        <%
        	}
        %>
                <div class="clear"></div>
           
					<label>Command Med Info</label>
 		<%
 			if (medExam.getCommand() != null) {
 		%>
			<label class="value"><%=medExam.getCommand().getCommandName()%></label>
            <%
            	} else {
            %>
                   <label class="value">&nbsp;</label><%
                   	}
                   %>
                   

    <label>Next Due Date</label>
   <%
   	if (medExam.getDateValidated() != null) {
   				// System.out.println("validated date :"+medExam.getDateValidated());
   				Calendar ca1 = Calendar.getInstance();
   				Date vdate = medExam.getDateValidated();
   				ca1.setTime(vdate);
   				ca1.add(Calendar.YEAR, 1);
   				String month1 = String
   						.valueOf((ca1.get(Calendar.MONTH)));
   				String date1 = String.valueOf(ca1.get(Calendar.DATE));
   				String year1 = String.valueOf(ca1.get(Calendar.YEAR));
   				if (month1.length() < 2) {
   					month1 = "0" + month1;
   				}
   				if (date1.length() < 2) {
   					date1 = "0" + date1;
   				}
   				// String ser = year1+"-"+month1+"-"+date1;
   				String ser = date1 + "/" + month1 + "/" + year1;
   %>
      <label class="value"><%=ser%></label>
     <%
     	} else {
     %>
        <label class="value">&nbsp;</label><%
        	}
        %>
          <div class="clear"></div>
      </div> 
        <div class="clear"></div>
       <ul id="countrytabs" class="shadetabs">
            <li><a href="#" rel="country1" >Medical Details</a></li>
           <li><a href="#" rel="country2" >Weight Details</a></li>
           <li><a href="#" rel="country3">Life Style Factors</a></li>
           <li><a href="#" rel="country4">Disability</a></li>
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
      <th>Blood Group</th>
      <th>UNIT</th>
      <th>CATEGORY</th>
      <th>REMARKS</th>
   </tr>

 <%
 	if (medicalDetailList != null
 					&& medicalDetailList.size() > 0) {
 				for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
 %>
 <tr>

  
     <td>
     <input type="text" id="dateId"	name="<%=DATE_TWO%>" tabindex="1" value="<%=currentDate%>"	validate="Date,date,no" MAXLENGTH="12" class="calDate" onkeyup="mask(this.value,this,'2,5','/');"/> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.caForm34A.<%=DATE_TWO%>,event)" />
     
     </td>
   
            
             <%
                            	if (medical.getBp() != null) {
                            %>
     <td><input	type="text" name="<%=BP%>" value="<%=medical.getBp()%>"	validate="BP,string,no" maxlength="8" />
     </td>
    <%
    	} else {
    %>
                 <td>
                 <input	type="text" name="<%=BP%>" value=""	validate="BP,string,no" maxlength="8" />
                 </td>
            <%
            	}
            %>
             <%
             	if (medical.getPulseRates() != null) {
             %>
     <td><input	type="text" name="<%=PULSE%>" value="<%=medical.getPulseRates()%>"	validate="Pulse ,string,no" maxlength="8" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="<%=PULSE%>" value=""	validate="Pulse,string,no" maxlength="8" /></td>
            <%
            	}
            %>
             <%
             	if (medical.getHeight() != null) {
             %>
     <td><input	type="text" name="<%=HEIGHT%>" value="<%=medical.getHeight()%>"	validate="Height,string,no" maxlength="8" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="<%=HEIGHT%>" value=""	validate="Height,string,no" maxlength="8" /></td>
            <%
            	}
            %>
             <%
             	if (medical.getWaist() != null) {
             %>
     <td><input	type="text" name="<%=WAIST%>" value="<%=medical.getWaist()%>"	validate="Waist,string,no" maxlength="8" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="<%=WAIST%>" value=""	validate="Waist,string,no" maxlength="8" /></td>
            <%
            	}
            %>
             <%
             	if (medical.getHips() != null) {
             %>
     <td><input	type="text" name="<%=HIPS%>" value="<%=medical.getHips()%>"	validate="Hips,int,no" maxlength="8" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="<%=HIPS%>" value=""	validate="Hips,string,no" maxlength="8" /></td>
            <%
            	}
            %>
             <%
             	if (medical.getWhr() != null) {
             %>
     <td><input	type="text" name="WHR" value="<%=medical.getWhr()%>"	validate="WHR,string,no" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="WHR" value=""	validate="WHR,string,no" maxlength="8" /></td>
            <%
            	}
            %>
                         <%
                         	if (medExam.getVisit().getHin().getBloodGroup() != null) {
                         %>
     <td><input	type="text" name="<%=BLOOD_GROUP_CODE%>" value="<%=medExam.getVisit().getHin()
										.getBloodGroup().getBloodGroupName()%>"	validate="WHR,string,no" /></td>
    <%
    	} else {
    %>
                 <td><input	type="text" name="<%=BLOOD_GROUP_CODE%>" value=""	validate="WHR,string,no" maxlength="8" /></td>
            <%
            	}
            %> 

      <td>
      	<%
      		if (medical.getUnit() != null) {
      	%>
<select	id="<%=UNIT_ID%>" name="<%=UNIT_ID%>"	validate="Unit,string,no" tabindex="1">
	
		<option value="0">Select</option>
	
<%
		for (MasUnit masUnit : unitList) {
								if (medical.getUnit().getId().equals(
										masUnit.getId())) {
	%>	
	<option value="<%=medical.getUnit().getId()%>" selected="selected"><%=medical.getUnit()
												.getUnitName()%></option>
	<%
		} else {
	%>	
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>

	<%
		}
							}
	%>
				
</select>

<%
	} else {
%>
<select	id="<%=UNIT_ID%>" name="<%=UNIT_ID%>"	validate="Catory,string,no" tabindex="1">
	
<option value="0">Select</option>
	
<%
		for (MasUnit masUnit : unitList) {
	%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
<%
	}
%>
</select>
<%
	}
%>

</td>
   
<td>
	<%
		if (medical.getPresentMedicalCategory() != null) {
	%>
<select	id="<%=PRESENT_MEDICAL_CATEGORY%>" name="<%=PRESENT_MEDICAL_CATEGORY%>"	validate="Catory,string,no" tabindex="1">
<option value="0">Select</option>
<%
	for (Category category : categoryList) {
							if (medical.getPresentMedicalCategory()
									.getCategoryid().equals(
											category.getCategoryid())) {
%>	
	<option value="<%=medical
												.getPresentMedicalCategory()
												.getCategoryid()%>" selected="selected"><%=medical
												.getPresentMedicalCategory()
												.getCategories()%></option>
	<%
		} else {
	%>	
	<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%></option>

	<%
		}
							}
	%>
</select>
<%
	} else {
%>
<select	id="<%=PRESENT_MEDICAL_CATEGORY%>" name="<%=PRESENT_MEDICAL_CATEGORY%>"	validate="Catory,string,no" tabindex="1">
	
<option value="0">Select</option>
	
<%
		for (Category category : categoryList) {
	%>
	<option value="<%=category.getCategoryid()%>"><%=category.getCategories()%></option>
<%
	}
%>
</select>
<%
	}
%>


</td>
  
     <%
       	if (medical.getRemarks() != null) {
       %>
        <td><input	type="text" name="<%=REMARKS%>" value="<%=medical.getRemarks()%>"	validate="Remarks,string,no" maxlength="50" /></td>
      <%
      	} else {
      %>
              <td><input	type="text" name="<%=REMARKS%>" value=""	validate="Remarks,string,no" maxlength="50" /></td>
              <%
              	}
              %>
    
          </tr>
      <%
      	}
      			}
      %>
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
	if (medicalDetailList != null
					&& medicalDetailList.size() > 0) {
				for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
%>
<tr>
<%
	if (medical.getDateOfReporting() != null) {
%>
<td><%=medical.getDateOfReporting()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getUnit().getUnitName() != null) {
%>
<td><%=medical.getUnit().getUnitName()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getWeight() != null) {
%>
<td><%=medical.getWeight()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getIdealweight() != null) {
%>
<td><%=medical.getIdealweight()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getOverweight() != null) {
%>
<td><%=medical.getOverweight()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>

</tr>
<%
	}
			}
%>

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
	if (medicalDetailList != null
					&& medicalDetailList.size() > 0) {
				for (MasMedicalExaminationReportOnEntry medical : medicalDetailList) {
%>
<tr>
<%
	if (medical.getDateOfReporting() != null) {
%>
<td><%=medical.getDateOfReporting()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getUnit().getUnitName() != null) {
%>
<td><%=medical.getUnit().getUnitName()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getCoronaryRiskFactor() != null) {
%>
<td><%=medical.getCoronaryRiskFactor()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getCoverTest() != null) {
%>
<td><%=medical.getCoverTest()%></td>
<%
	} else {
%>
<td></td> 
<%
 	}
 %>
<%
	if (medical.getAllergies() != null) {
%>
<td><%=medical.getAllergies()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical.getRemarks() != null) {
%>
<td><%=medical.getRemarks()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>

</tr>
<%
	}
			}
%>

</table>
</div>

</div>

<div id="country4" class="tabcontentIn">
<div class="cmntable">
<table  id="searchresulttable" width="100%" cellspacing="0" cellpadding="0" class="commntable">
<tr>
  <th>Service No.</th>
  <th>Date Of Cat</th>
  <th>Disability</th>
  <th>Diseases Swap</th>
  <th>Category</th>
  <th>Periods</th>
 <th>Perm/Temp</th>
</tr>

<%
	if (medicalDetailList != null
					&& medicalDetailList.size() > 0) {
				for (MasMedicalExaminationReportOnEntry medical1 : medicalDetailList) {
%>
<tr>
<%
	if (medical1.getServiceNo() != null) {
%>
<td><%=medical1.getServiceNo()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical1.getCategorydate() != null) {
%>
<td><%=medical1.getCategorydate()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical1.getDisability() != null) {
%>
<td><%=medical1.getDisability()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical1.getDiseaseSurroundingAreas() != null) {
%>
<td><%=medical1
												.getDiseaseSurroundingAreas()%></td>
<%
	} else {
%>
<td></td> 
<%
 	}
 %>
<%
	if (medical1.getCategoryplace() != null) {
%>
<td><%=medical1.getPresentMedicalCategory()
										.getCategories()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical1.getRemarks() != null) {
%>
<td><%=medical1.getRemarks()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
<%
	if (medical1.getTemprature() != null) {
%>
<td><%=medical1.getTemprature()%></td>
<%
	} else {
%>
<td></td>
<%
	}
%>
</tr>
<%
	}
			}
%>

</table>
</div>

</div>
<div class="division"></div>
<div class="clear paddingTop15"></div>


<input type="button" class="button" value="Add" name="edit" onClick="submitForm('budgetAndExpense','medicalExam?method=addMID_MedicalExam&serviceNo='+<%=medExam.getServiceNo()%>);"/>
<%
	}
	} else {
%>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<center><h4>Medical Information Database Not Found</h4></center>
<%
	}
%>
<script type="text/javascript">
var countries=new ddtabcontent("countrytabs")
countries.setpersist(true)
countries.setselectedClassTarget("link") //"link" or "linkparent"
countries.init()
</script>


</form>