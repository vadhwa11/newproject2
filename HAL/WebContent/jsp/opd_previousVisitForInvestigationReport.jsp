
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
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<%@page import="jkt.hms.masters.business.PatientInvestigationHeader"%>
<%@page import="jkt.hms.masters.business.PatientInvestigationDetails"%>
<%@page import="jkt.hms.masters.business.DgOrderhd"%><script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<%
		Map map = new HashMap();
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		int visitNoForJsp=0;
		int visitId=0;
		
		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		
//	List<Visit> patientPreviousVisitList = new ArrayList<Visit>();
    List<OpdPatientHistory> patientPreviousVisitList = new ArrayList<OpdPatientHistory>();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousVisitList") != null){
		patientPreviousVisitList=(List)map.get("patientPreviousVisitList");
	}	
	if(map.get("maxVisitIdList") != null){
		maxVisitIdList=(List)map.get("maxVisitIdList");
	}	
	if(map.get("minVisitIdList") != null){
		minVisitIdList=(List)map.get("minVisitIdList");
	}	
	List<Object> patientInvestigationList = new ArrayList<Object>();
	if(map.get("patientInvestigationList") != null){
		patientInvestigationList=(List)map.get("patientInvestigationList");
	}
	/*for (Iterator iterator = patientInvestigationList.iterator(); iterator
			.hasNext();) {
		Object object = (Object) iterator.next();
		
	}*/
	if(patientPreviousVisitList.size() > 0){
			/*
			Visit visitObj=null;
			for(Visit visit:patientPreviousVisitList){
		visitObj=visit;
	} */
	
	OpdPatientHistory visitObj=null;
	 visitObj = patientPreviousVisitList.get(0);
       
	//OpdPatientHistory visitObj = patientPreviousVisitList.get(0);
	if(visitObj!=null){
		Patient patientObj=visitObj.getHin();
		//System.out.println("list of vist for the patient-----"+patientPreviousVisitList.size());
		String pName="";
		if(visitObj.getHin().getPFirstName()!= null){
			pName=visitObj.getHin().getPFirstName();
		}
		if(visitObj.getHin().getPMiddleName()!= null){
			pName=pName+" "+visitObj.getHin().getPMiddleName();
		}
		if(visitObj.getHin().getPLastName()!= null){
			pName=pName+" "+visitObj.getHin().getPLastName();
		}
		// String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
		//int deptId=visitObj.getDepartment().getId();
		MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
	
%>


<div class="titleBg"><h2>Previous Investigation </h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForReport" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.COMMON_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"diagNo"],[12,"visitNoForJsp"],[13,"<%=RequestConstants.EMPLOYEE_ID %>"],[14,"<%=RequestConstants.DISPOSAL_ID %>"],[15,"<%=RequestConstants.DIAGNOSIS_ID%>"],[16,"days"]]; 
	 statusTd =16;

</script></div>
<div id="edited"></div>
<div id="statusMessage"></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="" />
<input type="hidden" name="visitId" id="visitId"	value="" />
<input type="hidden" name="visitNo" id="visitNo"	value="" />
<input type="hidden" name="hinId" id="hinId"	value="" />
<input type="hidden" name="investigation_header_id" id="investigation_header_id"	value="" />
<input type="hidden" name="dgOrderHdId" id="dgOrderHdId"	value="" />
<input type="hidden" name="hospitalIdForReport" id="hospitalIdForReport"	value="" />

<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Token No"
		data_header[1][1] = "hide";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%= RequestConstants.TOKEN_NO%>"
		
		data_header[2] = new Array;
		data_header[2][0] = "Visit No."
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "<%= RequestConstants.VISIT_NUMBER %>";
		
		data_header[3] = new Array;
		data_header[3][0] = "Visit Date"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header[4] = new Array;
		data_header[4][0] = "Visit Time"
		data_header[4][1] = "hide";
		data_header[4][2] = "6%";
		data_header[4][3] = "<%=RequestConstants.VISIT_TIME %>";
		
		data_header[5] = new Array;
		data_header[5][0] = "Service No"
		data_header[5][1] = "hide";
		data_header[5][2] = "5%";
		data_header[5][3] = "<%=RequestConstants.SERVICE_NO %>";
		
		
		
		data_header[6] = new Array;
		data_header[6][0] = "Appointment Type"
		data_header[6][1] = "hide";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";
		
		data_header[7] = new Array;
		data_header[7][0] = "Patient Name"
		data_header[7][1] = "hide";
		data_header[7][2] = "10%";
		data_header[7][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header[8] = new Array;
		data_header[8][0] = "Age"
		data_header[8][1] = "hide";
		data_header[8][2] = "6%";
		data_header[8][3] = "<%=RequestConstants.AGE %>";
		
		
		
		data_header[9] = new Array;
		data_header[9][0] = "Sex"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diag No."
		data_header[10][1] = "data";
		data_header[10][2] = "10%";
		data_header[10][3] = "diagNo";
		
		data_header[11] = new Array;
		data_header[11][0] = "visit No For Jsp"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "visitNoForJsp";

		data_header[12] = new Array;
		data_header[12][0] = "Doctor"
		data_header[12][1] = "data";
		data_header[12][2] = "10%";
		data_header[12][3] = "<%=RequestConstants.EMPLOYEE_ID %>";

		data_header[13] = new Array;
		data_header[13][0] = "Diagnosis"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";

		data_header[14] = new Array;
		data_header[14][0] = "Disposal"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "<%=RequestConstants.DISPOSAL_ID %>";
		
		data_header[15] = new Array;
		data_header[15][0] = "Days"
		data_header[15][1] = "hide";
		data_header[15][2] = "10%";
		data_header[15][3] = "days";
		
		//added by Babita
		data_header[16] = new Array;
		data_header[16][0] = "Speciality"
		data_header[16][1] = "data";
		data_header[16][2] = "10%";
		data_header[16][3] = "deptName";
		
		data_header[17] = new Array;
		data_header[17][0] = "ICD Diagnosis"
		data_header[17][1] = "data";
		data_header[17][2] = "10%";
		data_header[17][3] = "icdDiagnosis";
		
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
			
			String icdDaignosisString= "";
			String seperator = " | ";
		
			/*
			Iterator iterator=patientPreviousVisitList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Visit visit= (Visit) iterator.next();
		    */
		    System.out.println("size()000--"+patientInvestigationList.size());
      	  if(patientInvestigationList.size()>0){
      	  for (Iterator iterator = patientInvestigationList.iterator(); iterator
			.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		
	
      	  //Visit visit= (Visit) iterator.next();
      	  		//DgOrderhd dgOrderhd= (DgOrderhd) object[0];
      	  	PatientInvestigationHeader investigationHeader= (PatientInvestigationHeader) object[0];
      	  	//System.out.println(object[1]+"<---object[1]------object[0]"+object[0]);
      	  		Visit visit= (Visit) object[1];

      	  		//code added by Babita
           	       int count =0;
     		    			Set<DischargeIcdCode> dischageIcdSet = new HashSet<DischargeIcdCode>();
     		    			dischageIcdSet = visit.getDischargeIcdCodes();
     		       			for(DischargeIcdCode orderdt : dischageIcdSet){
     		       				
     		       				if(count++>=1)
     		       					icdDaignosisString = icdDaignosisString.concat(seperator);
     		       				
     		       				icdDaignosisString = icdDaignosisString.concat(orderdt.getIcd().getIcdName());
     		       				
     		       			}
     	        	   //end
      	  		Patient patientHin=(Patient)visit.getHin();
		        	  MasDepartment deptObj=(MasDepartment)visit.getDepartment();
		        	  String patientName="";
		        	  if(visit.getHin().getPFirstName()!= null){
		        	    patientName=visit.getHin().getPFirstName();
	   	        	  }
					if(visit.getHin().getPMiddleName()!= null){
						patientName=patientName+" "+visit.getHin().getPMiddleName();
					}
					if(visit.getHin().getPLastName()!= null)
					{
						patientName=patientName+" "+visit.getHin().getPLastName();
					}
					System.out.println();
					String doctorName="";
					  if(visit.getDoctor()!= null){
						  doctorName=visit.getDoctor().getFirstName();
						if(visit.getDoctor().getMiddleName()!= null){
							doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
						}
						if(visit.getDoctor().getLastName()!= null)
						{
							doctorName = doctorName+" "+visit.getDoctor().getLastName();
						}
		   	        	  }
						String disposal="";
						if(visit.getDisposal()!=null){
							disposal=visit.getDisposal().getDisposalName();
						}
						String diagNo="";
						Set<PatientInvestigationHeader> patientInvestigationHeaderSet=new HashSet<PatientInvestigationHeader>();
						if(visit.getPatientInvestigationHeaders()!=null){
							patientInvestigationHeaderSet=visit.getPatientInvestigationHeaders();
						}
						if(patientInvestigationHeaderSet.size()>0){
							for(PatientInvestigationHeader patientInvestigationHeader:patientInvestigationHeaderSet){
								Set<PatientInvestigationDetails> patientInvestigationDetailsSet=new HashSet<PatientInvestigationDetails>();
								if(patientInvestigationHeader.getPatientInvestigationDetails()!=null){
									patientInvestigationDetailsSet=patientInvestigationHeader.getPatientInvestigationDetails();
									diagNo=""+patientInvestigationDetailsSet.size();	
								}
							}
						}
						
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		        	  int dgOrderHdId = 0;
		        	  System.out.println("visit.getDgOrderhds()-"+visit.getDgOrderhds().size());
		      		if(visit.getDgOrderhds()!=null){
		      			for(DgOrderhd orderhd : visit.getDgOrderhds()){
		      				dgOrderHdId = orderhd.getId();
		      			}
		      		}
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="<%=visit.getId()%>"
			
				data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visit.getHin().getServiceNo()%>@<%=visit.getVisitNo()%>@<%=visit.getHin().getHinNo()%>@<%=visit.getId()%>@<%=visit.getHin().getId()%>@<%=investigationHeader.getId()%>@<%=dgOrderHdId%>@<%=visit.getHospital().getId()%>" id="parent" onclick="fillVisitNo(this)"/>'
			
			<%
				if(visit.getTokenNo()!=null)
				{
			%>
			data_arr[<%= i%>][2] = "<%=visit.getTokenNo()%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][2] = ""
			<%
				}
			   if(visit.getVisitNo()!=null)
			   {
			%>
			data_arr[<%= i%>][3]="<%=visit.getVisitNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][3]=""
			<%
				}
			   if(visit.getVisitDate()!= null )
			   {
			%>
			data_arr[<%= i%>][4] = "<%=visitDate%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }if(visit.getVisitTime()!= null || visit.getVisitTime()!= "")
			   {
			%>
			data_arr[<%= i%>][5] = "<%=visit.getVisitTime()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5] = ""
			<%
			   }
			   if(visit.getHin().getServiceNo()!= null ||visit.getHin().getServiceNo() != "")
			   {
			%>
			data_arr[<%= i%>][6] = "<%=visit.getHin().getServiceNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(visit.getAppointmentType() != null || visit.getAppointmentType() !="")
			   {
			%>
			data_arr[<%= i%>][7] = "<%=visit.getAppointmentType()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			
			<%
			  }
			   if(patientName!= null )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=patientName%>"
			<%
			   }else{
			 %>
			 data_arr[<%= i%>][8] = ""
		    <%}
			   if(visit.getHin().getAge() != null)
			   {
			%>
			
			data_arr[<%= i%>][9] = "<%=visit.getHin().getAge()%>"
            <%
			   }else{
            %> 			
			data_arr[<%= i%>][9] = ""
		<%   }if(masAdministrativeSex.getAdministrativeSexName() != null || masAdministrativeSex.getAdministrativeSexName() != ""){
		%>
			data_arr[<%= i%>][10] = "<%=masAdministrativeSex.getAdministrativeSexName()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][10] = ""
		<%}
		
			
			
		%>
			

		data_arr[<%= i%>][11] = "<%=diagNo%>"
		 data_arr[<%= i%>][12] = "<%=visitNoForJsp%>"
		<% if(doctorName != null && !doctorName.equals("")){%>
		data_arr[<%= i%>][13] = "<%=doctorName%>"
			<%}else{%>
			data_arr[<%= i%>][13] = "&nbsp;"	
			<%}%>
		
			<%
			if(visit.getWorkingDiagnosis()!= null && !visit.getWorkingDiagnosis().equals("")){
			%>
			data_arr[<%= i%>][14] = "<%=visit.getWorkingDiagnosis()%>"
				<%
				  	}else{
				%>
					data_arr[<%= i%>][14] = "&nbsp;"
				<%}%>
				<%if(disposal != null && !disposal.equals("")){%>
				data_arr[<%= i%>][15] = "<%=disposal%>"	
					<%}else{%>
					data_arr[<%= i%>][15] = "&nbsp;"		
					<%}%>
					<%if(visit.getDisposal() != null){%>
					data_arr[<%= i%>][16] = "<%=visit.getDisposalDays()%>"	
						<%}else{%>
						data_arr[<%= i%>][16] = "&nbsp;"		
						<%}%>
				        <%
						if(visit.getDepartment().getDepartmentName()!= null){
							
							%>
								data_arr[<%= i%>][17] = "<%=visit.getDepartment().getDepartmentName()%>"
							<%
							  	}else{
							%>
							data_arr[<%= i%>][17] = ""
							<%
							  	}%>	
							  	
								<%
								if(icdDaignosisString!= null){
								%>

								data_arr[<%= i%>][18] = "<%=icdDaignosisString%>"
								<%
									}else{
								%>
								data_arr[<%= i%>][18] = ""
								<%}%>
		
		<% 	
			i++;
		  }
      	  } 
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForReport"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>


<div class="clear"></div>
<%-- 
<div class="floatRight">
<label class="auto"><span>Total Patient Visit</span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden"	name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>--%>
<div class="division"></div>
<%-- <input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForReport','opd?method=showOPDMainJsp&visitId=<%=visitId%>&deptId=<%=deptId%>');" /> --%>
<input type="button" name="close" id="close"	onclick="window.close();" value="Close"	class="button" accesskey="a" />
<input type="button" name="printReport" id="print"	onclick="submitFormForPrescriptionReport();" value="print report"	class="button" accesskey="a" />

<input type="button" name="printReport" id="print" 	onclick="openInvestigationDetails();" value="Investigation Details"	class="buttonBig" accesskey="a" />
<div class="clear"></div>
<div class="division"></div>

</form>

<% 
		}
		}else{ %>

<form name="opdPatientPrevVisitForReport" method="post" action="">
<h4>No Previous Investigation Records Found </h4>
<div class="clear"></div>
<input type="button" name="close" id="close"	onclick="window.close();" value="Close"	class="button" accesskey="a" />
<!--  <input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" />-->
</form>
<% } %>

<div id="testP"></div>
<script type="text/javascript">	
function openInvestigationDetails(){
	var flag = validateRadioForVisitNo();
	var orderNo = '';
	if(flag == false){
		return false;
	}else{
		var printId = document.getElementById('print');
		var hinId = document.getElementById('hinId').value ;
		//submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousPrescriptionRepeat');
	//	submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientPreviousInvestigation','testP');
			submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/lab?method=viewAllTestForOrderNo&hinId='+hinId,'testP');
		checkTargetForNo();
	}
	
}	
<%--
function clearTestDivDown(id,resultType,resultStatus,confidential){
	
		//window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
		var url='lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'';
	    newwindow=window.open(url,'Symptom',"left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1");
} --%>

function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
	document.getElementById('testDivDown').innerHTML = "";
	if(flag == 'rhLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rdRadio'){
		//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
		window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
	}
	if(flag == 'rhSenLab'){
		window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
		//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
	}
	if(flag == 'rEntryDetailLab'){
		if(resultType == 's'){
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
		}else{
			window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','newWindow','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
		}
	}
}

	function submitFormForPrescriptionReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			
			submitForm('opdPatientPrevVisitForReport','/hms/hms/opd?method=showPatientInvestigationReport');
			checkTargetForNo();
		}
		
	}
	
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		
		var allValuesArray = allValues.split("@");
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('visitNumberForReport').value = allValuesArray[1]; 
		document.getElementById('visitNo').value = allValuesArray[1];
		document.getElementById('hinNoForReport').value = allValuesArray[2];
		document.getElementById('visitId').value = allValuesArray[3];
		document.getElementById('hinId').value = allValuesArray[4];
		document.getElementById('investigation_header_id').value = allValuesArray[5];
		document.getElementById('dgOrderHdId').value = allValuesArray[6];
		document.getElementById('hospitalIdForReport').value = allValuesArray[7];
	}
	
	function validateRadioForVisitNo(){
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
	
</script>

<script type="text/javascript">

	function setValuesInParent(formname){
  		formName=formname.name;
  		
  		var hiddenValue = window.opener.document.getElementById('hiddenValue').value;
 		var chargeCodeNameVal = window.opener.document.getElementById('chargeCodeName1').value;

		if(hiddenValue == 1 && chargeCodeNameVal == ''){
			var len = window.opener.document.getElementById("investigationGrid").rows.length;
			var r1 = window.opener.document.getElementById("investigationGrid").deleteRow(len-1);
		}
  		
		//window.opener.document.getElementById('date').value
		//var qtyIssuedList = document.getElementsByName("qtyIssued");
		//alert("value of counter--"+document.patientInvestigation.counter.value)
		for(var index = 1; index < parseInt(document.patientInvestigation.counter.value); index++ ){
			var toEval = "document.patientInvestigation.repeatInvestigation" + index;
			var repeatIn = eval(toEval);
			if(repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("investigationGrid").rows.length;
				  var r = window.opener.document.getElementById("investigationGrid").insertRow(len);
				  
				  var c1 = r.insertCell(0);
				  var c2 = r.insertCell(1);
				  var c3 = r.insertCell(2);
				  var c4 = r.insertCell(3);
				  
				  var chargeCodeName=eval('document.'+formName+'.ChargeCodeName' + index + '.value')
				  var chargeId=eval('document.'+formName+'.chargeCodeId' + index + '.value')
				  
				  var x1 = document.createElement('input');
				  x1.type = 'text';
				  x1.name='chargeCodeName'+len;
				  x1.id='chargeCodeName'+len;
				  x1.size = '100';
	  			  x1.setAttribute('tabindex','1');						  
	  			  x1.value = chargeCodeName+'['+chargeId+']';
				  //x1.value = chargeCodeName+"["+chargeId+"]";
				  //x1.setAttribute("readonly","readonly");
				  c1.appendChild(x1);
				 
				  var divElement = document.createElement('div');
				  divElement.id='ac2update2';
				  divElement.style.display = 'none';
				  //divElement.style.fontWeight = 'normal;';
				  //divElement.style.border = '0px solid white;';
				  divElement.style.paddingRight = '10px;';
				 // divElement.style.backgroundColor = 'white;';
				  c1.appendChild(divElement);
				 
				 // var chargeCode=eval('document.'+formName+'.chargeCode' + index + '.value')
				   
				  var x2 = document.createElement('input');
				  x2.type = 'hidden';
				  x2.name='chargeCode'+len;
				  x2.id='chargeCode'+len;
				  //x2.value = chargeCode;
	  			  x2.setAttribute('tabindex','1');				  
				  x2.setAttribute("readonly","readonly");
				  c1.appendChild(x2);

				  //var quantity = eval('document.'+formName+'.qty' + index + '.value');
				  
				  var x3 = document.createElement('input');
				  x3.type = 'hidden';
				  x3.name='qty'+len;
				  x3.id='qty'+len;
	  			  x3.setAttribute('tabindex','1');				  
				 // x3.value = quantity;
				  x3.setAttribute("readonly","readonly");
				  c1.appendChild(x3);
				  
				  //var clinicalNotes = eval('document.'+formName+'.clinicalNotes' + index + '.value');
			  /*
				  var x4 = document.createElement('input');
				  x4.type = 'hidden';
				  x4.name='clinicalNotes'+len;
				  x4.id='clinicalNotes'+len;
	  			  x4.setAttribute('tabindex','1');				  
				  //x4.value = clinicalNotes;
				  x4.size = '60';
				  x4.setAttribute("readonly","readonly");
				  c1.appendChild(x4);
				  
			  */

			  var e3 = document.createElement('input');
			  e3.type = 'checkbox';
			  e3.name='referToMh'+len;
			  e3.id='referToMhId'+len
			  e3.size='10';
			  e3.className='radio';
			  e3.value='y';
			  e3.setAttribute('tabindex','1');
			  c2.appendChild(e3);
			  
				  var x5 = window.opener.document.getElementById('hiddenValue');
				  x5.value=len;

				  var x6 = document.createElement('input');
				  x6.type = 'button';
				  //x6.name='clinicalNotes'+len;
				  //x6.id='clinicalNotes'+len;
				  x6.className = 'buttonAdd';
	  			  x6.setAttribute('tabindex','1');	
	  			  x6.setAttribute('onClick','addRowForInvestigation();');			  
				 // x6.value = clinicalNotes;
				 // x6.size = '60';
				 // x6.setAttribute("readonly","readonly");
				  c3.appendChild(x6);

				  var x7 = document.createElement('input');
				  x7.type = 'button';
				  //x6.name='clinicalNotes'+len;
				  //x6.id='clinicalNotes'+len;
				  x7.className = 'buttonDel';
	  			  x7.setAttribute('tabindex','1');	
	  			  x7.setAttribute('onClick','removeRowForInvestigation();');			  
				 // x6.value = clinicalNotes;
				 // x6.size = '60';
				 // x6.setAttribute("readonly","readonly");
				  c4.appendChild(x7);



				  
			}
		}
		
		window.close();
  	}
		
	
		
</script>