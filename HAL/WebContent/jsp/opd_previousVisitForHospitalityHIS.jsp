

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


<%@page import="jkt.hms.masters.business.Discharge"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" src="/hms/jsp/js/common.js"></script>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css">

<%

		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");	
		}				
	List<Object> dischargeList1 = new ArrayList<Object>();	
	if(map.get("dischargeList1") != null){
		dischargeList1=(List)map.get("dischargeList1");
	}		
	
	//out.print("dischargeList1="+dischargeList1.size());
	if(dischargeList1.size() > 0){
		
%>


<div class="titleBg"><h2>Previous Hospitalizations- HIS</h2></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />

<div id="contentHolder">

<div class="Clear"></div>
<form name="opd_previousVisitForHospitality" method="post" action="">
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
<!-- <input type="button" class="button"  value="Clinical Setup" align="left" onClick="submitForm('patientList','/his/his/ipd/ipd?method=showNursingCareJsp','validateRadio');" />-->

<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>


<script type="text/javascript" language="javascript">

formFields = [
		[0, "<%= RequestConstants.HIN_ID%>", "id"],[1, "<%= RequestConstants.RADIO_FOR_TABLE%>"], [2,"<%=RequestConstants.AD_NO%>"],[3,"<%=RequestConstants.HOSPITAL_NAME%>"], [4,"<%= RequestConstants.AD_DATE %>"], [5,"<%= RequestConstants.DISCHARGE_DATE%>"],[6,"<%=RequestConstants.DIAGNOSIS_ID%>"],[7,"<%=RequestConstants.DISPOSAL_ID %>"],[8,"OtherDatabase"],[9,"InpatientId"],[10,"ServiceNo"],[11,"ad_no"]]; 
 statusTd =13;
</script></div>

<script	type="text/javascript" language="javascript">
		
		data_header = new Array();

		data_header[0] = new Array;
		data_header[0][0] = " "
		data_header[0][1] = "radio";
		data_header[0][2] = "5%";
		data_header[0][3] = "<%= RequestConstants.RADIO_FOR_TABLE%>"
		
		
		data_header[1] = new Array;
		data_header[1][0] = "A&D No."
		data_header[1][1] = "data";
		data_header[1][2] = "8%";
		data_header[1][3] = "<%=RequestConstants.AD_NO%>"

		data_header[2] = new Array;
		data_header[2][0] = "Hospital/SMC"
		data_header[2][1] = "data";
		data_header[2][2] = "5%";
		data_header[2][3] = "<%=RequestConstants.HOSPITAL_NAME%>";
				
		data_header[3] = new Array;
		data_header[3][0] = "Date of Admission"
		data_header[3][1] = "data";
		data_header[3][2] = "8%";
		data_header[3][3] = "<%=RequestConstants.AD_DATE%>"
		
		data_header[4] = new Array;
		data_header[4][0] = "Date of Discharge"
		data_header[4][1] = "data";
		data_header[4][2] = "10%";
		data_header[4][3] = "<%=RequestConstants.DISCHARGE_DATE%>";
		
		
		  
		data_header[5] = new Array;
		data_header[5][0] = "Diagnosis"
		data_header[5][1] = "data";
		data_header[5][2] = "6%";
		data_header[5][3] = "<%=RequestConstants.DIAGNOSIS_ID%>";
		
		data_header[6] = new Array;
		data_header[6][0] = "Disposal"
		data_header[6][1] = "data";
		data_header[6][2] = "5%";
		data_header[6][3] = "<%=RequestConstants.DISPOSAL_ID%>";
		
		data_header[7] = new Array;
		data_header[7][0] = "OtherDatabase"
		data_header[7][1] = "hide";
		data_header[7][2] = "5%";
		data_header[7][3] = "OtherDatabase";
		
		data_header[8] = new Array;
		data_header[8][0] = "InpatientId"
		data_header[8][1] = "hide";
		data_header[8][2] = "5%";
		data_header[8][3] = "InpatientId";
		
		data_header[8] = new Array;
		data_header[8][0] = "InpatientId"
		data_header[8][1] = "hide";
		data_header[8][2] = "5%";
		data_header[8][3] = "InpatientId";
		
		data_header[9] = new Array;
		data_header[9][0] = "Service No"
		data_header[9][1] = "hide";
		data_header[9][2] = "5%";
		data_header[9][3] = "ServiceNo";
		
		data_header[10] = new Array;
		data_header[10][0] = "Admission No"
		data_header[10][1] = "hide";
		data_header[10][2] = "5%";
		data_header[10][3] = "ad_no";
		
		
		data_arr = new Array();
		
		<%
		int  i=0;
		int  sino1=i+1;
		String adDate = "";
		String disDate = "";
		try{
			String st1="";
		
			Iterator iterator1=dischargeList1.iterator();
		    
		          while(iterator1.hasNext())
		           {  
		        	  ArrayList dischargeObj = (ArrayList)iterator1.next();
		        	  
		        	  if(dischargeObj.get(3) != null){
		        			String d = dischargeObj.get(3).toString().split(" ")[0];
		        			String [] da = d.split("-");
		        			adDate = da[0]+"-"+da[1]+"-"+da[2];
		        		}
		        	  if(dischargeObj.get(4) != null){
		        			String d = dischargeObj.get(4).toString().split(" ")[0];
		        			String [] da = d.split("-");
		        			disDate = da[0]+"-"+da[1]+"-"+da[2];
		        		}
		%>
		
		data_arr[<%= i%>] = new Array();
		
		data_arr[<%= i%>][0] ="<%=dischargeObj.get(0)%>"
		
			data_arr[<%= i%>][1] = '<input type="radio" class="radiogrid" name="parent" value="<%=dischargeObj.get(0)%>" id="parent" onclick="fillServiceNo(<%= i%>); fillAdmissionNo(<%= i%>);"/>'
		
			<%if(dischargeObj.get(1)!=null)
			{%>
			data_arr[<%= i%>][2] = "<%=dischargeObj.get(1)%>"
<%}else{%>
data_arr[<%= i%>][2] =""

<%}%>

			
			
				<%
					
				   if(dischargeObj.get(2)!= null )
				   {
				%>
				data_arr[<%= i%>][3] = "<%=dischargeObj.get(2)%>"
				<%
				   }else{
				%> 
				data_arr[<%= i%>][3] = ""
				<%
				   }%>
					
			<%
	
				if(dischargeObj.get(3)!=null)
				{
				
			%>
			data_arr[<%= i%>][4] = "<%=dischargeObj.get(3)%>"
			<%
				}else{
			%>
			data_arr[<%= i%>][4] = ""
			<%}%>
			
			
			<%
				
			   if(dischargeObj.get(4)!=null)
			   {
			%>
			data_arr[<%= i%>][5]="<%=dischargeObj.get(4)%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][5]=""
			<%
			   }
			   if(dischargeObj.get(5)!=null)
			   {
			%>
			data_arr[<%= i%>][6] = "temp"
			<%
			   }else{
			%>
			data_arr[<%= i%>][6] = ""
			<%
			   }
			   if(dischargeObj.get(6)!=null)
			   {
			%>
			data_arr[<%= i%>][7] = "<%=dischargeObj.get(6)%>"
			<%
			   }else{
			%>
			data_arr[<%= i%>][7] = ""
			<%
			   }
			   if(dischargeObj.get(7)!=null)
			   {
			%>
			data_arr[<%= i%>][8] = '<input type="hidden" name="db_flag" id="db_flag_<%= i%>" value="<%=dischargeObj.get(7)%>">';
			
			<%
			   }else{
			%>
			data_arr[<%= i%>][8] ='<input type="hidden" name="db_flag" id="db_flag" value="">';
			<%
			   }
			   System.out.println("inpatient id"+(dischargeObj.get(8)));
			   if(dischargeObj.get(8)!=null)
			   {
			%>
			data_arr[<%= i%>][9] = '<input type="hidden" name="inpatient_id" id="inpatient_id_<%= i%>" value="<%=dischargeObj.get(8)%>">';
			
			<%
			   }else{
			%>
			data_arr[<%= i%>][9] ='<input type="hidden" name="inpatient_id" id="inpatient_id" value="">';
			<%
			   }
			   
			   if(dischargeObj.get(10)!=null)
			   {
			%>
			data_arr[<%= i%>][10] = '<input type="hidden" name="service_no" id="service_no_<%= i%>" value="<%=dischargeObj.get(9)%>">';
			
			<%
			   }else{
			%>
			data_arr[<%= i%>][10] ='<input type="hidden" name="service_no" id="service_no" value="">';
			<%
			  }
			   if(dischargeObj.get(1)!=null)
			   {
			%>
			data_arr[<%= i%>][11] = '<input type="hidden" name="ad_no" id="ad_no_<%= i%>" value="<%=dischargeObj.get(1)%>">';
			
			<%
			   }else{
			%>
			data_arr[<%= i%>][11] ='<input type="hidden" name="ad_no" id="ad_no" value="">';
			<%
			   }
			   
			   
			  %>
			  
		<% 	
			i++;
		  }
		          
		}catch(Exception e){
		e.printStackTrace();	
	
		}
		%>
		 
		formName = "opd_previousVisitForHospitality"
		
		
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
<div class="Clear"></div>

<div class="division"></div>

<input type="hidden" name="serviceNo1" id="serviceNo1" value="" />
<input type="hidden" name="adNo1" id="adNo1" value="" />
<!-- <input type="text" name="hospitalIdForReport1" id="hospitalIdForReport1" value="" /> -->

<label>Select Department:</label> 
<select name="casetypecombo" id="casetypecombo" class="bigselect">
	<option value="">-----Select Department-----</option>
	<option value="O">Obe & Gynaecology</option>
	<option value="G">General</option>
	<option value="P">Paediatrics</option>
	<option value="N">NABH</option>
</select>
<div class="clear"></div>
<input type="button" name="printReport" id="print"	onclick="submitFormForDischargeSummaryReport1();" value="Discharge Summary"	class="buttonbig" accesskey="a" />
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>"></form>
</div>
<% }else{ %>
<div id="contentHolder">
<h6>Previous Hospitalizations1 (HIS)</h6>
<div class="Clear"></div>
<form name="opd_previousVisitForHospitality" method="post" action="">
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
<h4><span>No Previous Hospitalization For Patient, If not previously admitted </span></h4>
<input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>"></form>
</div>

<% } %>

