<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * showPatientList.jsp  
 * Purpose of the JSP -  This is Show Patient List.
 * @author  Deepti
 * @author  Ritu
 * Create Date: 21st Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.15
--%>

<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script> 
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script> 
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
<!--
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
// -->
</script>
<%
	Map map = new HashMap();
	int waitingCount = 0;
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");

	}
	List inPatientSet = new ArrayList();
	try {
			if(map.get("takeSetFromSessionInJsp")!=null)
			{
				String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
				
				  inPatientSet=(List)map.get("inPatientSet");
				
			}
		
	} catch (Exception exp) {
			exp.printStackTrace();
	}
	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int deptId=0;
	
	if (map.get("deptId") != null) {
		deptId = (Integer) map.get("deptId");
	}
	String deptName="";
	if (map.get("deptName") != null) {
		deptName = (String) map.get("deptName");
	}
	if (map.get("waitingCount") != null) {
		waitingCount = Integer.parseInt(""+map.get("waitingCount")) ;
	}
	List<UserButtonRights> userRightsList= new ArrayList<UserButtonRights>();
	if (map.get("userRightsList") != null) {
		userRightsList = (List<UserButtonRights>)map.get("userRightsList") ;
	}
%>


<div class="titleBg"><h2>Nursing Station</h2></div>
<div class="clear"></div>
<!--<h4><%=deptName %></h4>
--><!--  <div style="float: left; padding-left: 500px;"><h4 align="left" class="style1"><%//deptName%></h4></div>  -->
 <%if(waitingCount !=0){ %>
<h4><span><%=waitingCount%> Patients are waiting for Acknowledgment</span></h4>
 <%} %>
<div class="search" id="threadsearch">
<a href=""></a>
<script	type="text/javascript"> vbmenu_register("threadsearch"); </script>
</div>
<div class="clear"></div>
<!-- thread search menu -->
<div class="searchBlock" id="threadsearch_menu" style="display: none">
<form name="search" method="post">
<div class="clear"></div>	
		<label>Service Number </label> 
		<input	type="text" name="<%= RequestConstants.SERVICE_NUMBER %>" id="serviceNo" MAXLENGTH="30"  />
		<input type="hidden" name="deptName" id="deptName"  value="<%=deptName %>" />
		<label>HIN Number </label>
		<input type="text" name="<%= RequestConstants.HIN_NO %>" id="hinNo" MAXLENGTH="30"  tabindex=1  />
		<div class="clear"></div>
		<label>Admission Number</label>
		<select name="<%=RequestConstants.ADMISSION_NUMBER%>" id="admissionNo"  >
								<option value="0">Select</option>
								<%
								try{	
								if(inPatientSet.size()>0){
									Iterator itr=inPatientSet.iterator();
								    while(itr.hasNext()){
								    	Inpatient inpatient= (Inpatient) itr.next();
								    	if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
								    	{
								%>
								<option value=<%=inpatient.getId()%>><%=inpatient.getAdNo()%></option>
								<%
									}
								  }	
								    }
								}catch(Exception e){
								e.printStackTrace();	
								
								}
								%>
							</select> 
						  <input type="button" class="button" value=" " onClick="if(checkBlankForPatientSearch()){submitForm('search','ipd?method=searchPatient');}" />
					  
					</form>
		</div>
    <%
		if(map.get("message") != null){
		   String message = (String)map.get("message");
		
      %>
    <label class="auto"><span><%=message %></span></label>  
		<% }  
		%>
	<jsp:include page="searchResultBlockForIPD.jsp" /> 
	<div class="clear"></div>
<div class="paddingTop15"></div>
<div class="clear"></div>
<form name="patientList" method="post" action="">
<div class="leftMenu">Ward Management
<div class="clear"></div>
	<%for(UserButtonRights  userButtonRights : userRightsList){
		if(userButtonRights.getButton().getFormName().equals("Nursing Station")){
		String formulaUsed=userButtonRights.getButton().getFormulaUsed();
		//System.out.println("formula used----"+formulaUsed);
		if(formulaUsed!= null && !formulaUsed.equals("") ){
			//formulaUsed=
		
		
		%><!--
		<input type="button" name="<%=userButtonRights.getButton().getButtonName() %>" class="<%=userButtonRights.getButton().getClassName() %>" 
		              align="left"   onClick="submitForm('patientList','<%=userButtonRights.getButton().getUrl() %>','<%=formulaUsed%>');" />
	--><%}else{%>
		<!--<input type="button" name="<%=userButtonRights.getButton().getButtonName() %>" class="<%=userButtonRights.getButton().getClassName() %>" 
		              align="left"   onClick="submitForm('patientList','<%=userButtonRights.getButton().getUrl() %>','');" />
	--><%}}}
	 %>
