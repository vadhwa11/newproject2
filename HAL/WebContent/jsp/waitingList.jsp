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
<%@page import="jkt.hms.masters.business.SilDilStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
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
	List inPatientSet = new ArrayList();
	try {
			if(map.get("takeSetFromSessionInJsp")!=null)
			{
				String takeSetFromSessionInJsp=(String)map.get("takeSetFromSessionInJsp");
				  inPatientSet=(List)map.get("inPatientSet");
			}
			
	} catch (Exception exp) {
		System.out.println("111111111111111111111111");
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
%>


<div id="contentHolder">
<h6 align="left" class="style1">Waiting List</h6>
<div class="Clear"></div>
<jsp:include page="searchResultBlockForIPD.jsp" />
<div class="Clear"></div>
<form name="waitingList" method="post" action="">

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.ADMISSION_NUMBER%>"], [3,"<%= RequestConstants.PATIENT_NAME %>"], [4,"<%= RequestConstants.SERVICE_NUMBER %>"],[5,"<%= RequestConstants.AGE %>"],[6,"<%= RequestConstants.SEX %>"],[7,"<%=RequestConstants.HIN_NO%>"],[8,"<%= RequestConstants.PATIENT_DIAGNOSIS %>"],[9,"<%=RequestConstants.DATE_OF_ADMISSION%>"],[10,"<%=RequestConstants.ADMISSION_STATUS%>"],[11,"<%=RequestConstants.I_CARD_VERIFIED%>"],[12,"<%=RequestConstants.SILORDIL%>"] ];
	 statusTd =12;

</script></div>
<div class="Clear"></div>
<div id="edited"></div>
<div id="statusMessage" class="messagelabel"><br />
</div>
<div class="Clear"></div>

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
		        	  if(inpatient.getAdStatus().equalsIgnoreCase("W") )
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
			data_arr[<%= i%>][0] =<%=inpatient.getId()%>
			data_arr[<%= i%>][1] = '<input type="checkbox" class="radiogrid" name="parent" value="<%= inpatient.getId()%>" id="parent" />'
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
			   if(patientHin.getPFirstName()+patientHin.getPLastName()!= null || patientHin.getPFirstName()+patientHin.getPLastName()!="")
			   {
			%>
			data_arr[<%= i%>][3]="<%=patientHin.getPFirstName()+" "+patientHin.getPMiddleName()+" "+patientHin.getPLastName()%>"
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
			data_arr[<%= i%>][7] = "<%=patientHin.getServiceNo()%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%} if(patientHin.getRank() !=null){%>
			data_arr[<%= i%>][8] = "<%=patientHin.getRank().getRankName()%>"
			<%}else{%>
				data_arr[<%= i%>][8] = ""
			
			<%}%>
			<%
			   if(patientHin.getSFirstName() != null)
			   {
			%>
			data_arr[<%= i%>][9] = "<%=patientHin.getSFirstName()+" "+patientHin.getSMiddleName()+" "+patientHin.getSLastName()%>"
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
				System.out.println("222222222222222");
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
			System.out.println("33333333333333333333333");
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
</script> <input type="hidden" name="counter" id="counter" value="<%=i %>" /> <input
	type="hidden" name="deptId" id="deptId" value="<%=deptId %>" /> <input
	type="hidden" name="deptName" id="deptName" value="<%=deptName %>" />
<input type="button" class="button" value="Submit"
	onClick="submitForm('waitingList','/hms/hms/ipd?method=submitWaitingList','validateRadio');" />
<input type="button" name="Back" class="button" value="Back"
	onclick="submitForm('waitingList','/hms/hms/ipd?method=showPatientListJsp');" />
<script type="text/javascript">
<!--
	// Main vBulletin Javascript Initialization
	vBulletin_init();
//-->
</script> <script type="text/javascript">
		
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

<div class="Clear"></div>
</form>
</div>
