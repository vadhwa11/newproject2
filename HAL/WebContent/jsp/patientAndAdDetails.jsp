<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : patientVisitSearch.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 07.03.2008    Name: Ritu
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.Visit"%>
<%@page import="java.text.SimpleDateFormat"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<div id="contentHolder">
<form name="patientAndAdDetails" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		List<Patient> patientList = new ArrayList<Patient>();
		List<Inpatient> inPatientList = new ArrayList<Inpatient>();
		List<Visit> visitList = new ArrayList<Visit>();
		if(request.getAttribute("map") != null){
			map = (Map<String, Object>)request.getAttribute("map");
		}
		if(map.get("visitList") != null)	{
			visitList = (List<Visit>)map.get("visitList");
		}
		System.out.println("visitList  "+visitList.size());
		if(map.get("inPatientList") != null){
			inPatientList =(List<Inpatient>)map.get("inPatientList");
		}
		if(map.get("patientList") != null){
			patientList= (List<Patient>)map.get("patientList");
		}
		Patient patient=patientList.get(0);
	%> <script type="text/javascript">
	function getAdVisitDetails(){
	if(document.getElementById('detailId').value =="Admission"){
		submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
	}
		submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&opOrString='+document.getElementById('opOrString').value+'&detailId='+document.getElementById('detailId').value+'&id='+document.getElementById('opOrId').value+'&hinId='+document.getElementById('hinId').value)
	}
	function displayAdNo(id,opOrString,extPara){
		document.getElementById('opOrId').value=id
	
		if(opOrString =="0"){
				document.getElementById('opOrString').value ="IP"
				document.getElementById('hinId').value=0
        		obj =document.getElementById("detailId"); 
				obj.length = 1;
	        	obj.length++;
				obj.options[obj.length-1].value="Admission"
				obj.options[obj.length-1].text="Admission";
				obj.length++;
				obj.options[obj.length-1].value="Discharge"
				obj.options[obj.length-1].text="Discharge";
				obj.length++;
				obj.options[obj.length-1].value="Mlc"
				obj.options[obj.length-1].text="Mlc";
				obj.length++;
				obj.options[obj.length-1].value="Sil/Dil"
				obj.options[obj.length-1].text="Sil/Dil";
				obj.length++;
				obj.options[obj.length-1].value="Transfer"
				obj.options[obj.length-1].text="Transfer";
			submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAdVisitDetails&id='+document.getElementById('opOrId').value);
		}else{
			document.getElementById('opOrString').value ="OP"
				document.getElementById('hinId').value=extPara
			obj =document.getElementById("detailId"); 
				obj.length = 1;
	        	obj.length++;
				obj.options[obj.length-1].value="Visit"
				obj.options[obj.length-1].text="Visit";
				obj.length++;
				obj.options[obj.length-1].value="OP-Mlc"
				obj.options[obj.length-1].text="Mlc";
				submitProtoAjax('patientAndAdDetailsGrid','/hms/hms/enquiry?method=getAllEnquiry&opOrString='+document.getElementById('opOrString').value+'&detailId=Visit'+'&id='+document.getElementById('opOrId').value)
		}
	}
	function checkValidation(){
	}
	</script>

<div class="blockTitle">Patient Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%if(patient.getPatientStatus().equalsIgnoreCase("Expired")){ %> <font
	id="error">Patient Expired</font> <%} %> <label>Service No:</label> <label
	class="value"><%=patient.getServiceNo()%></label> <label>Hin
No:</label> <label class="value"><%=patient.getHinNo()%></label> <label>Ser
Name: </label> <label class="valueNoWidth"><%=patient.getSFirstName()+" "+patient.getSMiddleName()+" "+patient.getSLastName() %></label>

<div class="Clear"></div>

<label>Service Type:</label> <label class="value"><%=patient.getServiceType().getServiceTypeName()%></label>


<label>Pt Name:</label> <label class="value"><%=patient.getPFirstName()+" "+patient.getPMiddleName()+" "+patient.getPLastName() %></label>

<label>Relation :</label> <label class="value"><%=patient.getRelation().getRelationName()%></label>

<div class="Clear"></div>

<label>Rank :</label> <label class="value"><%=patient.getRank().getRankName()%></label>

