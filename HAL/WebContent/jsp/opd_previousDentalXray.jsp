
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

<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.RequestConstants"%>
<%@page import="java.util.*"%>



<%@page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.Visit"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>



<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">
<!-- <script type="text/javascript" language="javascript" src="/his/jsp/js/proto.js"></script> -->
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
		
	List<Object[]> patientPreviousVisitDentalList= new ArrayList<Object[]>();
	
	
	if(map.get("patientPreviousVisitDentalList") != null){
		patientPreviousVisitDentalList=(List)map.get("patientPreviousVisitDentalList");
	}	
	

	
	if(patientPreviousVisitDentalList.size() > 0){
		
	String pName="";
	String serviceNo="";
	String hinNo="";
	int hinId = 0;
	int visitIdForReport=0;
	int deptIdFromVisit=0;
	Iterator itr = patientPreviousVisitDentalList.iterator();
	while(itr.hasNext())
	{
		Object[] pair = (Object[]) itr.next();
		
		serviceNo = (String) pair[1];
		pName = (String) pair[1];
		hinNo = (String) pair[1];
		hinId = 1;
		visitIdForReport = 22;
	}
	
	
%>


<div class="titleBg"><h2>Previous History of Dental X-Ray</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','/his/his/ipd/ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1,"patient_id"],[2,"patient_name"],[3,"gender"],[4,"image_datetime"] ];
	 statusTd =15;

</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=serviceNo%>" />
<input type="hidden" name="visitId"	id="visitNumberForReport" value="<%=visitIdForReport%>" />
<input type="hidden" name="hospitalId"	id="hospitalId" value="" />
<input type="hidden"	name="hinNoForReport" id="hinNoForReport" value="<%=hinNo%>" />
<input type="hidden"	name="hinId" id="hinId" value="<%=hinId%>" />
<input type="hidden"	name="hinIdHIS" id="hinIdHIS" value="<%=hinId%>" />

 
<script	type="text/javascript" language="javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "S.No."
		data_header[0][1] = "data";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Patient Id"
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "patient_id"
		
		data_header[2] = new Array;
		data_header[2][0] = "Patient Name"
		data_header[2][1] = "data";
		data_header[2][2] = "10%";
		data_header[2][3] = "patient_name";
		
		data_header[3] = new Array;
		data_header[3][0] = "Gender"
		data_header[3][1] = "data";
		data_header[3][2] = "5%";
		data_header[3][3] = "gender";
		
		data_header[4] = new Array;
		data_header[4][0] = "Study Date"
		data_header[4][1] = "data";
		data_header[4][2] = "6%";
		data_header[4][3] = "image_datetime";
		
		


		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		
		try{
			String st="";
		
			Iterator iterator=patientPreviousVisitDentalList.iterator();
			
		    
		          while(iterator.hasNext())
		           {   
		        	  Object[] pair = (Object[]) iterator.next();
		        	  
		        	 
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="1" // img_id
			
			data_arr[<%= i%>][1] ="<%= i+1%>";
			
			data_arr[<%= i%>][2] = "<%= pair[1]%>";
			data_arr[<%= i%>][3]="<%= pair[5]%>";
			data_arr[<%= i%>][4]="";
			
			
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opdPatientPrevVisitForViewScreen"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Clear"></div>
<%-- <div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>--%>
<div class="division"></div>
<!--<input name="Back" type="button" alt="Back" value="Back" class="button"	onclick="backtoHome()"/>
-->

 


<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>"></form>
<% }else{ %>

<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
<h4>No Previous X-Ray Found </h4>
<div class="Clear"></div>
<input name="Back" type="button"	alt="Back" value="Close" class="button"	onclick="window.close();" /><input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>"></form>

 <!-- <input name="Back" type="button" value="Back" class="button"	onclick="history.go(-1);return false;"/>
 -->
<% } %>

<script type="text/javascript">	
	function submitFormForPrescriptionReport1(){
		var flag = validateRadioForVisitNo1();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
		/* 	submitForm('opdPatientPrevVisitForViewScreen','/his/his/opd/opd?method=showPatientPrescriptionReport'); */
			submitForm('opdPatientPrevVisitForViewScreen','/hms/hms/opd?method=showPatientMedicalCaseSheetHISReport&caseSheetFlag=yes');
			checkTargetForNo();
		}
		
	}
	
	function fillVisitNo1(printValueObj,count){
		var allValues = printValueObj.value;		
		var allValuesArray = allValues.split("@");
		//alert(allValuesArray);
		document.getElementById('visitNumberForReport1').value = allValuesArray[0];
		document.getElementById('hospitalIdForReport1').value = allValuesArray[1];  
		//document.getElementById('db_flag_value').value = document.getElementById('db_flag_'+count).value;
		
		document.getElementById('serviceNoForReport1').value = allValuesArray[3];
		document.getElementById('hinNoForReport1').value =allValuesArray[2];
		

	}
	
	function validateRadioForVisitNo1(){
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
  		alert("Please select one row");
		return false;
	}
	<%-- function showPreviousVisit(hinId,deptId,visitNo,token){
		
		if(visitNo >=1){
		
	 
       document.opdPatientPrevVisitForViewScreen.action=encodedUrlBy64Bit("/his/his/opd/opd?method=getPatientOpdDetails&flag=current&hinId="+hinId+"&deptId="+deptId+"&visitNumber="+visitNo+"&token="+token+"&link=<%=link%>");
      
       document.opdPatientPrevVisitForViewScreen.submit();
       
        }else{
         alert("This Is Patient's first Visit.")
       }
    } --%>
	<%-- function backtoHome()
	{
		<%
		if(flag.equals("registration")){
		%>
		 document.opdPatientPrevVisitForViewScreen.action=encodedUrlBy64Bit("/his/his/registration/registration?method=showRegistrationJsp");
			
		<%}else{%>
		 document.opdPatientPrevVisitForViewScreen.action=encodedUrlBy64Bit("/his/his/opd/opd?method=showOPDMainJsp&visitId=<%=visitId%>&token=<%=token%>");
		 <%}%>
		document.opdPatientPrevVisitForViewScreen.submit();
		
	} --%>
	
</script>
