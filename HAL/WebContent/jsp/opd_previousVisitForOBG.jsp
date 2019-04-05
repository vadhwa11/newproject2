
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

<%@page import="jkt.hms.masters.business.ObgDetails"%>
<%@page import="jkt.hms.masters.business.OpdPatientDetails"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.OpdPatientHistory"%>
<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%@page import="jkt.hms.masters.business.MasDiagnosisConclusion"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js?n=1"></script>
<link href="/hms/jsp/css/style.css?n=1" rel="stylesheet" type="text/css" />
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
		int token=0;
		String backFlag = "";
		String medExamType ="";
		if(map.get("visitNoForJsp") != null){
			visitNoForJsp=(Integer)map.get("visitNoForJsp");
		}
		if(map.get("backFlag") != null){
			backFlag=(String)map.get("backFlag");
		}
		String url = "";
		
		if(map.get("token") != null){
			token = (Integer)map.get("token");
		}
		if(map.get("visitId") != null){
			visitId = (Integer)map.get("visitId");
		}
		//System.out.println("medExamType  in opdPreviousVisit***********"+map.get("medExamType"));
       /* if(map.get("medExamType")!= null)
          {
        	medExamType = (String)map.get("medExamType");
          }*/
		
          
	List<OpdPatientDetails> patientPreviousDetails = new ArrayList<OpdPatientDetails>();
	List<Integer> maxVisitIdList = new ArrayList<Integer>();
	List<Integer> minVisitIdList = new ArrayList<Integer>();
	
	if(map.get("patientPreviousDetails") != null){
		patientPreviousDetails=(List<OpdPatientDetails>)map.get("patientPreviousDetails");
	}
	if(map.get("url") != null)
	  {
		url = ""+map.get("url");
		
	  }
	//url=url+"&visitId="+visitId+"&medExamType="+medExamType;
	
	
	if(map.get("maxVisitIdList") != null){
		maxVisitIdList=(List)map.get("maxVisitIdList");
	}	
	if(map.get("minVisitIdList") != null){
		minVisitIdList=(List)map.get("minVisitIdList");
	}	
	String link="";
	if(map.get("link") != null){
		link=(String)map.get("link");
	}
	String flag="";
	if(map.get("flag")!=null){
		flag = (String)map.get("flag");
	}
	String FlagFOrMedExamMa = "";
	if(map.get("FlagFOrMedExamMa")!= null)
	{
		FlagFOrMedExamMa = (String)map.get("FlagFOrMedExamMa");
	}
	if(patientPreviousDetails.size() > 0){

		OpdPatientDetails visitObj = patientPreviousDetails.get(0);
	//Visit visitObj=(Visit)patientPreviousDetails.get(0);
	Patient patientObj=visitObj.getVisit().getHin();
	String bloodGroup="";
	if(visitObj.getVisit().getHin()!= null){
		bloodGroup=visitObj.getVisit().getHin().getBloodGroup().getBloodGroupName();
	}
/* 	if(visitObj.getHin().getPMiddleName()!= null){
		pName=pName+" "+visitObj.getHin().getPMiddleName();
	}
	if(visitObj.getHin().getPLastName()!= null){
		pName=pName+" "+visitObj.getHin().getPLastName();
	} */
	// String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
	int deptId=0;
	if(visitObj.getDepartment()!=null)
		deptId = visitObj.getDepartment().getId();
	MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
%>

<div class="popupbg">
<div class="titleBg"><h2>Previous OBG Visits</h2></div>

<div class="Block">
<%Set<ObgDetails> obgdetailsList = patientPreviousDetails.get(0).getObgDetails();
if(obgdetailsList.size()>0){
	ObgDetails obgdetails = new ObgDetails();
	for(ObgDetails obg:obgdetailsList)
		obgdetails = obg;
		
%>

<label class="auto">Obstetric Score</label> <label class="auto">G</label><label class="valueAuto"><%=obgdetails.getObstreticScoreG()!=null?obgdetails.getObstreticScoreG():""%></label>
<label class="auto">P</label><label class="valueAuto"><%=obgdetails.getObstreticScoreP()!=null?obgdetails.getObstreticScoreP():""%></label>
<label class="auto">A</label><label class="valueAuto"><%=obgdetails.getObstreticScoreA()!=null?obgdetails.getObstreticScoreA():""%></label>
<label class="auto">L</label><label class="valueAuto"><%=obgdetails.getObstreticScoreL()!=null?obgdetails.getObstreticScoreL():""%></label>
<label>LMP Date</label> <label class="value"><%=patientPreviousDetails.get(0).getLmpDate()!=null?HMSUtil.convertDateToStringWithoutTime(patientPreviousDetails.get(0).getLmpDate()):""%></label>
<label>EDD Date</label> <label class="value"><%=patientPreviousDetails.get(0).getEddDate()!=null?HMSUtil.convertDateToStringWithoutTime(patientPreviousDetails.get(0).getEddDate()):""%></label><div class="Clear"></div>
<label>TT</label> <label class="value"><%=obgdetails.getTt()!=null?obgdetails.getTt():""%></label>
<label>Blood Group</label> <label class="value"><%=bloodGroup%></label><div class="Clear"></div>

<label>Obstetric H/o</label> <textarea class="large"><%=obgdetails.getObstreticHistory()!=null?obgdetails.getObstreticHistory():""%></textarea> 
			
			
			
<%}%>
 </div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock1.jsp" />


<form name="opdPatientPrevVisitForViewScreen1" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable1" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_ID %>","visitId"], [4,"<%= RequestConstants.SERVICE_NO %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.HIN_NO%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"disposal"],[14,"days"]  ];
	 //statusTd =13;

</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<%-- <input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visitObj.getHin().getServiceNo()%>" />
<input type="hidden" name="hospitalIdForReport"	id="hospitalIdForReport" value="" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="<%=visitObj.getHin().getHinNo()%>" /> --%>
 	<input name="visitId" id="visitId" type="hidden" value="<%=visitObj.getId()%>" />
<script	type="text/javascript" language="javascript">
		
		data_header1 = new Array();
		
		<%-- data_header1[0] = new Array;
		data_header1[0][0] = " "
		data_header1[0][1] = "hide";
		data_header1[0][2] = "5%";
		data_header1[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		 --%>
		data_header1[0] = new Array;
		data_header1[0][0] = "Visit Date"
		data_header1[0][1] = "data";
		data_header1[0][2] = "8%";
		data_header1[0][3] = "<%= RequestConstants.TOKEN_NO%>"
		
		data_header1[1] = new Array;
		data_header1[1][0] = "Weight"
		data_header1[1][1] = "data";
		data_header1[1][2] = "10%";
		data_header1[1][3] = "<%= RequestConstants.VISIT_NUMBER %>";
		
		data_header1[2] = new Array;
		data_header1[2][0] = "Period of Gestation"
		data_header1[2][1] = "data";
		data_header1[2][2] = "5%";
		data_header1[2][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header1[3] = new Array;
		data_header1[3][0] = "GC"
		data_header1[3][1] = "data";
		data_header1[3][3] = "5%";
		data_header1[3][3] = "<%=RequestConstants.VISIT_DATE %>";
		
		data_header1[4] = new Array;
		data_header1[4][0] = "PA^"
		data_header1[4][1] = "data";
		data_header1[4][2] = "6%";
		data_header1[4][4] = "<%=RequestConstants.VISIT_TIME %>";
		
		data_header1[5] = new Array;
		data_header1[5][0] = "Pe^"
		data_header1[5][1] = "data";
		data_header1[5][2] = "5%";
		data_header1[5][3] = "<%=RequestConstants.SERVICE_NO %>";
		
		
		
		data_header1[6] = new Array;
		data_header1[6][0] = "PR"
		data_header1[6][1] = "data";
		data_header1[6][2] = "6%";
		data_header1[6][3] = "<%=RequestConstants.APPOINTMENT_TYPE %>";
		
		data_header1[7] = new Array;
		data_header1[7][0] = "BP"
		data_header1[7][1] = "data";
		data_header1[7][2] = "10%";
		data_header1[7][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		data_header1[8] = new Array;
		data_header1[8][0] = "Height of Uterus"
		data_header1[8][1] = "data";
		data_header1[8][2] = "10%";
		data_header1[8][3] = "<%=RequestConstants.PATIENT_NAME %>";
		
		
		data_header1[9] = new Array;
		data_header1[9][0] = "FHR"
		data_header1[9][1] = "data";
		data_header1[9][2] = "1%";
		data_header1[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header1[10] = new Array;
		data_header1[10][0] = "Presentation"
		data_header1[10][1] = "data";
		data_header1[10][2] = "10%";
		data_header1[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header1[11] = new Array;
		data_header1[11][0] = "PV"
		data_header1[11][1] = "data";
		data_header1[11][2] = "11%";
		data_header1[11][3] = "visitNoForJsp";

		data_header1[12] = new Array;
		data_header1[12][0] = "Remarks"
		data_header1[12][1] = "data";
		data_header1[12][2] = "11%";
		data_header1[12][3] = "remarks";
		
		
		data_arr1 = new Array();
		
		<%
		//int  i=0;
		String presentcomplain = null;
		String presentfamilyhistroy = null;
		String icdDaignosisString= "";
		//end
		try{
			String st="";
			String seperator = " | ";
	
		        /*   for(int i=0;  i<patientPreviousDetails.size();i++)
		           {  */
		        	int i=0;
		           ObgDetails obgDetails = null;
		          for(OpdPatientDetails opdDetails:patientPreviousDetails)
		           { 	
		        	  System.out.println("i="+opdDetails.getId());
		           
		        	  icdDaignosisString= "";
		        
		        	   Visit visit= (Visit) opdDetails.getVisit();
		        	   for(ObgDetails obg:opdDetails.getObgDetails())
		        		   obgDetails = obg;
		        	   
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
					 
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		%>
		
			data_arr1[<%= i%>] = new Array();
			
			
			
			
				<%if(visit.getVisitDate()!=null)
				{
					%>
					data_arr1[<%= i%>][1] = "<%=HMSUtil.convertDateToStringWithoutTime(visit.getVisitDate())%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][1] = ""
					<%
				}%>
			
				<%if(opdDetails.getVweight()!=null && opdDetails.getVweight()!="0")
				{
					%>
					data_arr1[<%= i%>][2] = "<%=opdDetails.getVweight()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][2] = ""
					<%
				}%>
				
				
			<%if(opdDetails.getOperationPeriodToday()!=null)
				{
					%>
					data_arr1[<%= i%>][3] = "<%=opdDetails.getOperationPeriodToday()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][3] = ""
					<%
				}%>
			
				<%if(obgDetails.getGc()!=null)
				{
					%>
					data_arr1[<%= i%>][4] = "<%=obgDetails.getGc()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][4] = ""
					<%
				}%>
				
				<%if(obgDetails.getPa()!=null)
				{
					%>
					data_arr1[<%= i%>][5] = "<%=obgDetails.getPa()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][5] = ""
					<%
				}%>
				
				<%if(obgDetails.getPe()!=null)
				{
					%>
					data_arr1[<%= i%>][6] = "<%=obgDetails.getPe()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][6] = ""
					<%
				}%>
				
				<%if(opdDetails.getPr()!=null && opdDetails.getPr()!=0)
				{
					%>
					data_arr1[<%= i%>][7] = "<%=opdDetails.getPr()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][7] = ""
					<%
				}%>
				
				<%if(opdDetails.getBp()!=null)
				{
					%>
					data_arr1[<%= i%>][8] = "<%=opdDetails.getBp()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][8] = ""
					<%
				}%>
				
				<%if(obgDetails.getFhr()!=null)
				{
					%>
					data_arr1[<%= i%>][9] = "<%=obgDetails.getHeightOfUterus()!=null?obgDetails.getHeightOfUterus():""%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][9] = ""
					<%
				}%>
				
				<%if(obgDetails.getFhr()!=null)
				{
					%>
					data_arr1[<%= i%>][10] = "<%=obgDetails.getFhr()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][10] = ""
					<%
				}%>
				<%if(obgDetails.getPresentation()!=null)
				{
					%>
					data_arr1[<%= i%>][11] = "<%=obgDetails.getPresentation()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][11] = ""
					<%
				}%>
				<%if(obgDetails.getPv()!=null)
				{
					%>
					data_arr1[<%= i%>][12] = "<%=obgDetails.getPv()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][12] = ""
					<%
				}%>
				<%if(obgDetails.getObgRemarks()!=null)
				{
					%>
					data_arr1[<%= i%>][13] = "<%=obgDetails.getObgRemarks()%>"
					<%
				}else{
					%>
					data_arr1[<%= i%>][13] = ""
					<%
				}%>
		
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForViewScreen1"
		
		
		start1 = 0
		if(data_arr1.length < rowsPerPage)
			end1 = data_arr1.length;
		else
			end1 = rowsPerPage;
		makeTable1(start1,end1);
		
		intializeHover('searchresulttable1', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%-- <div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>--%>
<!-- <div class="division"></div> -->

<!-- <input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport();" value="Case Sheet"	class="buttonBig" accesskey="a" /> --> 
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForViewScreen','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} %>


<div class="clear"></div>
<!-- <div class="division"></div> -->
</form>
<% }else{ %>

<form name="opdPatientPrevVisitForViewScreen1" method="post" action="">
<div class="popupbg">
<h4>No Previous Visit Records Found </h4>
<div class="Clear"></div>
<%if(backFlag.equals("OPD") || backFlag.equals("dental")){ %>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForViewScreen','opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>');"/>-->
<input name="close" type="button" value="close" class="button" onclick="window.close();"/>
<%} }%>

</div>
</form>
</div>
<script type="text/javascript">	
	function submitFormForPrescriptionReport(){
		//var flag = validateRadioForVisitNo();
		var orderNo = '';
	/* 	if(flag == false){
			return false;
		}else{ */
			var printId = document.getElementById('print');
	//	checkTargetForYes();
			//printId.setAttribute("type","submit");
		//	submitForm('opdPatientPrevVisitForViewScreen','/hms/hms/opd?method=opdMedicalCaseSheetPrint');
		submitForm('opdPatientPrevVisitForViewScreen1','/hms/hms/opd?method=showPatientMedicalCaseSheetReport');
		
		//	checkTargetForNo();
		//}
		
	}
	
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		
		var allValuesArray = allValues.split("@");
		
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('hospitalIdForReport').value = allValuesArray[1]; 
		document.getElementById('hinNoForReport').value = allValuesArray[2];  
		document.getElementById('visitId').value = allValuesArray[3];  
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
	function showPreviousVisit(hinId,deptId,visitNo,token){
		
		if(visitNo >=1){
		
	 
       document.opdPatientPrevVisitForViewScreen.action="/hms/hms/opd?method=getPatientOpdDetails&flag=current&hinId="+hinId+"&deptId="+deptId+"&visitNumber="+visitNo+"&token="+token+"&link=<%=link%>";
      
       document.opdPatientPrevVisitForViewScreen.submit();
       
        }else{
         alert("This Is Patient's first Visit.")
       }
    }
	function backtoHome()
	{
		<%
		if(flag.equals("registration")){
		%>
		 document.opdPatientPrevVisitForViewScreen.action="registration?method=showRegistrationJsp";
			
		<%}else{%>
		 document.opdPatientPrevVisitForViewScreen.action="opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>";
		 <%}%>
		
		
	}
	
</script>


<%--  <%@ include file="opd_previousVisitForViewScreenHIS.jsp" %>
 --%>