<input type="image" src="/hms/jsp/images/buttonIcons/clinicalSetup.jpg" onclick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');"	class="button" />  
<input type="image"	src="/hms/jsp/images/buttonIcons/nursingEntry.jpg" class="button"	onClick="submitForm('patientList','ipd?method=showNewNursingCareEntryDetailsJsp','validateRadio');"	/>  
<input type="image"	src="/hms/jsp/images/buttonIcons/clinicalChart.jpg" class="button"	onClick="submitForm('patientList','ipd?method=showNewNursingClinicalChartJsp','validateRadio');"	/>  
<input type="image"	src="/hms/jsp/images/buttonIcons/intakeOutput.jpg" class="button"	onClick="submitForm('patientList','ipd?method=showIntakeOutputJsp','validateRadio');"	/> 
<input type="image"	src="/hms/jsp/images/buttonIcons/dischargeSummary.jpg" class="button"	onClick="submitForm('patientList','discharge?method=showDischargeInputJsp','validateRadio');"	/>  
<input type="image"	src="/hms/jsp/images/buttonIcons/wardConsumption.jpg" class="button"	onClick="submitForm('patientList','ipd?method=showWardList');"	/>  
<input type="image" src="/hms/jsp/images/buttonIcons/patientIssue.jpg" class="button" onClick="submitForm('patientList','ipd?method=showPatientIssueJsp','validateRadio');" /> 
<input type="image" src="/hms/jsp/images/buttonIcons/monthlyIndent.jpg" class="button" onClick="submitForm('patientList','stores?method=showDepartmentIndentJsp');"	/>  
<input type="button" class="sildilButt" value="SIL " align="left"     onClick="submitForm('patientList','ipd?method=showSilDilJsp','validateRadio');" />	
<input type="button" class="patientransfer" value="Transfer" align="left"   onClick="submitForm('patientList','/hms/hms/adt?method=getTransferScreen','validateRadio');" />	

	<!--<input type="button" class="clinsetupButt" value=" " align="left"   onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />
	<input type="button" class="nursentryButt" value=" " align="left"   onClick="submitForm('patientList','ipd?method=showNursingCareEntryJsp');" />	
	<input type="button" class="clinchartButt" value=" " align="left"   onClick="submitForm('patientList','ipd?method=showNursingClinicalChartJsp');" />
	<input type="button" class="intakoutputButt" value=" " align="left" onClick="submitForm('patientList','ipd?method=showIntakeOutputJsp','validateRadio');" />	
	<input type="button" class="dischsummButt" value=" " align="left"   onClick="submitForm('patientList','discharge?method=showDischargeInputJsp','validateICard');" />
	<input type="button" class="wardconsumpButt" value=" " align="left" onClick="submitForm('patientList','ipd?method=showWardList');" />	
	<input type="button" class="foodtestingButt" value=" " align="left" onClick="submitForm('patientList','ipd?method=showFoodTastingJsp');" />
	<input type="button" class="patissueButt" value=" " align="left"    onClick="submitForm('patientList','ipd?method=showPatientIssueJsp','validateRadio');" />  
	<input type="button" class="mnthindentButt" value=" " align="left"  onClick="submitForm('patientList','stores?method=showDepartmentIndentJsp');" />	
	<input type="button" class="patDiagButt" value=" " align="left"    onClick="submitForm('patientList','ipd?method=showPatientDiagnosisJsp','validateRadio');" />	 
	
	<input type="patientransfer" class="patientransfer" value="" align="left"   onClick="submitForm('patientList','/hms/hms/adt?method=getTransferScreen','validateRadio');" />	
	<input type="button" class="patientdischarge"  align="left"   onClick="submitForm('patientList','/hms/hms/adt?method=getDischargeScreen','validateRadio');" />	
	<input type="button" class="newAdmission" value="" align="left"   onClick="submitForm('patientList','/hms/hms/ipd?method=showWaitingList');" />	
	<input type="button" class="dailyremarks" value="" align="left"     onClick="submitForm('patientList','/hms/hms/ipd?method=showWardRemarksJsp');" />	
	<input type="button" class="patRmkButt" value=" " align="left"    onClick="submitForm('patientList','/hms/hms/ipd?method=showPatientRemarksJsp','validateRadio');" />	
	<input type="button"  class="orderRequestButt" align="left"   onClick="submitForm('patientList','lab?method=showOrderBookingJsp','validateRadio');" />	
	<input type="button"   class="orderStatusButt" align="left"   onClick="submitForm('patientList','lab?method=getOrderNoListForOrderStatus','validateRadio');" />	 
	
	-->
	</div>