<label>Trade :</label> <%if(patient.getTrade() !=null){ %> <label
	class="value"><%=patient.getTrade().getTradeName()%></label> <%}else{ %>
<label class="value">-</label> <%} %> <label>Total Service :</label> <label
	class="value"><%=patient.getServiceYears()+ " "+patient.getTotalServicePeriod() %></label>

<div class="Clear"></div>
<label>Unit :</label> <label class="value"><%=patient.getUnit().getUnitName()+","+patient.getUnit().getUnitAddress()%></label>
<label> RcrdOff Add :</label> <%if(patient.getRecordOfficeAddress() !=null){ %>
<label class="value"><%=patient.getRecordOfficeAddress().getAddress()%></label>
<%}else{ %> <label class="value">-</label> <%} %> <label> CDA
AcntNo :</label> <%if(patient.getCdaAccountNo() !=null && ! patient.getCdaAccountNo().equals("")){ %>
<label class="value"><%=patient.getCdaAccountNo()%></label> <%}else{ %> <label
	class="value">-</label> <%} %>
<div class="Clear"></div>
<%	String address="-";
				String state="-";
				String ptDist="-";
				String dist="-";
				String country="-";
				String mobileNo="-";
				String phNo="-";
				if(patient.getAddress() !=null){
					if(!patient.getAddress().equals(""))
						address =patient.getAddress();
				}
				if(patient.getState() !=null){
					if(!patient.getState().equals(""))
						state =patient.getState().getStateName();
				}
				if(patient.getPatientDistrict() !=null){
					if(!patient.getPatientDistrict().equals(""))
						ptDist =patient.getPatientDistrict();
				}
				if(patient.getDistrict() !=null){
					if(!patient.getDistrict().getDistrictName().equals(""))
						dist =patient.getDistrict().getDistrictName();
				}
				
				if(patient.getCountry() !=null){
					if(!patient.getCountry().equals(""))
						country =patient.getCountry().getCountryName();
				}
				if(patient.getMobileNumber() !=null){
					if(!patient.getMobileNumber().equals(""))
						mobileNo =patient.getMobileNumber();
				}
				if(patient.getPhoneNumber() !=null){
					if(!patient.getPhoneNumber().equals(""))
						phNo =patient.getPhoneNumber();
				}
				
			 %> <label>Address :</label> <label class="value"><%=address %></label>
<label>State :</label> <label class="value"><%=state%></label> <label>City/District
:</label> <label class="value"><%=dist%></label>
<div class="Clear"></div>
<label>Patient Dist :</label> <label class="value"><%=ptDist%></label>

