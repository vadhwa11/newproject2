
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

<%@page import="jkt.hms.masters.business.Patient"%>

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
	
		
		//String includedJsp = null;
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
	
		}
		int visitNoForJsp1=0;
		/* int visitId1=0; */
		int token1=0;

		if(map.get("visitNoForJsp") != null){
			visitNoForJsp1=(Integer)map.get("visitNoForJsp");
		}
		
		

		if(map.get("visitNoForJsp") != null){
			visitNoForJsp1=(Integer)map.get("visitNoForJsp");
		}
		if(map.get("token") != null){
			token1 = (Integer)map.get("token");
		}
		/* if(map.get("visitId") != null){
			visitId1 = (Integer)map.get("visitId");
		} */

		
	List<Object> patientPreviousVisitHISList = new ArrayList<Object>();
		List<Object> visitInfoList = new ArrayList<Object>();
	
	
	if(map.get("patientPreviousVisitHISList") != null){
		patientPreviousVisitHISList=(List)map.get("patientPreviousVisitHISList");
	}	
	if(map.get("visitInfoList") != null){
		visitInfoList=(List)map.get("visitInfoList");
	}	

	
	String link1="";
	if(map.get("link") != null){
		link1=(String)map.get("link");
	}
	String flag1="";
	if(map.get("flag")!=null){
		flag1 = (String)map.get("flag");
	}
	if(patientPreviousVisitHISList.size() > 0){
		
	String pName="";
	String serviceNo="";
	String hinNo="";
	int hinId = 0;
	int visitIdForReport=0;
	int deptIdFromVisit=0;
	Iterator itr = patientPreviousVisitHISList.iterator();
	while(itr.hasNext())
	{
		Object[] pair = (Object[]) itr.next();
		
		serviceNo = (String) pair[5];
		pName = (String) pair[6];
		hinNo = (String) pair[9];
		hinId = Integer.parseInt(""+pair[3]);
		visitIdForReport = Integer.parseInt(""+pair[0]);
	}
	
	
%>


<div class="titleBg"><h2>Previous Visits of HIS</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','/his/his/ipd/ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>","visitNumber"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"disposal"],[14,"days"],[15,"hospital_name"],[16,"db_flag"] ];
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
		data_header[1][0] = "Token No."
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
		data_header[5][0] = "Service No."
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
		data_header[9][0] = "Gender"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diagnosis"
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "visit No. For Jsp"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "visitNoForJsp";

		data_header[12] = new Array;
		data_header[12][0] = "hinId"
		data_header[12][1] = "hide";
		data_header[12][2] = "10%";
		data_header[12][3] = "HinId";
		data_header[13] = new Array;
		data_header[13][0] = "Dept Id"
		data_header[13][1] = "hide";
		data_header[13][2] = "10%";
		data_header[13][3] = "deptId";

		data_header[14] = new Array;
		data_header[14][0] = "Department"
		data_header[14][1] = "hide";
		data_header[14][2] = "10%";
		data_header[14][3] = "department";

		data_header[15] = new Array;
		data_header[15][0] = "Medical Officer"
		data_header[15][1] = "data";
		data_header[15][2] = "10%";
		data_header[15][3] = "doctor";

		data_header[16] = new Array;
		data_header[16][0] = "token"
		data_header[16][1] = "hide";
		data_header[16][2] = "10%";
		data_header[16][3] = "token";
		
		data_header[17] = new Array;
		data_header[17][0] = "link"
		data_header[17][1] = "hide";
		data_header[17][2] = "10%";
		data_header[17][3] = "link";

		data_header[18] = new Array;
		data_header[18][0] = "Diagnosis"
		data_header[18][1] = "data";
		data_header[18][2] = "10%";
		data_header[18][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[19] = new Array;
		data_header[19][0] = "Disposal"
		data_header[19][1] = "data";
		data_header[19][2] = "10%";
		data_header[19][3] = "Disposal";
		
		data_header[20] = new Array;
		data_header[20][0] = "Days"
		data_header[20][1] = "data";
		data_header[20][2] = "10%";
		data_header[20][3] = "days";
		
		data_header[21] = new Array;
		data_header[21][0] = "Hospital"
		data_header[21][1] = "data";
		data_header[21][2] = "10%";
		data_header[21][3] = "hospital_name";
		
		data_header[22] = new Array;
		data_header[22][0] = "DB"
		data_header[22][1] = "hide";
		data_header[22][2] = "10%";
		data_header[22][3] = "db_flag";


		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		int visitId1=0;
		int visitNo=0;
		int tokenNo=0;
		String ServiceNoForRowVal="";
		String hinNoForRowVal="";
		int deptId=(Integer)session.getAttribute("deptId");
		int refferalDeptId=0;
		//int hospitalId = 0;
		
		try{
			String st="";
		
			Iterator iterator=patientPreviousVisitHISList.iterator();
			Iterator it=visitInfoList.iterator();
		    
		          while(iterator.hasNext())
		           {   
		        	  Object[] pair = (Object[]) iterator.next();
		        	  Object[] pair1 = null;
		        	  /* if(it.hasNext()!=false){
		        		pair1=(Object[]) it.next();
		        	  } */
		        		visitId = Integer.parseInt(""+pair[0]);
		        		visitNo = Integer.parseInt(""+pair[1]);
		        	
		        		deptIdFromVisit=visitId;
		        	
		        		
		        		
		        		if(pair[2]!=null)
		        		{
		        		tokenNo = Integer.parseInt(""+pair[2]);
		        		}
		        		
		        		
		        		if(pair[5]!=null)
		        		{
		        			ServiceNoForRowVal = (String) pair[5];
		        		}
		        		
		        		if(pair[9]!=null)
		        		{
		        			hinNoForRowVal = (String) pair[9];
		        		} 
		        		/* if(pair[12]!= null){
		        			hospitalId = (Integer) pair[12];
		        		} */
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="<%=visitId1%>"
			<%
			if(deptIdFromVisit==51 && deptId==deptIdFromVisit){ %>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visitId%>@<%=pair[12]%>" id="parent" onclick="fillVisitNo1(this,<%= i%>)"/>'
			<%}else	if(deptIdFromVisit==51 && refferalDeptId==deptId){ %>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visitId%>@<%=pair[12]%>" id="parent" onclick="fillVisitNo1(this,<%= i%>)"/>'
			<%}else	if(deptIdFromVisit==51 && refferalDeptId!=deptId){ %>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" disabled name="parent" value="<%=visitId%>@<%=pair[12]%>" id="parent" onclick="fillVisitNo1(this,<%= i%>)"/>'
			<%}else{ %>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visitId%>@<%=pair[12]%>" id="parent" onclick="fillVisitNo1(this,<%= i%>)"/>'
			<%}%><%-- else{ System.out.println("4");%>
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visitId%>@<%=pair[12]%>" id="parent" onclick="fillVisitNo(this)"/>'
			<%} --%>
			
			
			data_arr[<%= i%>][2] = "<%=tokenNo%>"
			data_arr[<%= i%>][3]="<%=visitNo%>"
			
			<%
				
			if(pair[4]!=null)
			   {
			%>
			data_arr[<%= i%>][4] = "<%=pair[4]%>"
			<%
			   }else{
			%> 
			data_arr[<%= i%>][4] = ""
			<%
			   }
			%>
			data_arr[<%= i%>][5] = ""
			
			<%
			  
			if(pair[5]!=null)
			   {
			%>
			data_arr[<%= i%>][6] = "<%=pair[5]%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   
			%>
			data_arr[<%= i%>][7] = ""
			
			
			<%
			  if(pName!= "" )
			   {
			%>
			data_arr[<%= i%>][8] = "<%=pName%>"
			<%
			   }else{
			 %>
			 data_arr[<%= i%>][8] = ""
		    <%}
			  
			%>
			
			data_arr[<%= i%>][9] = ""
        
			data_arr[<%= i%>][10] = ""
		
		
			data_arr[<%= i%>][11] = ""
	
			
		
		 data_arr[<%= i%>][12] = "<%=visitNo%>"
		 data_arr[<%= i%>][13] = "<%=pair[3]%>"
		 data_arr[<%= i%>][14] = ""
		 data_arr[<%= i%>][15] = ""
		  <% if(pair[7]!= null){%>
		
		  data_arr[<%= i%>][16] = "<%=pair[7]%>"
        
        <% }else{%>
		data_arr[<%= i%>][16] = ""
						<%}%>	
		data_arr[<%= i%>][17] = "<%=token%>"	 
		data_arr[<%= i%>][18] = "<%=link%>"
		<%if(pair[11]!= null){%>
			data_arr[<%= i%>][19] = "<%=pair[11]%>"
		<%}else{%>
			data_arr[<%= i%>][19] = ""
		<%}%>
		<%if(pair[8]!= null){%>
			data_arr[<%= i%>][20] = "<%=pair[8]%>"
		<%}else{%>
			data_arr[<%= i%>][20] = ""
		<%}%>
		<%if(pair[10]!= null && !pair[10].equals("0")){%>
			data_arr[<%= i%>][21] = "<%=pair[10]%>"
		<%}else{%>
			data_arr[<%= i%>][21] = ""
		<%}%>
		<%if(pair[13]!= null && !pair[13].equals("")){%>
		data_arr[<%= i%>][22] = "<%=pair[13]%>"
	<%}else{%>
		data_arr[<%= i%>][22] = ""
	<%}%>
	<%if(pair[14]!= null && !pair[14].equals("")){%>
	data_arr[<%= i%>][23] = '<input type="hidden1" name="db_flag" id="db_flag_<%= i%>" value="<%=pair[14]%>"; >';
<%}else{%>
	data_arr[<%= i%>][23] = "";
<%}%>
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

 <input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport1();" value="Case Sheet"	class="buttonBig" accesskey="a" /> 
 <input name="Back" type="button" alt="Back" value="Close" class="button"	onclick="window.close();"/>
 <input type="hidden" name="db_flag_value" id="db_flag_value" value="" >

<div class="clear"></div>
<div class="division"></div>
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>"></form>
<% }else{ %>

<form name="opdPatientPrevVisitForViewScreen" method="post" action="">
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
<h4>No Previous Visit For Patient </h4>
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