<div class="floatRight">
<div class="clear"></div>
<div id="test"  class="small">
<div id="searchresults" tabindex=2  >
<div id="searchtable" tabindex=2 ></div>
	
	
<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.ADMISSION_NUMBER%>"], [3,"<%= RequestConstants.PATIENT_NAME %>"], [4,"<%= RequestConstants.SERVICE_NUMBER %>"],[5,"<%= RequestConstants.AGE %>"],[6,"<%= RequestConstants.SEX %>"],[7,"<%=RequestConstants.HIN_NO%>"],[8,"<%= RequestConstants.PATIENT_DIAGNOSIS %>"],[9,"<%=RequestConstants.DATE_OF_ADMISSION%>"],[10,"<%=RequestConstants.ADMISSION_STATUS%>"],[11,"<%=RequestConstants.I_CARD_VERIFIED%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	 statusTd =12;

</script>	
</div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel"></div>
</div>
</div>
	
<script type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Admission No "
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.ADMISSION_NUMBER%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.PATIENT_NAME %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Age"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.SERVICE_NUMBER %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Sex"
		data_header[4][1] = "data";
		data_header[4][2] = "6%";
		data_header[4][3] = "<%=RequestConstants.AGE %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Relation"
		data_header[5][1] = "data";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SEX %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Service No"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.PATIENT_DEPARTMENT %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Rank"
		data_header[7][1] = "data";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_DIAGNOSIS %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "S Name"
		data_header[8][1] = "data";
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.DATE_OF_ADMISSION %>";
		
		
		
		data_header[9] = new Array;
		data_header[9][0] = "Adm Date"
		data_header[9][1] = "data";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.ADMISSION_STATUS %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Status"
		data_header[10][1] = "data";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.SILORDIL %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "I-Card Status"
		data_header[11][1] = "hide";
		data_header[11][2] = "1%";
		data_header[11][3] = "<%=RequestConstants.I_CARD_VERIFIED %>";
		
		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
			Iterator iterator=inPatientSet.iterator();
		          while(iterator.hasNext())
		           {   
		        	  Inpatient inpatient= (Inpatient) iterator.next();
		        	  if(inpatient.getAdStatus().equalsIgnoreCase("A") || inpatient.getAdStatus().equalsIgnoreCase("R"))
		        	  {
		        	  Patient patientHin=(Patient)inpatient.getHin();
		        	  MasDepartment deptObj=(MasDepartment)inpatient.getDepartment();
		        	  String adStatus=inpatient.getAdStatus();
		        	  String newIcnName="";
		        	  int dischargeId =0;
						
		        	 
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String dateOfAdmissionInString =HMSUtil.changeDateToddMMyyyy(inpatient.getDateOfAddmission());
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] =<%=patientHin.getId()%>
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%= inpatient.getId()%>" id="parent" />'
			
			<%
				if(inpatient.getAdNo()!=null || inpatient.getAdNo() !="")
				{
			%>
			data_arr[<%= i%>][2] = "<%=inpatient.getAdNo()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			String ptName ="";
			   if(patientHin.getPFirstName()+patientHin.getPLastName()!= null || patientHin.getPFirstName()+patientHin.getPLastName()!="")
			   {
				   try{
				   if(patientHin.getPFirstName()!= null){
					   ptName=patientHin.getPFirstName();
				   }
				   if(patientHin.getPMiddleName()!= null && !(patientHin.getPMiddleName().equals("null"))){
					   ptName=ptName+" "+patientHin.getPMiddleName();
				   }
				   if(patientHin.getPLastName()!= null && !(patientHin.getPLastName().equals("null"))){
					   ptName=ptName+" "+patientHin.getPLastName();
				   }
				   }catch(Exception ee){
					   ee.printStackTrace();
				   }
			%>
			data_arr[<%= i%>][3]="<%=ptName%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(inpatient.getAge()!= null || inpatient.getAge()!= "")
			   {
			%>
			data_arr[<%= i%>][4] = "<%=inpatient.getAge()%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }if(masAdministrativeSex.getAdministrativeSexName()!= null || masAdministrativeSex.getAdministrativeSexName() != "")
			   {
			%>
			data_arr[<%= i%>][5] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			   }
			   if(patientHin.getRelation() != null)
			   {
			%>
			data_arr[<%= i%>][6] = "<%=patientHin.getRelation().getRelationName()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(patientHin.getServiceNo() != null )
			   {
			%>
			<%
			String str ="";
			if(patientHin.getServiceNo()!= null){
				str=patientHin.getServiceNo();
			}
			%>
			data_arr[<%= i%>][7] = "<%=str%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%} if(patientHin.getRank() !=null){%>
			data_arr[<%= i%>][8] = "<%=patientHin.getRank().getRankName()%>"
			<%}else{%>
				data_arr[<%= i%>][8] = ""
			
			<%}%>
			<%String sName ="";
			   
				   //-----------------Service Name -------------------
				   
			   if(patientHin.getSFirstName()+patientHin.getSLastName()!= null || patientHin.getSFirstName()+patientHin.getSLastName()!="")
			   {
				   try{
				   if(patientHin.getSFirstName()!= null){
					   sName=patientHin.getSFirstName();
				   }
				   if(patientHin.getSMiddleName()!=null  && !(patientHin.getSMiddleName().equals("null"))){
					   sName=sName+" "+patientHin.getSMiddleName();
				   }
				   if(patientHin.getSLastName()!=null  && !(patientHin.getSLastName().equals("null"))){
					   sName=sName+" "+patientHin.getSLastName();
				   }
				   }catch(Exception ee1){
					   ee1.printStackTrace();
				   }
			   
				   //--------------------------------------------------
				   
			%>
			data_arr[<%= i%>][9] = "<%=sName%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<%   }if(inpatient.getDateOfAddmission() != null && !inpatient.getDateOfAddmission().equals("")){
			String date ="";
			try{
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			  date=formatterOut.format(formatterIn.parse(""+inpatient.getDateOfAddmission()));
			}catch(Exception e){
				e.printStackTrace();
			}
		%>
			data_arr[<%= i%>][10] = "<%=date%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
		int dilStatusId=0;
			String silDilStatus ="";
		  	if(inpatient.getSilDilStatus() != null){
			Set<SilDilStatus> set2=(Set<SilDilStatus>)inpatient.getSilDilStatus();
			for(SilDilStatus dilStatus :set2){
				if(dilStatus.getInpatient().getId()==inpatient.getId())
				{
					if(dilStatus.getId()>dilStatusId){
					silDilStatus=""+dilStatus.getConditionStatus();
					dilStatusId=dilStatus.getId();
					
					}
				}
			}
			if(silDilStatus.equals("")){
				silDilStatus="Normal";
			}
		%>
			data_arr[<%= i%>][11] = "<%=silDilStatus%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][11] = "Normal"
		<%}%>
		  data_arr[<%= i%>][12] = '<input type="hidden" id="iCardStatus<%=i%>"  name="iCardStatus<%=i%>" value="<%=patientHin.getServiceCardStatus()%>"  />'
		<% 	
			i++;
			}
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "patientList"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeGridForPatient(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
			  <input type="hidden" name="counter" id="counter"  value="<%=i %>"  /> 
			    <input type="hidden" name="deptId" id="deptId"  value="<%=deptId %>"  />
			    <input type="hidden" name="deptName" id="deptName"  value="<%=deptName %>" />
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script>
<script type="text/javascript">
		
		function validateICard(){
			var counter=document.getElementById("counter")
			 for(var i = 0; i < document.getElementsByName('parent').length; i++){
			
			  if(document.getElementsByName('parent')[i].checked == true)
              {
              	var index=start+i;
				var status=document.getElementById('iCardStatus'+index).value 
				if(status=="n")
				{
					alert("I-Card is not available with the patient.")
					return true;
				}
				//alert("I -Card Status for patient----:"+status)
				return true;
			  }		
  		}
  		alert("Please select the patient")
		return false;
		
	}
	

    
</script>


</form>