<label>Country :</label> <label class="value"><%=country%></label> <label>Mobile
No :</label> <label class="value"><%=mobileNo%></label>
<div class="Clear"></div>
<label>Ph No :</label> <label class="value"><%=phNo %></label> <label>Formation
:</label> <%if(patient.getFormation() !=null && ! patient.getFormation().equals("")) {%>
<label class="value"><%=patient.getFormation()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %> <label>Religion :</label> <%if(patient.getReligion() !=null){ %>
<label class="value"><%=patient.getReligion().getReligionName()%></label>
<%}else{ %> <label class="value"> - </label> <%} %>

<div class="Clear"></div>
<label>Age : </label> <%if(patient.getAge() !=null){ %> <label
	class="value"><%=patient.getAge()%></label> <%}else{ %> <label
	class="value"> - </label> <%} %> <label>NOK Name :</label> <label
	class="value"><%=patient.getNextOfKinName() %></label> <label>NOK
Relation :</label> <%if(patient.getNextOfKinRelation() !=null){ %> <label
	class="value"><%=patient.getNextOfKinRelation().getRelationName()%></label>
<%}else{ %> <label class="value"> - </span> <%} %>
<div class="Clear"></div>
<label>NOK Address :</label> <label class="valueNoWidth"><%=patient.getNextOfKinAddress()%></label>

<label>NOK Ph No :</label> <label class="value"><%=patient.getNextOfKinPhoneNumber()%></label>
<div class="Clear"></div></div>
<input name="opOrString" id="opOrString" type="hidden" />
<input name="opOrId" id="opOrId" type="hidden" />
<input name="hinId"	id="hinId" type="hidden" value="0" />
</form>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<form name="patientAndAdDetailsGrid" method="post" action="">
<script	type="text/javascript">
	formFields = [
			[0, "<%= HIN_ID%>", "id"],[1,"<%= RADIO_FOR_TABLE%>"] [2,"Status"], [3,"AdVisit"], [4,"Date"], [5,"Time"], [6,"Doctor"], [7,"DisDate"], [8,"presentWard"]];
	 statusTd = 7;
	</script>
</div>
<div class="Clear"></div>
</form>
<div class="Clear"></div>
</div>
<script type="text/javascript" language="javascript">
	
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = " "
	data_header[0][1] = "hide";
	data_header[0][2] = "4%";
	data_header[0][3] = "<%=RADIO_FOR_TABLE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Status"
	data_header[1][1] = "data";
	data_header[1][2] = "7%";
	data_header[1][3] = "servNo"
	
	data_header[2] = new Array;
	data_header[2][0] = "Ad/Visit No"
	data_header[2][1] = "data";
	data_header[2][2] = "15%";
	data_header[2][3] = "hin";
	
	data_header[3] = new Array;
	data_header[3][0] = "Date"
	data_header[3][1] = "data";
	data_header[3][2] = "20%";
	data_header[3][3] = "patName";
	
	data_header[4] = new Array;
	data_header[4][0] = "Time"
	data_header[4][1] = "data";
	data_header[4][2] = "10%";
	data_header[4][3] = "serviceType"
	
	data_header[5] = new Array;
	data_header[5][0] = "Doctor"
	data_header[5][1] = "data";
	data_header[5][2] = "15%";
	data_header[5][3] = "sPersonName";
	
	data_header[6] = new Array;
	data_header[6][0] = "Dis Date"
	data_header[6][1] = "data";
	data_header[6][2] = "10%";
	data_header[6][3] = "rank";

	data_header[7] = new Array;
	data_header[7][0] = "Ward"
	data_header[7][1] = "data";
	data_header[7][2] = "10%";
	data_header[7][3] = "presentWard"
	
	data_arr = new Array();
	<%	String opOrString ="0";	
	    int  counter=0;
		if (patientList != null && patientList.size() > 0) { %>
	<% 	for(Inpatient inpatient : inPatientList){
	%>
	  		data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= inpatient.getId()%>
			data_arr[<%= counter%>][1] = '<input type="radio" id="parent" name="parent" value="<%= inpatient.getId()%>" id="parent" onclick="displayAdNo(<%=inpatient.getId()%>,<%=opOrString%>,<%=opOrString%>)" />'
			data_arr[<%= counter%>][2] = "IP"
			data_arr[<%= counter%>][3] = "<%=inpatient.getAdNo()%>"
			<%String admDate ="";
			SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
			 admDate=formatterOut.format(formatterIn.parse(""+inpatient.getDateOfAddmission()));
			 %>
			data_arr[<%= counter%>][4] = "<%=admDate%>"
			data_arr[<%= counter%>][5] = "<%=inpatient.getTimeOfAddmission()%> "
			data_arr[<%= counter%>][6] = "<%=inpatient.getDoctor().getFirstName()+ " "+inpatient.getDoctor().getMiddleName()+ " "+inpatient.getDoctor().getLastName()%> "
			<%if(inpatient.getDischargeDate() !=null){%>
			<%String disDate ="";
			SimpleDateFormat formatterIn2 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut2 = new  SimpleDateFormat("dd/MM/yyyy");
			 disDate=formatterOut2.format(formatterIn2.parse(""+inpatient.getDischargeDate()));
			 %>
			data_arr[<%= counter%>][7] = "<%=disDate%> "
			<%}else{%>
			data_arr[<%= counter%>][7] = "-"
			<%}%>

			<%if(inpatient.getDepartment() !=null){%>
				data_arr[<%= counter%>][8] = "<%=inpatient.getDepartment().getDepartmentName()%> "
			<%}else{%>
				data_arr[<%= counter%>][8]="-"
			<%}%>
			
				<%counter++;}}%>
		
		<%
		try{
			opOrString="1";
	    int  counter2=counter;
		if (visitList != null && visitList.size() > 0) { %>
	<% 	for(Visit visit : visitList){
	%>
	  		data_arr[<%= counter2%>] = new Array();
			data_arr[<%= counter2%>][0] = <%= visit.getId()%>
			data_arr[<%= counter2%>][1] = '<input type="radio" id="parent" name="parent" value="<%= visit.getHin().getId()%>" id="parent"  onclick="displayAdNo(<%=visit.getId()%>,<%=opOrString%>,<%=visit.getHin().getId()%>)" />'
			data_arr[<%= counter2%>][2] = "OP"
			data_arr[<%= counter2%>][3] = "<%=visit.getVisitNo()%>"
			<%String visitDate ="";
			SimpleDateFormat formatterIn3 = new SimpleDateFormat("yyyy-MM-dd");
			 SimpleDateFormat formatterOut3 = new  SimpleDateFormat("dd/MM/yyyy");
			 visitDate=formatterOut3.format(formatterIn3.parse(""+visit.getVisitDate()));
			 %>
			data_arr[<%= counter2%>][4] = "<%=visitDate%>  "
			data_arr[<%= counter2%>][5] = "<%=visit.getVisitTime()%> "
			<%if(visit.getDoctor()!=null){%>
			data_arr[<%= counter2%>][6] = "<%=visit.getDoctor().getFirstName()+ " "+visit.getDoctor().getMiddleName()+ " "+visit.getDoctor().getLastName()%> "
			<%}else{%>
			data_arr[<%= counter2%>][6] = "-"
			<%}%>
			<%if(visit.getAddEditDate() !=null){%>
			data_arr[<%= counter2%>][7] = "-"
			<%}else{%>
			data_arr[<%= counter2%>][7] = "-"
			<%}%>
			<%if(visit.getAddEditTime() !=null){%>
			data_arr[<%= counter2%>][8] = "-"
			<%}else{%>
				data_arr[<%= counter2%>][8]="-"
			<%}%>
				<%counter2++;}}
		}catch(Exception ee ){
			ee.printStackTrace();
		}
				%>
    formName = "patientAndAdDetailsGrid"
	
	start = 0
	if(data_arr.length < rowsPerPage){
		end = data_arr.length;
	}
	else{
		end = rowsPerPage;
	
	}
	
	makeTable(start,end);
		
	</script>
	<script>
function clearTestDivDown(flag,id,resultType,resultStatus,confidential){
			document.getElementById('testDivDown').innerHTML = "";
			if(flag == 'rhLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=35,top=160,height=320,width=950,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rdRadio'){
				//window.showModalDialog('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','dialogHeight=120,dialogWidth=120','dialogLeft=100,dialogTop=160,dialogHeight=120,dialogWidth=120,,status=2,scrollbars=1,resizable=0,center=1');
				window.open('lab?method=printResultForRadiology&dgResultEntryDetailId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');
			}
			if(flag == 'rhSenLab'){
				window.open('lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=25,top=160,height=400,width=970,status=1,scrollbars=1,resizable=1');			
				//submitProtoAjaxWithDivName('orderNoListForOrderStatus','lab?method=selectViewAccOrderStatus&dgResultEntryHeaderSenLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'','testDivDown');
			}
			if(flag == 'rEntryDetailLab'){
				if(resultType == 's'){
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=30,top=160,height=280,width=950,status=1,scrollbars=1,resizable=1');				
				}else{
					window.open('lab?method=selectViewAccOrderStatus&dgResultEntryDetailLabId='+id+'&resultType='+resultType+'&orderStatus='+resultStatus+'&confidential='+confidential+'','name','left=100,top=160,height=420,width=820,status=1,scrollbars=1,resizable=1');				
				}
			}
		}

	function submitResultPrintAfterValidation(){
		var flag = validateRadioForOrderNo();
		var orderNo = '';
		if(flag == false){
			return false;
		}else{
			var printId = document.getElementById('print');
			printId.setAttribute("type","submit");
			submitForm('patientAndAdDetails','/hms/hms/lab?method=printOrderStatusReport');
		}
		
	}
	function fillOrderNo(printValueObj){
		document.getElementById('orderNoIdForReport').value = printValueObj.value; 
	}
	</script>