<script type="text/javascript">	
	function submitFormForDischargeSummaryReport1(){
		var flag = validateRadioForVisitNo1();
		var orderNo = '';
		if(flag == false){
			return false;
		}else if(checkSelectDept()){
			var printId = document.getElementById('print');
			checkTargetForYes();
			//printId.setAttribute("type","submit");
			submitForm('opd_previousVisitForHospitality','/hms/hms/opd/?method=showHospitalizedDischargeSummaryHISReport');
			checkTargetForNo();
		}
		
	}


	function fillServiceNo(count){
		//alert("ser="+document.getElementById('service_no_'+count).value);
		document.getElementById('serviceNo1').value = document.getElementById('service_no_'+count).value;
	}
	function fillAdmissionNo(count){
		//alert("dis="+document.getElementById('ad_no_'+count).value);
		document.getElementById('adNo1').value = document.getElementById('ad_no_'+count).value;
	}
	/* function fillhospitalIdForReport(count){
		alert("hos="+document.getElementById('hospitalIdForReport'+count).value);
		document.getElementById('hospitalIdForReport1').value = document.getElementById('hospitalIdForReport'+count).value;
	} */
	

	function validateRadioForVisitNo1(){
		for(var i = 0; i < document.getElementsByName('parent').length; i++){
			if(document.getElementsByName('parent')[i].checked == true){
				return true;
			}		
  		}
		
  		alert("Please select one row");
		return false;
	}
	function checkSelectDept(){
		var dept = document.getElementById('casetypecombo').value;
		if(dept == ""){
  			alert("Please select Department");
			return true;
		}
		return true;
	}
	
	
</script>

