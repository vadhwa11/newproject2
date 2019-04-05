
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
<%@page import="jkt.hms.masters.business.Visit"%>
<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>


<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
 <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> 
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<script type="text/javascript">
	   var icdArray=new Array();

	</script>
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
		
	List patientPreviousVisitList = new ArrayList();
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
	
	if(patientPreviousVisitList.size() > 0){
	Visit visitObj=(Visit)patientPreviousVisitList.get(0);
	Patient patientObj=visitObj.getHin();
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
	 String visitDateInString =HMSUtil.changeDateToddMMyyyy(visitObj.getVisitDate());
	int deptId=visitObj.getDepartment().getId();
	MasAdministrativeSex masAdministrativeSexObj=patientObj.getSex();
%>


<div class="titleBg"><h2>Previous Prescription View</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />


<form name="opdPatientPrevVisitForReport" method="post" action="">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','ipd?method=showNursingCareJsp','validateRadio');" />-->




<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">
	
	formFields = [
			[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%= RequestConstants.TOKEN_NO%>"], [3,"<%= RequestConstants.VISIT_NUMBER %>"], [4,"<%= RequestConstants.VISIT_DATE %>"],[5,"<%= RequestConstants.VISIT_TIME %>"],[6,"<%= RequestConstants.SERVICE_NO %>"],[7,"<%=RequestConstants.APPOINTMENT_TYPE%>"],[8,"<%= RequestConstants.PATIENT_NAME %>"],[9,"<%=RequestConstants.AGE%>"],[10,"<%=RequestConstants.SEX%>"],[11,"<%=RequestConstants.DIAGNOSIS_ID%>"],[12,"visitNoForJsp"],[13,"<%=RequestConstants.EMPLOYEE_ID %>"],[14,"<%=RequestConstants.DISPOSAL_ID %>"] ];
	 //statusTd =13;
</script></div>
<div id="edited"></div>
<div id="statusMessage" ></div>
<input type="hidden" name="serviceNoForReport" id="serviceNoForReport"	value="<%=visitObj.getHin().getServiceNo()%>" />
<input type="hidden" name="visitNumberForReport"	id="visitNumberForReport" value="<%=visitObj.getVisitNo()%>" />
<input type="hidden" name="hinNoForReport" id="hinNoForReport" value="<%=visitObj.getHin().getHinNo()%>" />

<input type="hidden" name="visitId" id="visitId"	value="" />
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
		data_header[9][0] = "Sex"
		data_header[9][1] = "hide";
		data_header[9][2] = "1%";
		data_header[9][3] = "<%=RequestConstants.SEX%>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Diagnosis"
		data_header[10][1] = "hide";
		data_header[10][2] = "10%";
		data_header[10][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[11] = new Array;
		data_header[11][0] = "visit No For Jsp"
		data_header[11][1] = "hide";
		data_header[11][2] = "10%";
		data_header[11][3] = "visitNoForJsp";

		data_header[12] = new Array;
		data_header[12][0] = "Medical Officer"
		data_header[12][1] = "data";
		data_header[12][2] = "10%";
		data_header[12][3] = "<%=RequestConstants.EMPLOYEE_ID %>";

		data_header[13] = new Array;
		data_header[13][0] = "Diagnosis"
		data_header[13][1] = "data";
		data_header[13][2] = "10%";
		data_header[13][3] = "<%=RequestConstants.DIAGNOSIS_ID %>";
		
		data_header[14] = new Array;
		data_header[14][0] = "Disposal"
		data_header[14][1] = "data";
		data_header[14][2] = "10%";
		data_header[14][3] = "<%=RequestConstants.DISPOSAL_ID %>";
		data_arr = new Array();
		
		<%
		int  i=0;
		try{
			String st="";
		
		    
			Iterator iterator=patientPreviousVisitList.iterator();
		          while(iterator.hasNext())
		           {
		        	  Visit visit= (Visit) iterator.next();
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
					String doctorName="";
					  if(visit.getDoctor().getFirstName()!= null){
						  doctorName=visit.getDoctor().getFirstName();
		   	        	  }
						if(visit.getDoctor().getMiddleName()!= null){
							doctorName=doctorName+" "+visit.getDoctor().getMiddleName();
						}
						if(visit.getDoctor().getLastName()!= null)
						{
							doctorName=doctorName+" "+visit.getDoctor().getLastName();
						}
						String disposal="";
						if(visit.getDisposal()!=null){
							disposal=visit.getDisposal().getDisposalName();
						}
						String dignosis="";
						if(visit.getDiagnosisName()!=null){
							dignosis=visit.getDiagnosisName();
						}
		        	  MasAdministrativeSex masAdministrativeSex=patientHin.getSex();
		        	  String visitDate =HMSUtil.changeDateToddMMyyyy(visit.getVisitDate());
		        	  
		        	  
		        	  
		        	  
		%>
		
			data_arr[<%= i%>] = new Array();
			
			data_arr[<%= i%>][0] ="<%=visit.getId()%>"
			
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=visit.getHin().getServiceNo()%>@<%=visit.getHin().getHinNo()%>@<%=visit.getVisitNo()%>@<%=visit.getId()%>" id="parent" onclick="fillVisitNo(this)"/>'
			
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
		
			if(visit.getDiagnosisString()!= null){
			
		%>
			data_arr[<%= i%>][11] = "<%=visit.getDiagnosisString()%>"
		<%
		  	}else{
		%>
			data_arr[<%= i%>][11] = ""
		<%}%>
		 data_arr[<%= i%>][12] = "<%=visitNoForJsp%>"
		 data_arr[<%= i%>][13] = "<%=doctorName%>"
		 data_arr[<%= i%>][14] = "<%=dignosis%>"
		data_arr[<%= i%>][15] = "<%=disposal%>"	 
		<% 	
			i++;
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
<div class="Clear"></div>
<div class="floatRight">
<label class="auto"><span>Total Patient Visit </span></label>
<label class="valueAuto"><%= i%></label>
<input type="hidden"	name="counter" id="counter" value="<%=i %>" />
<input type="hidden" name="visitNoForJsp" id="visitNoForJsp" value="<%=visitNoForJsp%>" />
</div>
<div class="clear"></div>
<div class="division"></div>
<!-- 
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="submitForm('opdPatientPrevVisitForReport','fwc?method=showFWCMainJsp&visitId=<%=visitId%>&deptId=<%=deptId%>');"/>
 -->
<input type="button" name="close" id="close"	onclick="window.close();" value="Close"	class="button" accesskey="a" />

<input type="button" name="printReport" id="print" 	onclick="submitFormForPrescriptionReport();" value="print Prescription"	class="buttonBig" accesskey="a" />

<input type="button" name="printReport" id="print" 	onclick="openPrescriptionDetails();" value="Prescription Details"	class="buttonBig" accesskey="a" />
<!--  
<div class="arrowlistmenu">
<ul  class="categoryitems">
	<li> <a href="javascript:openPopupPrescriptionDetails(473,11,3)">
	Previous Prescriptions</a></li>
</ul>
</div>
-->
<div class="clear"></div>
<div class="division"></div>
</form>
<% }else{ %>

<form name="opdPatientPrevVisitForReport" method="post" action="">
<h4>No Previous Visit For Patient </h4>
<div class="Clear"></div>
<input name="Back" type="button"	alt="Back" value="Back" class="button"	onclick="history.go(-1);return false;" /></form>

<% } %>
<div id="testP"></div>
<script type="text/javascript">	
function openPrescriptionDetails(){
	var flag = validateRadioForVisitNo();
	var orderNo = '';
	if(flag == false){
		return false;
	}else{
		var printId = document.getElementById('print');
		
		//submitForm('opdPatientPrevVisitForReport','/hms/hms/fwc?method=showPatientPreviousPrescriptionRepeat');
		submitProtoAjaxWithDivName('opdPatientPrevVisitForReport','/hms/hms/fwc?method=showPatientPreviousPrescriptionRepeat','testP');
			
		checkTargetForNo();
	}
	
}
/*
function openPopupPrescriptionDetails(visitId,hinId,visitNo)
{
 var url="/hms/hms/fwc?method=showPatientPreviousPrescription&visitId="+visitId+"&hinId="+hinId+"&visitNo="+visitNo;
 newwindow=window.open(url,'name',"left=2,top=100,height=300,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
*/
	function submitFormForPrescriptionReport(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			submitForm('opdPatientPrevVisitForReport','/hms/hms/fwc?method=showPatientPrescriptionReport');
			//submitForm('opdPatientPrevVisitForReport','/hms/hms/fwc?method=opdPatientInvestigationFormatPrint');
			checkTargetForNo();
		}
		
	}
	function openPriscriptionDetails(){
		var flag = validateRadioForVisitNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			//submitForm('opdPatientPrevVisitForReport','/hms/hms/fwc?method=showPatientPrescriptionReport');
			submitForm('opdPatientPrevVisitForReport','/hms/hms/fwc?method=opdPatientInvestigationFormatPrint');
			checkTargetForNo();
		}
		
	}
	function fillVisitNo(printValueObj){
		var allValues = printValueObj.value;
		var allValuesArray = allValues.split("@");
		document.getElementById('serviceNoForReport').value = allValuesArray[0];
		document.getElementById('visitNumberForReport').value = allValuesArray[2]; 
		document.getElementById('hinNoForReport').value = allValuesArray[1];
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
	
</script>

<script type="text/javascript">

	function setValuesInParentForPrescription(formname){
  		formName=formname.name;

		var grid = window.opener.document.getElementById("grid").rows.length;
		var investigationGrid = window.opener.document.getElementById("investigationGrid").rows.length;
		//if(investigationGrid>2){
		//	var rows=investigationGrid-2
		//  	alert("Please fill prescription before investigation for that Delete "+ rows+"  rows From Investigation .")
		//  	return;
		//}
		//if(grid>2){
		// 	var rows=grid-2
		//  	alert("Please Delete "+ rows+"  rows From Drugs .")
		//  	return;
		//}
		
		
		//alert("value of counter--"+document.patientPrescription.counter.value)
 		var hdbVal = window.opener.document.getElementById('hdb').value;
 		var nomenclatureVal = window.opener.document.getElementById('nomenclature1').value;

		if(hdbVal == 1 && nomenclatureVal == ''){
			var len = window.opener.document.getElementById("grid").rows.length;
			var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
		}
		
		for(var index = 1; index < parseInt(document.patientPrescription.counter.value); index++ ){
			var toEval = "document.patientPrescription.repeatPrescription" + index;
			var repeatIn = eval(toEval);
			if(repeatIn.checked == true){
			
				  var len = window.opener.document.getElementById("grid").rows.length;
				  //var r1 = window.opener.document.getElementById("grid").deleteRow(len-1);
				  //alert(r1);
				  var r = window.opener.document.getElementById("grid").insertRow(len);
				  
				  var c1 = r.insertCell(0);
				  var c_img = r.insertCell(1);
				  var c2 = r.insertCell(2);
				  var c3 = r.insertCell(3);
				  var c4 = r.insertCell(4);
				  var c5 = r.insertCell(5);
				  //var c6 = r.insertCell(6);
				  var c7 = r.insertCell(6);
				  var c8 = r.insertCell(7);	
				  var c9 = r.insertCell(8);
				  var c10 = r.insertCell(9);	
				 // var c11 = r.insertCell(10);			
				  	
				  var nomenclature=eval('document.'+formName+'.nomenclature' + index + '.value')
				  var pvmsNo=eval('document.'+formName+'.pvmsNo' + index + '.value')
				  
				  var divElement = document.createElement('div');
				  divElement.setAttribute('id','ac2update1');
				  divElement.style.display = 'none';
				  //divElement.style.fontWeight = 'normal;';
				  //divElement.style.border = '0px solid white;';
				  divElement.style.paddingRight = '10px;';
				 // divElement.style.backgroundColor = 'white;';

				  c1.appendChild(divElement);
				  
				  
				  var x1 = document.createElement('input');
				  x1.type = 'text';
				  x1.name='nomenclature'+len;
				  x1.id='nomenclature'+len;
				  x1.size = '50';
	  			  x1.setAttribute('tabindex','1');	 				  
				  x1.value = nomenclature+"["+pvmsNo+"]";;
				  
				  //x1.setAttribute("readonly","readonly");
				  c1.appendChild(x1);
	  			  //new Ajax.Autocompleter('nomenclature'+len,'ac2update1','fwc?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature'+len});
                  
				  //var cellRight1 = row.insertCell(1);
				    var eImg = document.createElement('img');
				  eImg.src = '/hms/jsp/images/search.gif';
				  eImg.name = 'search' + len;
				  eImg.id = 'search' + len;
				  eImg.WIDTH = '26';
				  eImg.HEIGHT = '26';
				  //eImg.id = 'billDateId'+iteration;
				  eImg.onclick = function(){
				  var url="/hms/hms/fwc?method=showItemSearchJsp&count="+len;
				  newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
				  c_img.appendChild(eImg);
                  
                  
                  
				  /*
				  var eImg = document.createElement('img');
				  eImg.src = '/hms/jsp/images/search.gif';
				  eImg.name = 'search' + len;
				  eImg.id = 'search' + len;
				  eImg.WIDTH = '26';
				  eImg.HEIGHT = '26';
				  //eImg.id = 'billDateId'+iteration;
				  eImg.onclick = function(){
				  var url="/hms/hms/fwc?method=showItemSearchJsp&count="+len;
				  //newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0"); };
				  newwindow=window.open(url,'name',"left=2,top=100,height=700,width=1010,status=1,scrollbars=1,resizable=0"); };
				  c_img.appendChild(eImg);
				  */
				  var x2 = document.createElement('input');
				  x2.type = 'text';
				  x2.name='pvmsNo'+len;
				  x2.id='pvmsNo'+len;
				  x2.size = '10';
	  			  x2.setAttribute('tabindex','1');				  
				  x2.value = eval('document.'+formName+'.pvmsNo' + index + '.value');
				  x2.setAttribute("readonly","readonly");
				  c2.appendChild(x2);

				  var x3 = document.createElement('input');
				  x3.type = 'text';
				  x3.name='dosage'+len;
				  x3.id='dosage'+len;
				  x3.size = '5';
	  			  x3.setAttribute('tabindex','1');				  
				  x3.value = eval('document.'+formName+'.dosage' + index + '.value');
				  //x3.setAttribute("readonly","readonly");
				  c3.appendChild(x3);

				  var x4 = document.createElement('Select');
				  //x4.type = 'hidden';
				  x4.name='frequency'+len;
				  x4.id='frequency'+len;
				  x4.classname='smalllabel';
				  
				  x4.options[0] = new Option('Select', '0');
				  selectedFrequency = eval('document.'+formName+'.frequencyId' + index + '.value');
	   		      for(var i = 0;i<icdArray.length;i++ ){
	   		      	if(selectedFrequency == icdArray[i][0]){
	   		      		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      		x4.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x4.options[i+1] = new Option(icdArray[i][1],icdArray[i][0]);
	   		      	}
	      		  }
	      		  
	      		  
	  			  x4.setAttribute('tabindex','1');	
				  //x4.onclick=function(){
	  			  	//var val=x5.value;
	  			  	//var freq=x4.value;
	  						//alert("frequency-----");
	  			  // document.getElementById('total'+iteration).value=val*freq;
	  			  //}
	  			  			  
				  c4.appendChild(x4);

				  var x5 = document.createElement('input');
				  x5.type = 'text';
				  x5.name='noOfDays'+len;
				  x5.id='noOfDays'+len;
				  x5.size = '3';
	  			  x5.setAttribute('tabindex','1');				  
				  x5.value = eval('document.'+formName+'.noOfDays' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c5.appendChild(x5);

				  var e6 = document.createElement('input');
					e6.type = 'text';
					e6.name='route'+len;
					e6.id='route'+len
					e6.size='10';
					//e6.value='route';
					e6.setAttribute('maxlength', 20); 
					e6.setAttribute('tabindex','1');
					c7.appendChild(e6);
				  /* 

				  var x7 = document.createElement('Select');
				  x7.name='instructionACPC'+len;
				  x7.id='instructionACPC'+len;
				  x7.options[0] = new Option('Select', '');
				  selectedInstructionACPC = eval('document.'+formName+'.instructionACPC' + index + '.value'); 
	   		      for(var i = 0;i<instructionACPCArray.length;i++ ){
	   		      	if(selectedInstructionACPC == instructionACPCArray[i][0]){
	   		      		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      		x7.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x7.options[i+1] = new Option(instructionACPCArray[i][1],instructionACPCArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x7.setAttribute('tabindex','1');				  
				  c7.appendChild(x7);

				  var x8 = document.createElement('Select');
				  x8.name='typeLeftRight'+len;
				  x8.id='typeLeftRight'+len;
				  
				  x8.options[0] = new Option('Select', '');
				  selectedtypeLeftRight = eval('document.'+formName+'.typeLeftRight' + index + '.value'); 
	   		      for(var i = 0;i<typeLeftRightArray.length;i++ ){
	   		      	if(selectedtypeLeftRight == typeLeftRightArray[i][0]){
	   		      		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      		x8.options[i+1].setAttribute('Selected','Selected');
	   		      	}else{
	      		  		x8.options[i+1] = new Option(typeLeftRightArray[i][1],typeLeftRightArray[i][0]);
	   		      	}
	      		  }
				  
	  			  x8.setAttribute('tabindex','1');				  
				  c8.appendChild(x8);
				  */
				  //var cellRight6 = row.insertCell(6);
					
					
				  var x8 = document.createElement('input');
				  x8.type = 'text';
				  x8.name='remarks'+len;
				  x8.id='remarks'+len;
				  x8.size = '10';
	  			  x8.setAttribute('tabindex','1');				  
				  x8.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c8.appendChild(x8);
				  
				  var x9 = window.opener.document.getElementById('hdb');
				  x9.value=len;
				 
				  var x10 = document.createElement('input');
				  x10.type = 'button';
				  //x11.name='remarks'+len;
				 // x11.id='remarks'+len;
				  x10.className = 'buttonAdd';
	  			  x10.setAttribute('tabindex','1');	
	  			  x10.setAttribute('onClick', 'addRow();'); 			  
				  //x11.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c9.appendChild(x10);

				  var x11 = document.createElement('input');
				  x11.type = 'button';
				  //x11.name='remarks'+len;
				 // x11.id='remarks'+len;
				  x11.className = 'buttonDel';
	  			  x11.setAttribute('tabindex','1');	
	  			  x11.setAttribute('onClick', 'removeRow();'); 			  
				  //x11.value = eval('document.'+formName+'.remarks' + index + '.value');
				  //x5.setAttribute("readonly","readonly");
				  c10.appendChild(x11);
				  
				 
				  //alert("value of hdb----"+x8.value)
			}
		}
		
	window.close();		
  	}
		
	
		
	
		
</script>