<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * employee.jsp  
 * Purpose of the JSP -  This is for Employee Details.
 * @author  Dipali  
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.10
--%>
<%@page import="jkt.hms.masters.business.UploadDocuments"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasCostCenter"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<%@page import="jkt.hms.masters.business.MasDivision"%>
<%@page import="jkt.hms.masters.business.MasCountry"%>
<%@page import="jkt.hms.masters.business.MasState"%>
<%@page import="jkt.hms.masters.business.MasDistrict"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployeeType"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<%@page import="jkt.hms.masters.business.UsergroupHospital"%>

<%@page import="jkt.hms.masters.business.EmpGroups"%>
<%@page import="jkt.hms.masters.business.Users"%>
<%@page import="jkt.hms.masters.business.MasTemplate"%>

<%@page import="jkt.hms.masters.business.MasAdministrativeSex"%><script
	type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>

<script type="text/javascript">
function checkforrecord(){

if(trimAll(document.getElementById('firstName').value) == ""){
 alert("Please select one record");
 return false;
}
if(trimAll(document.getElementById('status').value) == "InActive"){
 alert("First create it as Active record");
  return false;
 }
return true;
}
function setloginName(val){
	document.getElementById('loginName').value=val;
	document.getElementById('password').value=val;
}
function validateEmployee(){

    
	var val=document.getElementById('empStatusId').value;
	var sts = document.getElementById('empStatusId').selectedIndex;
	var valName = document.getElementById('empStatusId').options[sts].text;
		
	if(val!=0)
		{
		if(valName=="Contract")
		{
			if(document.getElementById('contract').value==''){
				alert("Please Date of contract");
				return false;
			}
		}
		if(valName=="Extension")
		{
			if(document.getElementById('extension').value==''){
				alert("Please Extension");
				return false;
			}
		}
	}

	
		var fname = document.getElementById('fileNameId').value;
		var ind1 = fname.lastIndexOf("\\");
		var filename = fname.substring(ind1+1);
		document.getElementById("fileName").value=filename;
		document.getElementById("flag").value="y";
		document.employee.method="post";
	     return true;
 

}

function validateEmployeeLogin(){
	
	  
	
	var val=document.getElementById('empStatusId').value;
	var sts = document.getElementById('empStatusId').selectedIndex;
	var valName = document.getElementById('empStatusId').options[sts].text;
		
	if(val!=0)
		{
		if(valName=="Contract")
		{
			if(document.getElementById('contract').value==''){
				alert("Please Date of contract");
				return false;
			}
		}
		if(valName=="Extension")
		{
			if(document.getElementById('extension').value==''){
				alert("Please Extension");
				return false;
			}
		}
	}
	
		var fname = document.getElementById('fileNameId').value;
		var ind1 = fname.lastIndexOf("\\");
		var filename = fname.substring(ind1+1);
		document.getElementById("fileName").value=filename;
		document.getElementById("flag").value="y";
		document.employee.method="post";
		  return true;
	    
	  
	    

	}
function getLoginRequired(){
	var templetCnt=0;
	templetCnt=document.getElementById('templetCnt').value;
	if(document.getElementById('loginRequired').checked == true) {
		document.getElementById('loginName').disabled=false;
		document.getElementById('password').disabled=false;
		//document.getElementById('appGroupId').disabled=false;
		//document.getElementById('empGroupId').disabled=true;
		document.getElementById('userDepartmentId').disabled=false;
		if(parseInt(templetCnt) > 0){
			for(var i=1;i<=templetCnt;i++){
				document.getElementById('templetId'+i).disabled=false;
			}
		}
	}else {
		document.getElementById('loginName').disabled=true;
		document.getElementById('password').disabled=true;
		//document.getElementById('appGroupId').disabled=true;
		//document.getElementById('empGroupId').disabled=true;
		document.getElementById('userDepartmentId').disabled=true;
		//document.getElementById('appGroupId').value="0";
		document.getElementById('userDepartmentId').value="0";
		if(parseInt(templetCnt) > 0){
			for(var i=1;i<=templetCnt;i++){
				document.getElementById('templetId'+i).disabled=true;
			}
		}
	} 
}

function validation(){
	var val=document.getElementById('empStatusId').value;
	var sts = document.getElementById('empStatusId').selectedIndex;
	var valName = document.getElementById('empStatusId').options[sts].text;
		
	if(val!=0)
		{
		if(valName=="Contract")
		{
			if(document.getElementById('contract').value==''){
				alert("Please Date of Contract");
				return false;
			}
		}
		if(valName=="Extension")
		{
			if(document.getElementById('extension').value==''){
				alert("Please Date of Extension");
				return false;
			}
		}
	}
	return true;
}

function checkStatusVal()
{
	var val=document.getElementById('empStatusId').value;
	var sts = document.getElementById('empStatusId').selectedIndex;
	var valName = document.getElementById('empStatusId').options[sts].text;
	if(val!=0)
	{
			if(valName=="Contract")
			{
				
	  			document.getElementById('contractDiv').style.display = 'inline';
		 	}
			else{
				document.getElementById('contractDiv').style.display = 'none';
			}
			if(valName=="Extension")
			{
	  			document.getElementById('extensionDiv').style.display = 'inline';
		 	}
			else{
				document.getElementById('extensionDiv').style.display = 'none';
			}
			if(valName=="Dismissal" || valName=="Resignation" || valName=="Termination")
			{
				if(document.getElementById('remarks')!="")
				{
					document.getElementById('remarks').setAttribute('validate','Remarks,string,yes');
				}
		 	}else{
				document.getElementById('remarks').setAttribute('validate','Remarks,string,no');
			}
		
	}
	return true;
	}
</script>


<script language="javascript">

function jsImport()
{

	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Pl. Select a photo to upload!.....');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	
	//var st = fname.length;
	//st = st-3;
	//if (fname.substring(st)!="zip")
	//{
	//alert('Only zip files are Allowed. Please Zip all the Excel Files and Give the file as input !....For further Help, Refer User Manual.');
	//return;
	//}
	var ind1 = fname.lastIndexOf("\\");
	
	var filename = fname.substring(ind1+1);
	if(filename.lastIndexOf(".jpg")==-1){
	alert("File Type is InCorrect choose Another");
	document.getElementById('fileNameId').value="";
	}else{
	document.attachPhoto.method="post";
	submitForm('attachPhoto','aviationMedicine?method=addPhotoFile&filename='+filename);
	window.close();
	}
}

</script>
<%
String empcode = "";
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
		Map<String,Object> mapEmployee = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		List<UploadDocuments> uploadDocuments=new ArrayList<UploadDocuments>();
		if(map.get("uploadDocuments")!= null){
			uploadDocuments = (List)map.get("uploadDocuments");
		}
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasHospital> hospitalList = new ArrayList<MasHospital>();
		List<MasCostCenter> costCenterList = new ArrayList<MasCostCenter>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasRankCategory> rankCategoryList = new ArrayList<MasRankCategory>();
		List<MasCountry> countryList = new ArrayList<MasCountry>();
		List<MasState> stateList = new ArrayList<MasState>();
		List<MasDistrict> districtList = new ArrayList<MasDistrict>();
		
		List<MasDivision> divisionList = new ArrayList<MasDivision>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<MasBloodGroup> bloodGroupList = new ArrayList<MasBloodGroup>();
		List<MasAdministrativeSex> sexList = new ArrayList<MasAdministrativeSex>();

		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasEmployeeType> employeeTypeList  = new ArrayList<MasEmployeeType>();
		
		
		if(mapEmployee.get("titleList") != null){
			titleList = (List<MasTitle>)mapEmployee.get("titleList");
			session.setAttribute("titleList", titleList);
		}else if(session.getAttribute("titleList") != null){
			titleList = (List<MasTitle>)session.getAttribute("titleList");
		}
		
		if(mapEmployee.get("departmentList") != null){
			departmentList = (List<MasDepartment>)mapEmployee.get("departmentList");
			session.setAttribute("departmentList", departmentList);
		}else if(session.getAttribute("departmentList") != null){
			departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
		}
		
		if(mapEmployee.get("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)mapEmployee.get("empStatusList");
			session.setAttribute("empStatusList", empStatusList);
		}else if(session.getAttribute("empStatusList") != null){
			empStatusList = (List<MasEmpStatus>)session.getAttribute("empStatusList");
		}
		
		if(mapEmployee.get("hospitalList") != null){
			hospitalList = (List<MasHospital>)mapEmployee.get("hospitalList");
		}
		
		
		if(mapEmployee.get("costCenterList") != null){
			costCenterList = (List<MasCostCenter>)mapEmployee.get("costCenterList");
			session.setAttribute("costCenterList", costCenterList);
		}else if(session.getAttribute("costCenterList") != null){
			costCenterList = (List<MasCostCenter>)session.getAttribute("costCenterList");
		}
		
		if(mapEmployee.get("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)mapEmployee.get("empCategoryList");
			session.setAttribute("empCategoryList", empCategoryList);
		}else if(session.getAttribute("empCategoryList") != null){
			empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
		}
	
		if(mapEmployee.get("gradeList") != null){
			gradeList = (List<MasGrade>)mapEmployee.get("gradeList");
			session.setAttribute("gradeList", gradeList);
		}else if(session.getAttribute("gradeList") != null){
			gradeList = (List<MasGrade>)session.getAttribute("gradeList");
		}
		if(mapEmployee.get("rankList") != null){
			rankList = (List<MasRank>)mapEmployee.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (List<MasRank>)session.getAttribute("rankList");
		}
				
		if(mapEmployee.get("unitList") != null){
			unitList = (List<MasUnit>)mapEmployee.get("unitList");
			session.setAttribute("unitList", unitList);
		}else if(session.getAttribute("unitList") != null){
			unitList = (List<MasUnit>)session.getAttribute("unitList");
		}
				
		if(mapEmployee.get("rankCategoryList") != null){
			rankCategoryList = (List<MasRankCategory>)mapEmployee.get("rankCategoryList");
			session.setAttribute("rankCategoryList", rankCategoryList);
		}else if(session.getAttribute("rankCategoryList") != null){
			rankCategoryList = (List<MasRankCategory>)session.getAttribute("rankCategoryList");
		}
		if(mapEmployee.get("countryList") != null){
			countryList = (List<MasCountry>)mapEmployee.get("countryList");
			session.setAttribute("countryList", countryList);
		}else if(session.getAttribute("countryList") != null){
			countryList = (List<MasCountry>)session.getAttribute("countryList");
		}
		if(mapEmployee.get("stateList") != null){
			stateList = (List<MasState>)mapEmployee.get("stateList");
			session.setAttribute("stateList", stateList);
		}else if(session.getAttribute("stateList") != null){
			stateList = (List<MasState>)session.getAttribute("stateList");
		}
		if(mapEmployee.get("districtList") != null){
			districtList = (List<MasDistrict>)mapEmployee.get("districtList");
			session.setAttribute("districtList", districtList);
		}else if(session.getAttribute("rankCategoryList") != null){
			districtList = (List<MasDistrict>)session.getAttribute("districtList");
		}
		
		if(mapEmployee.get("divisionList") != null){
			divisionList = (List<MasDivision>)mapEmployee.get("divisionList");
			session.setAttribute("divisionList", divisionList);
		}else if(session.getAttribute("divisionList") != null){
			divisionList = (List<MasDivision>)session.getAttribute("divisionList");
		}
		
		if(mapEmployee.get("employeeTypeList") != null){
			employeeTypeList = (List<MasEmployeeType>)mapEmployee.get("employeeTypeList");
			session.setAttribute("employeeTypeList", employeeTypeList);
		}else if(session.getAttribute("employeeTypeList") != null){
			employeeTypeList = (List<MasEmployeeType>)session.getAttribute("employeeTypeList");
		}
		if(mapEmployee.get("tradeList") != null){
			tradeList = (List<MasTrade>)mapEmployee.get("tradeList");
			session.setAttribute("tradeList", tradeList);
		}else if(session.getAttribute("tradeList") != null){
			tradeList = (List<MasTrade>)session.getAttribute("tradeList");
		}
		if(mapEmployee.get("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)mapEmployee.get("bloodGroupList");
			session.setAttribute("bloodGroupList", bloodGroupList);
		}else if(session.getAttribute("bloodGroupList") != null){
			bloodGroupList = (List<MasBloodGroup>)session.getAttribute("bloodGroupList");
		}
		if(mapEmployee.get("sexList") != null){
			sexList = (List<MasAdministrativeSex>)mapEmployee.get("sexList");
			session.setAttribute("sexList", bloodGroupList);
		}else if(session.getAttribute("sexList") != null){
			sexList = (List<MasAdministrativeSex>)session.getAttribute("sexList");
		}
	
		
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		
		List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>(); 
		if(mapEmployee.get("searchEmployeeList") != null){
			searchEmployeeList = (List)mapEmployee.get("searchEmployeeList");
		}
		List<UsergroupHospital> usergroupHospitalList = new ArrayList<UsergroupHospital>();
		if(mapEmployee.get("usergroupHospitalList") != null){
			usergroupHospitalList = (List)mapEmployee.get("usergroupHospitalList");
		}
		List<Object[]> groupList = new ArrayList<Object[]>();
		if(map.get("groupList") != null){
		groupList=(List<Object[]>)map.get("groupList");
		}
		List empGroupList= new ArrayList();
		if(map.get("empGroupList") != null){
			empGroupList = (ArrayList)map.get("empGroupList");
			}
		//System.out.println("searchEmployeeList  "+searchEmployeeList.size());
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		/* int hospitalId = 0;
		if (session.getAttribute("hospitalId") != null) {
			Integer temp =  (Integer)session.getAttribute("hospitalId");
			hospitalId = temp.intValue();
		} */
		List<MasTemplate> masTemplateList = new ArrayList<MasTemplate>();
		if(map.get("masTemplateList")!=null){
			masTemplateList =(List) map.get("masTemplateList");
		}
		if(mapEmployee.get("message") != null){
			   String message = (String)mapEmployee.get("message");
			   %>
<h4><%=message %></h4>
<% }
		ArrayList gridUnitList = (ArrayList)mapEmployee.get("gridUnitList");
%>
<div class="titleBg">
	<h2>Employee Master</h2>
</div>
<div id="searcharea">
	<form name="search" method="post" action="">
		<div class="Block">
			<label>Employee Id/PB NO.</label> <input type="radio"
				class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1"
				checked="checked" /> <label>First Name</label> <input type="radio"
				class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" /> <input type="hidden" class="radioAuto"
				name="<%=SELECTED_RADIO %>" value="3" /> <input type="text"
				id="searchField" name="<%= SEARCH_FIELD%>" value=""
				validate="Employee Code,string,no" MAXLENGTH="8"
				onkeypress="return submitenter(this,event,'personnel?method=searchEmployee')" />
			<input type="button" name="search" value="Search" class="button"
				onclick="submitForm('search','personnel?method=searchEmployee','checkSearch')"
				tabindex=1 />
			<%--- Report Button   --%>
			<input type="button" name="Report"
				value="Generate Report Based on Search" class="buttonBig3"
				onClick="submitForm('search','personnel?method=generateReportForEmployeeInformation');"
				accesskey="g" tabindex=1 />
		</div>
	</form>
	<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults">
	<div id="searchtable"></div>
	<% try{
		if(searchEmployeeList.size()>0 )
		 {
			String strForCode = (String)mapEmployee.get("serviceNo");
			String strForCodeFirstDescriptions = (String)mapEmployee.get("firstName");
			String strForCodeLastDescriptions = (String)mapEmployee.get("lastName");
			if(strForCode!= null && strForCode!= "" || strForCodeFirstDescriptions!= null && strForCodeFirstDescriptions!= "" || strForCodeLastDescriptions!=null && strForCodeLastDescriptions!="")
			{
				%>
	<br />
	<h4>
		<a href="personnel?method=showEmployeeJsp">Show All Records</a>
	</h4>
	<%
			}
		 } if(searchEmployeeList.size()==0 && mapEmployee.get("search") != null)
		  {
			 %>
	<h4>
		<a href="personnel?method=showEmployeeJsp">Show All Records</a>
	</h4>
	<%
		     }
	   }
	      catch(Exception e){
	    	  e.printStackTrace();
	      }
    %>


	<script type="text/javascript">
	
	formFields = [[0,"<%=COMMON_ID%>"],[1,"<%= SERVICE_NO%>"],[2,"<%=EMPLOYEE_GRADE_ID%>"], [3,"halJoiningDate"],[4,"currDivisionJoiningDate"],[5,"<%= TITLE_ID %>"],[6,"<%= FIRST_NAME %>"],[7,"<%= MIDDLE_NAME %>"],[8,"<%= LAST_NAME%>"],
	              [9,"divisionId"],[10,"<%= DEPARTMENT_ID%>"],
	               [11,"dob"],[12,"empType"],[13,"deptNo"],[14,"aadharCard"],[15,"<%= EMPLOYEE_CATEGORY_ID %>"],[16,"<%= RANK_ID %>"],
	              [17,"<%= BLOOD_GROUP_ID %>"],[18,"sexId"],[19,"<%=EMERGENCY_MOBILE%>"],[20,"<%=TELL_NO_OFFICE%>"],[21,"localAddress"],
	  [22,"localCountry"],[23,"localState"],[24,"localDistrict"],[25,"perAddress"],[26,"perCountry"],
	  [27,"perState"],[28,"perDistrict"],[29,"<%= EMP_STATUS_ID %>"],
	  [30,"email"],[31,"<%= CHANGED_BY%>"],[32,"<%=CHANGED_DATE %>"],[33,"<%=CHANGED_TIME %>"],[34,"rankCategoryId"],[35,"photo"],[36,"<%= STATUS%>"],[37,"<%= HOSPITAL_ID%>"],[37,"<%= HOSPITAL_ID%>"],[38,"<%= HIGH_VALUE_DRUG%>"], [39,"hiddenLocalAddress"], [40,"hiddenLocalCountry"],[41,"hiddenLocalState"],[42,"hiddenLocalDistrict"]
	,[43,"contract"]
	,[44,"remarks"]
	,[45,"extension"]
	,[46,"pfNo"]
	,[47,"panNo"]
	,[48,"accountNo"]
	,[49,"bankName"]
	];

	 statusTd = 36;
	</script>
</div>
<form name="employee" method="post" action="" enctype="multipart/form-data">
	<input type="hidden" name="<%= POJO_NAME %>" value="MasEmployee">
	<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ServiceNo">
	<input type="hidden" name="title" value="Employee"> <input
		type="hidden" name="<%=JSP_NAME %>" value="employee"> <input
		type="hidden" name="pojoPropertyCode" value="EmployeeCode"> <input
		type="hidden" id="dclick" value="yes"> <input type="hidden"
		id="rowid" value="">
	<div class="Clear"></div>
	<h4>Employee Details</h4>
	<div class="Clear"></div>
	<div class="Block">
		<%--
<label><span>*</span> Emp Code </label>
 <script>
	document.employee.<%=EMPLOYEE_CODE%>.focus();
</script>
 --%>
		<input id="codeId" type="hidden" readonly="readonly"
			name="<%= EMPLOYEE_CODE%>" value="<%=empcode%>"
			validate="Employee Code,string,no" MAXLENGTH="12"/  > <label>EmployeeId/PB No.<span>*</span>
		</label> <input type="text" name="<%= SERVICE_NO%>" value=""		validate="EmployeeId/PB No.,string,yes" MAXLENGTH="15" id="serviceNo"
			onblur="checkEmpPBNo(this.value);setloginName(this.value);" /> <label>Rank Category<span>*</span></label>

		<select id="rankCategoryId" name=<%=RANK_CATEGORY_ID%> 	validate="Rank Category,string,yes"  onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getGradeList','gradeDiv');">
			<option value="0">Select</option>

			<%
				         		if(rankCategoryList != null){ 	
				         			for (Iterator iter = rankCategoryList.iterator(); iter.hasNext();) {
				         				MasRankCategory masRankCategory = (MasRankCategory) iter.next();
				         %>
			<option value="<%=masRankCategory.getId() %>"><%=masRankCategory.getRankCategoryName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select> 
		<div id="gradeDiv">
		<label>Grade<span>*</span></label> 
		<select id="<%=EMPLOYEE_GRADE_ID%>" name="<%=EMPLOYEE_GRADE_ID%>" validate="Grade,string,yes">
			<option value="0">Select</option>



			<%
				         		if(gradeList != null){ 	
				         			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
				         				MasGrade masGrade = (MasGrade) iter.next();
				         %>
			<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>
			<%		
				        			}
				        		 } 
				        %>


		</select>
		</div>
		<div class="Clear"></div>
		<div class="Clear"></div>
		<label>Date Of Joining HAL<span>*</span></label> 
		<input type="text"	id="halJoiningDate" name="halJoiningDate"  value="" class="date"	readonly="readonly" validate="Date of Joining HAL,date,yes"	MAXLENGTH="30" />
		<img src="/hms/jsp/images/cal.gif" width="16"			height="16" border="0" validate="Pick a date" class="calender"			tabindex="1"			onClick="setdate('<%=date%>',document.employee.halJoiningDate,event)" />
		
		
		<label>Date Of Joining Current Division<span>*</span></label> <input type="text" id="currDivisionJoiningDate" name="currDivisionJoiningDate" value="" class="date"	readonly="readonly" 	validate="Date Of Joining Current Division,date,yes" MAXLENGTH="30" />
		<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"		validate="Pick a date" class="calender" tabindex="1"		onClick="setdate('<%=date%>',document.employee.currDivisionJoiningDate,event)" />

		<label>Title </label> <select id="titleId" name=<%=TITLE_ID %>>
			<option value="0">Select</option>

			<%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         %>
			<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		<div class="Clear"></div>
		<label>First Name<span>*</span></label> <input type="text"
			id="firstName" name="<%=FIRST_NAME %>" value=""
			validate="First Name,fullName,yes" MAXLENGTH="25" /> <label>Middle
			Name</label> <input type="text" name="<%=MIDDLE_NAME%>" value=""
			validate="Middle Name,fullName,no" MAXLENGTH="15" /> <label>Last
			Name
		</label> <input type="text" id="lastName" name="<%=LAST_NAME %>" value=""
			validate="Last Name,fullName,no" MAXLENGTH="15" />
		<div class="Clear"></div>
		
		<label>Division<span>*</span></label> 
		<select id="divisionId" 	name="divisionId" validate="Division,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getDepartmentList','departmentDiv');">
			<option value="0">Select</option>

			<%
				         		if(divisionList != null){ 	
				         			for (Iterator iter = divisionList.iterator(); iter.hasNext();) {
				         				MasDivision division = (MasDivision) iter.next();
				         %>
			<option value="<%=division.getId() %>"><%=division.getDivisionName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		<div id="departmentDiv">
		 <label>Department<span>*</span></label>
		
		 <select id="departmentId" 	name="departmentId" validate="Department,string,yes" onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getDepartmentNoList','departmentNoDiv');" >
		 
		 
		 			<option value="0">Select</option>

			<%
				         		if(departmentList != null){ 	
				         			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
				         				MasDepartment MasDepartment = (MasDepartment) iter.next();
				         %>
			<option value="<%=MasDepartment.getId() %>"><%=MasDepartment.getDepartmentName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		<div id="departmentNoDiv">
			<label>Department No.<span>*</span></label> 
		<input type="text" id="deptNo" name="deptNo" value=""	 readonly="readonly" validate="Department No.,alphanumeric,yes" MAXLENGTH="50" />
	
		 </div>  
				      
	 </div>


		<div class="Clear"></div>
		
		 <label>D.O.B<span>*</span></label> 
		<input type="text" id="dob"	name="dob" value="" class="date" readonly="readonly" onblur="checkDateBirthYear();"
			validate="Date of Birht,date,yes" MAXLENGTH="30"  /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=date%>',document.employee.dob,event);"  />
			
		<label>Employee Type<span>*</span></label> <select id="empType"
			name="empType" validate="Employee Type ,string,yes">
			<option value="0">Select</option>

			<%
				         		if(employeeTypeList != null){ 	
				         			for (Iterator iter = employeeTypeList.iterator(); iter.hasNext();) {
				         				MasEmployeeType employeeType = (MasEmployeeType) iter.next();
				         %>
			<option value="<%=employeeType.getId() %>"><%=employeeType.getEmployeeTypeName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		
		 
		
		
		 <label>Aadhar
			Card<span></span>
		</label> <input type="text" id="aadharCard" name="aadharCard" value=""
			validate="Aadhar Card,string,no" MAXLENGTH="50" />

		<div class="Clear"></div>

		<input type="hidden" name="<%= EMPLOYEE_JOB_CODE %>" value=""
			validate="Job Code,string,no" MAXLENGTH="8" />
			
		<label>Category<span>*</span></label>
		<select id="employeeCategoryId" name=<%=EMPLOYEE_CATEGORY_ID %>		validate="Category,string,no" onblur="categorySelectDoctor(this.value);">
			<option value="0">Select</option>
			<%
				         		if(empCategoryList != null){ 	
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         %>
			<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select> 
		 
				<div id="doctorDiv" style="display: none">
		<label> Authoriz for high value Medicine</label> 
		<input	type="checkbox" name="<%=HIGH_VALUE_DRUG %>" value="y"	class="radioCheck" id="authoriz" />
		<div class="Clear"></div>
		
		</div>

			<label>Designation/Appointment<span>*</span></label> 
			
			
			<select  name=<%=RANK_ID %> id="<%=RANK_ID%>" validate="Designation,string,yes" >
				<option value="0">Select</option>
				            
				        <%if(rankList != null){ 	
				         			
				         				for (MasRank masRank :rankList) {	%>
						 
						 <option value="<%=masRank.getId()%>"><%=masRank.getRankName() %></option> 
				        <%	}} %>
				        
			      </select>
			      
			
			
			<label>	Blood Group </label> 
			<select id="bldGrpId" name=<%=BLOOD_GROUP_ID %> validate="Blood Group,string,no">
			<option value="0">Select</option>	

			<%
				         		if(bloodGroupList != null){ 	
				         			for (Iterator iter = bloodGroupList.iterator(); iter.hasNext();) {
				         				MasBloodGroup bloodGroup = (MasBloodGroup) iter.next();
				         %>
			<option value="<%=bloodGroup.getId() %>"><%=bloodGroup.getBloodGroupName() %></option>
			<%		
				        			}
				        		 } 
				        %>
		</select>
		<div class="Clear"></div>

		<!-- Room No. Added By Ritu on 12 March 2012 -->

		<label> Gender <span>*</span></label> <select name="sexId" id="sexId"
			validate="Gender,string,yes" tabindex="1">
			<option value="0">Select</option>
			<%
		   	 		for(MasAdministrativeSex masAdministrativeSex : sexList){
			%>
			<option value="<%=masAdministrativeSex.getId() %>"><%=masAdministrativeSex.getAdministrativeSexName() %></option>
			<%
		   	 	} %>
		</select>
		 <input type="hidden" name="<%= BANK_CODE%>" value=""		validate="Bank Code,string,no" MAXLENGTH="8"/ > 
		 <input	type="hidden" name="<%= BANK_ACCOUNT_CODE%>" value=""	validate="Bank Account Code,string,no" MAXLENGTH="10" /> 
		 <input	type="hidden" name="<%= BANK_ACCOUNT_NUMBER%>" value=""	validate="Bank Account Number,string,no" MAXLENGTH="20" /> 
		 <input	type="hidden" name="<%= ACCOUNT_HEAD%>" value="" validate="Account Head,name,no" MAXLENGTH="10"/>
		<%--
		<h4>Employee Bank Details </h4>
		<div class="Clear"></div>
		<div class="Block">   	  	 
   	  	<label >Bank Code</label>
			<label >Bank A/C Code</label>
			<input type="text" name="<%= BANK_ACCOUNT_CODE%>" value="" validate="Bank Account Code,string,no"  MAXLENGTH="10"/>
			
			<label >A/C Number</label>
		<input type="text" name="<%= BANK_ACCOUNT_NUMBER%>" value="" validate="Bank Account Number,string,no"  MAXLENGTH="20"/>
   	  	 <div class="Clear"></div>
			<label >A/C Head</label>
			<input type="text" name="<%= ACCOUNT_HEAD%>" value="" validate="Account Head,name,no"  MAXLENGTH="10"/ >
   	  	 
   	 </div> 	 
   	  <div class="Clear"></div>
		<h4>Employee Contact Details</h4>
	    <div class="Block">
		<div class="Clear"></div>
   	 --%>
		<label>Mobile</label>
		 <input type="text" name="<%= EMERGENCY_MOBILE%>"	value="" validate="Mobile,alphanumeric,no" MAXLENGTH="12"  />

		<label>Office Phone</label> <input type="text" id="offPhone"	name="<%= TELL_NO_OFFICE%>" value=""	validate="Office Phone,alphanumeric,no" MAXLENGTH=12 />
		<input type="hidden" name="<%= TELL_NO_RESIDENCE %>" value=""	validate="Residence Phone,alphanumeric,no" MAXLENGTH="12"/ >
		
		

		<div class="Clear"></div>


		<div class="Clear"></div>
		<label>Local Address<span>*</span></label>
		<textarea rows="4" id="localAddress" name="localAddress" value=""	validate="Local Address,string,yes" MAXLENGTH="500"></textarea>
			 


			<input type="hidden" name="hiddenLocalCountry" id="hiddenLocalCountry" value=""/>
			<input type="hidden" name="hiddenLocalState" id="hiddenLocalState" value=""/>
			<input type="hidden" name="hiddenLocalDistrict" id="hiddenLocalDistrict" value=""/>
			<input type="hidden" name="hiddenLocalAddress" id="hiddenLocalAddress" value=""/>
		<label> Country <span>*</span></label> 
		<select name="localCountry"			id="localCountry" validate="Local Country,string,yes" tabindex="1"   onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getLocalStateList','localStateDiv');">
			<option value="0">Select</option>
			<%
		   	 		for(MasCountry masCountry : countryList){
			%>
			<option value="<%=masCountry.getId()%>"><%=masCountry.getCountryName() %></option>
			<%
		   	 	} %>
		</select> 
			
		
		<div id="localStateDiv">
		<label> State <span>*</span></label>
		 <select name="localState"	 id="localState" validate="Local State,string,yes" tabindex="1"   onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getLocalDistrictList','localDistrictDiv');">
			<option value="0">Select</option>
			<%
		   	 		for(MasState masState : stateList){
			%>
			<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
			<%
		   	 	} %>
		</select>
			<div id="localDistrictDiv">
		 <label> District <span>*</span></label> 
		 <select name="localDistrict"		id="localDistrict" validate="Local District,string,yes" tabindex="1" >
			<option value="0">Select</option>
			<%
		   	 		for(MasDistrict masDistrict : districtList){
			%>
			<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>
			<%
		   	 	} %>
		</select>
		</div>
		</div>
		
		<div class="Clear"></div>
		<label class="auto">(Permanent address same as local address)</label><input type="checkbox" name="addresschk" 	id="addresschk" onclick="getAddresschk()"  value='y'  class="radioAuto"/>
		
		<div class="Clear"></div>
		<label>Permanent Address</label>
		<textarea rows="4" cols="50" id="perAddress" name="perAddress"		value="" validate="Permanent Address,string,no"	MAXLENGTH="500"></textarea>

		<label> Country <span>*</span></label> 
		<select name="perCountry" 	id="perCountry" validate="Permanent Country,string,yes" tabindex="1"  onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getPerStateList','perStateDiv');">
			<option value="0">Select</option>
			<%
		   	 		for(MasCountry masCountry : countryList){
			%>
			<option value="<%=masCountry.getId() %>"><%=masCountry.getCountryName() %></option>
			<%
		   	 	} %>
		</select> 
		<div id="perStatetDiv">
		<label> State <span>*</span></label> 
		<select name="perState"	id="perState" validate="Permanent State,string,yes" tabindex="1" onchange="submitProtoAjaxWithDivNameToShowStatus('employee','/hms/hms/personnel?method=getPerDistrictList','perDistrictDiv');"> 
			<option value="0">Select</option>
			<%
		   	 		for(MasState masState : stateList){
			%>
			<option value="<%=masState.getId() %>"><%=masState.getStateName() %></option>
			<%
		   	 	} %>
		</select> 
		<div id="perDistrictDiv">
		<label> District <span>*</span></label> <select name="perDistrict"			id="perDistrict" validate="Permanent District,string,yes"			tabindex="1">
			<option value="0">Select</option>
			<%
		   	 		for(MasDistrict masDistrict : districtList){
			%>
			<option value="<%=masDistrict.getId() %>"><%=masDistrict.getDistrictName() %></option>
			<%
		   	 	} %>
		</select>
</div>
</div>

		<div class="Clear"></div>
		<label>Status<span>*</span> </label> <select id="empStatusId"		name="<%=EMP_STATUS_ID %>"  onclick="checkStatusVal();"  validate="Status,string,yes">
			<option value="0">Select</option>

			<%
			           		if(empStatusList != null){ 	
			           			for (Iterator iter = empStatusList.iterator(); iter.hasNext();) {
			           				MasEmpStatus masEmpStatus = (MasEmpStatus) iter.next();
			           %>
			<option value="<%=masEmpStatus.getId() %>"><%=masEmpStatus.getEmpStatusName() %></option>
			<%		
			          			}
			          		 } 
			          %>
		</select> <label>Email-Id</label> 
		<input type="text" id="email" name="email"			value="" validate="Email-Id,email,no" MAXLENGTH="50" /> 
		


		<label> Hospital<span>*</span>
			</label> <select name="<%=HOSPITAL_ID %>" id="<%=HOSPITAL_ID %>"	 validate="Hospital,string,yes"
				tabindex=1>
				<option value="0">Select</option>

				<%
			           		if(hospitalList != null){ 	
			           			for (Iterator iter = hospitalList.iterator(); iter.hasNext();) {
			           				MasHospital masHospital = (MasHospital) iter.next();
			           %>
				<option value="<%=masHospital.getId() %>" ><%=masHospital.getHospitalName() %></option>
				<%		
			          			}
			          		 } 
			          %>
			</select>
			
		<div class="Clear"></div>

<label>PF No</label> <input type="text"
			id="pf_no" name="pf_no" value=""
			validate="PF No,string,no" MAXLENGTH="25" />
			
<label>PAN No</label> <input type="text"
			id="pan_no" name="pan_no" value=""
			validate="PAN No,string,no" MAXLENGTH="25" />
			
<label>Account No</label> <input type="text"
			id="account_no" name="account_no" value=""
			validate="Account No,string,no" MAXLENGTH="25" />
			
			<label>Bank Name</label> <input type="text"
			id="bank_name" name="bank_name" value=""
			validate="Bank Name,string,no" MAXLENGTH="25" />
			
			
<div class="Clear"></div>

			
		<label> Remarks</label>
		<textarea rows="" cols="" name="remarks" id="remarks"></textarea> 
		
		
		
				<div id="contractDiv" style="display: none;">
		<label> Date of Contract<span>*</span></label>
		<input type="text" id="contract"	name="contract" value="" class="date" readonly="readonly" 
			validate="Date of  contract,date,no" MAXLENGTH="30"  /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=date%>',document.employee.contract,event);"  />
		 
		</div>
		
				<div id="extensionDiv" style="display: none;">
		<label> Date of Extension<span>*</span></label>
		<input type="text" id="extension"	name="extension" value="" class="date" readonly="readonly" 
			validate="Date of  Extension,date,no" MAXLENGTH="30"  /> <img
			src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
			validate="Pick a date" class="calender" tabindex="1"
			onClick="setdate('<%=date%>',document.employee.extension,event);"  />
		 
		</div>	
		
		<div class="Clear"></div>
		<label>Photo</label>
		
 <input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse" validate="photo,string,no">
  <input type="hidden" name="flag" id="flag" value="n">
  <input type="hidden" id="fileName" name="fileName" vale="" />

	<img id="imageIDD" align="right" src=""  width="100px"	height="90px" style="display: none;">  
		

	
		

   
				<!-- <label>Photo</label>

<input type="file" name="<%=UPLOAD_FILENAME %>" id="fileNameId" class="browse">
<div class="clear"></div>
<input name="Submit13" type="button" class="button" value="Add" onClick="jsImport();"/>
<div class="clear"></div>
only .jpg files are accepted
</div> -->
		
		<div class="Clear"></div>
	</div>
	<div style="display: none;">
		<h4>
			Login Details<input type="checkbox" name="loginRequired"
				id="loginRequired" onclick="getLoginRequired()" checked="checked" />(If
			Required)
		</h4>
		<div class="Clear"></div>
		<div class="Block">
			<label> Login Name<span>*</span></label> <input type="text"
				id="loginName" value="" readonly="readonly"
				validate="Login Name,string,no" /> <label>Password<span>*</span>
			</label> <input id="password" name=<%=PASSWORD%> type="password"
				maxlength="15" tabindex="1" readonly="readonly"
				validate="Password,string,no" />
			<div class="Clear"></div>

			<label> User Department<span>*</span>
			</label> 
			<select name="userDepartmentId" id="userDepartmentId" multiple
				size="6" class="list" validate="User Department,string,no"
				tabindex=1>
				<option value="0">Select</option>

				<%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           %>
				<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
				<%		
			          			}
			          		 } 
			          %>
			</select>
			
			
			
		</div>
		<div class="Clear"></div>
	</div>
	<%--Code for Login Menu Assign  --%>
	<%-- 
		<h4>Modules</h4>
		<table border="0" align="center" cellpadding="0" cellspacing="0" id="grid">
	<tr>
		<%
	System.out.println("masTemplateList.size() employe.jsp---->"+masTemplateList.size());
	int counterMenu=0;
		if(masTemplateList.size()>0){
		for(MasTemplate masTemplate :masTemplateList){
			++counterMenu;
	%>
	<!-- day+"/"+month+"/"+year -->
	<th><%=masTemplate.getTemplateName()%>
	<input type="checkbox"  name="templetId<%=counterMenu%>" id="templetId<%=counterMenu%>" value="<%=masTemplate.getId()%>" />
	</th>
	<%
	}
	}
	
	%>
	</tr>
	
	
</table>


	<div class="clear"></div>
	<h4>Modules</h4>
	<div class="clear"></div>
	<div class="Block">
		<div id="testDiv">

			<%
	//System.out.println("masTemplateList.size() employe.jsp---->"+masTemplateList.size());
	int counterMenu=0;
		if(masTemplateList.size()>0){
		for(MasTemplate masTemplate :masTemplateList){
			++counterMenu;
	%>
			<!-- day+"/"+month+"/"+year -->
			<label class="medium"><%=masTemplate.getTemplateName()%> </label> <input
				type="checkbox" class="radioAuto" name="templetId<%=counterMenu%>"
				id="templetId<%=counterMenu%>" value="<%=masTemplate.getId()%>" />
			<%
	if(counterMenu%8==0){
		%>
			<div class="clear"></div>
			<%
	}
	}
	}
	
	%>
			<input type="hidden" name="counterMenu" id="counterMenu"
				value="<%=counterMenu%>" /> <input type="hidden" name="templetCnt"
				id="templetCnt" value="<%=masTemplateList.size()%>" />
			<div class="clear"></div>
		</div>
	</div>
	<%--End of Code for Login Menu Assign  --%>
	<div id="edited"></div>
	<div class="Clear"></div>
	<input type="button" name="add" id="addbutton" value="Add"		class="button"		onClick="if(validateEmployeeLogin()){submitForm('employee','personnel?method=addEmployee')}"
		accesskey="a" /> 
	<input type="button" name="edit" id="editbutton"		value="Update" class="button"		onClick="if(validateEmployee()){submitForm('employee','personnel?method=editEmployee')}"
		accesskey="u" /> 
		<input type="button" name="Delete" id="deletebutton"		value="Activate" class="button"		onClick="if(validateEmployee()){submitForm('employee','personnel?method=deleteEmployee1&flag='+this.value)}"
		accesskey="d" /> 
		<input type="hidden" name="login" id="loginbutton"		value="Generate login" class="buttonBig2"		onClick="if(checkforrecord()){submitForm('employee','personnel?method=generateEmployeeLogin')}"
		accesskey="g" /> 
		<input type="reset" name="Reset" id="reset"		value="Reset" class="button" onclick="location.reload();"		accesskey="r" /> 
		<input type="hidden" id="status" name="<%=STATUS %>"		value="" /> 
		<input type="hidden" name="<%= COMMON_ID%>" value="" />


	<div class="Clear"></div>
	<div class="Clear"></div>

	<div class="bottom">
		<label>Changed By:</label> <label class="value"><%=userName%></label>

		<label>Changed Date:</label> <label class="value"><%=date%></label> <label>Changed
			Time:</label> <label class="value"><%=time%></label> <input type="hidden"
			name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
			name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
			name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>



</form>
<div class="Clear"></div>

<script type="text/javascript">
var faqtable=new switchicon("icongroup2", "div") //Limit scanning of switch contents to just "div" elements
faqtable.setHeader('<img src="/hms/jsp/images/minus.gif" />', '<img src="/hms/jsp/images/plus.gif" />') //Set header HTML
faqtable.collapsePrevious(false) //Allow more than 1 content to be open simultanously
faqtable.setPersist(true, 0) //Enable persistence to remember last switch content states for 7 days
faqtable.init()
</script>



<script type="text/javascript">

data_header = new Array();

<%-- data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "<%= EMPLOYEE_CODE %>"

data_header[0] = new Array;
data_header[0][0] = "Sl.No."
data_header[0][1] = "hide";
data_header[0][2] = 0;
data_header[0][3] = "sl_no"
 --%>
<%-- data_header[2] = new Array;
data_header[2][0] = "Employee Id/PB No."
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= SERVICE_NO%>"
 --%>



data_header[0] = new Array;
data_header[0][0] = "Employee Id/PB No."
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%=SERVICE_NO%>"

data_header[1] = new Array;
data_header[1][0] = "Grade"
data_header[1][1] = "hide";
data_header[1][2] = 0;
data_header[1][3] = "<%=EMPLOYEE_GRADE_ID%>"

data_header[2] = new Array;
data_header[2][0] = "Date of Joining HAL"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "halJoiningDate"

	data_header[3] = new Array;
data_header[3][0] = "Date of Joining Current Division"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "currDivisionJoiningDate"

	data_header[4] = new Array;
data_header[4][0] = "Title"
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= TITLE_ID %>"

data_header[5] = new Array;
data_header[5][0] = "First Name"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%= FIRST_NAME %>";

data_header[6] = new Array;
data_header[6][0] = "Middle Name"
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= MIDDLE_NAME %>"

data_header[7] = new Array;
data_header[7][0] = "Last Name"
data_header[7][1] = "data";
data_header[7][2] = 0;
data_header[7][3] = "<%= LAST_NAME %>"

data_header[8] = new Array;
data_header[8][0] = "Division"
data_header[8][1] = "data";
data_header[8][2] = 0;
data_header[8][3] = "divisionId"

data_header[9] = new Array;
data_header[9][0] = "Department"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= DEPARTMENT_ID %>"

data_header[10] = new Array;
data_header[10][0] = "D.O.B"
data_header[10][1] = "hide";
data_header[10][2] = 0;
data_header[10][3] = "dob"

data_header[11] = new Array;
data_header[11][0] = "Employee Type"
data_header[11][1] = "hide";
data_header[11][2] = 0;
data_header[11][3] = "empType"

data_header[12] = new Array;
data_header[12][0] = "Department No"
data_header[12][1] = "hide";
data_header[12][2] = 0;
data_header[12][3] = "deptNo"

	data_header[13] = new Array;
data_header[13][0] = "Aadhar Card"
data_header[13][1] = "hide";
data_header[13][2] = 0;
data_header[13][3] = "aadharCard"

	data_header[14] = new Array;
data_header[14][0] = "Category"
data_header[14][1] = "hide";
data_header[14][2] = 0;
data_header[14][3] = "<%= EMPLOYEE_CATEGORY_ID%>"

	data_header[15] = new Array;
data_header[15][0] = "Designation/Appointment"
data_header[15][1] = "hide";
data_header[15][2] = 0;
data_header[15][3] = "<%=RANK_ID%>"



	data_header[16] = new Array;
	data_header[16][0] = "Blood Group"
	data_header[16][1] = "hide";
	data_header[16][2] = 0;
	data_header[16][3] = "<%=BLOOD_GROUP_ID%>"
	
		data_header[17] = new Array;
	data_header[17][0] = "Gender"
	data_header[17][1] = "hide";
	data_header[17][2] = 0;
	data_header[17][3] = "sexId";
	

	data_header[18] = new Array;
	data_header[18][0] = "E M"
	data_header[18][1] = "hide";
	data_header[18][2] = 0;
	data_header[18][3] = "<%= EMERGENCY_MOBILE%>"

	data_header[19] = new Array;
	data_header[19][0] = "Tel O"
	data_header[19][1] = "hide";
	data_header[19][2] = 0;
	data_header[19][3] = "<%= TELL_NO_OFFICE%>"

    data_header[20] = new Array;
	data_header[20][0] = "Local Address"
	data_header[20][1] = "hide";
	data_header[20][2] = 0;
	data_header[20][3] = "localAddress";
	

	data_header[21] = new Array;
	data_header[21][0] = "Local Country"
	data_header[21][1] = "hide";
	data_header[21][2] = 0;
	data_header[21][3] = "localCountry"

	data_header[22] = new Array;
	data_header[22][0] = "Local State"
	data_header[22][1] = "hide";
	data_header[22][2] = 0;
	data_header[22][3] = "localState"
	
		data_header[23] = new Array;
	data_header[23][0] = "Local District"
	data_header[23][1] = "hide";
	data_header[23][2] = 0;
	data_header[23][3] = "localDistrict"
	
	data_header[24] = new Array;
	data_header[24][0] = "Permanent Address"
	data_header[24][1] = "hide";
	data_header[24][2] = 0;
	data_header[24][3] = "perAddress";
	

	data_header[25] = new Array;
	data_header[25][0] = "Permanent Country"
	data_header[25][1] = "hide";
	data_header[25][2] = 0;
	data_header[25][3] = "perCountry"

	data_header[26] = new Array;
	data_header[26][0] = "Permanent State"
	data_header[26][1] = "hide";
	data_header[26][2] = 0;
	data_header[26][3] = "perState"
	
		data_header[27] = new Array;
	data_header[27][0] = "Permanent District"
	data_header[27][1] = "hide";
	data_header[27][2] = 0;
	data_header[27][3] = "perDistrict"

	


data_header[28] = new Array;
data_header[28][0] = ""
data_header[28][1]="hide";
data_header[28][2] = 0;
data_header[28][3] = "<%= EMP_STATUS_ID %>"

data_header[29] = new Array;
data_header[29][0] = "E-mail"
data_header[29][1] = "hide";
data_header[29][2] = 0;
data_header[29][3] = "email"

	data_header[30] = new Array;
data_header[30][0] = ""
data_header[30][1] = "hide";
data_header[30][2] = 0;
data_header[30][3] = "<%= CHANGED_BY%>"

data_header[31] = new Array;
data_header[31][0] = ""
data_header[31][1] = "hide";
data_header[31][2] = 0;
data_header[31][3] = "<%=CHANGED_DATE %>"

data_header[32] = new Array;
data_header[32][0] = ""
data_header[32][1] = "hide";
data_header[32][2] = 0;
data_header[32][3] = "<%=CHANGED_TIME %>"

data_header[33] = new Array;
data_header[33][0] = "Rank Category"
data_header[33][1] = "data";
data_header[33][2] = 0;
data_header[33][3] = "rankCategoryId"

	data_header[34] = new Array;
data_header[34][0] = "Employee Photo"
data_header[34][1] = "hide";
data_header[34][2] = 0;
data_header[34][3] = "photo"


data_header[35] = new Array;
data_header[35][0] = "Status"
data_header[35][1] = "data";
data_header[35][2] = 0;
data_header[35][3] = "<%=STATUS %>"
	 
data_header[36] = new Array;
data_header[36][0] = "Hospital"
data_header[36][1] = "hide";
data_header[36][2] = 0;
data_header[36][3] = "<%=HOSPITAL_ID%>"

	data_header[37] = new Array;
data_header[37][0] = "Hospital"
data_header[37][1] = "hide";
data_header[37][2] = 0;
data_header[37][3] = "<%=HIGH_VALUE_DRUG%>"



	data_header[38] = new Array;
	data_header[38][0] = "hiddenLocalAddress"
	data_header[38][1] = "hide";
	data_header[38][2] = 0;
	data_header[38][3] = "hiddenLocalAddress"
		 
	
	

		data_header[39] = new Array;
		data_header[39][0] = "hiddenLocalCountry"
		data_header[39][1] = "hide";
		data_header[39][2] = 0;
		data_header[39][3] = "hiddenLocalCountry"
			 
		

			data_header[40] = new Array;
			data_header[40][0] = "hiddenLocalState"
			data_header[40][1] = "hide";
			data_header[40][2] = 0;
			data_header[40][3] = "hiddenLocalState"
				 
			
			

				data_header[41] = new Array;
				data_header[41][0] = "hiddenLocalDistrict"
				data_header[41][1] = "hide";
				data_header[41][2] = 0;
				data_header[41][3] = "hiddenLocalDistrict"
					 
				

					data_header[42] = new Array;
					data_header[42][0] = "contract"
					data_header[42][1] = "hide";
					data_header[42][2] = 0;
					data_header[42][3] = "contract"
					

						data_header[43] = new Array;
						data_header[43][0] = "remarks"
						data_header[43][1] = "hide";
						data_header[43][2] = 0;
						data_header[43][3] = "remarks"
						
						
							data_header[44] = new Array;
						data_header[44][0] = "extension"
						data_header[44][1] = "hide";
						data_header[44][2] = 0;
						data_header[44][3] = "extension"
						
							data_header[45] = new Array;
						data_header[45][0] = "pfNo"
						data_header[45][1] = "hide";
						data_header[45][2] = 0;
						data_header[45][3] = "pfNo"
							 
						

							data_header[46] = new Array;
							data_header[46][0] = "panNo"
							data_header[46][1] = "hide";
							data_header[46][2] = 0;
							data_header[46][3] = "panNo"
							

								data_header[47] = new Array;
								data_header[47][0] = "accountNo"
								data_header[47][1] = "hide";
								data_header[47][2] = 0;
								data_header[47][3] = "accountNo"
								
								
									data_header[48] = new Array;
								data_header[48][0] = "bankName"
								data_header[48][1] = "hide";
								data_header[48][2] = 0;
								data_header[48][3] = "bankName"

data_arr = new Array();

<%
	int  counter=0;
	int  cnt=0;
	for (MasEmployee masEmp : searchEmployeeList) {
		
			++cnt;
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masEmp.getId()%>"
	data_arr[<%= counter%>][1] = '<%=masEmp.getServiceNo()!=null ? masEmp.getServiceNo(): "" %>'

	
	<%
	 if(masEmp.getGrade() != null){
	 %>
	<%
			for(MasGrade masGrade : gradeList){
				if(masEmp.getGrade().getId().equals(masGrade.getId()) && masGrade.getStatus().equals("y")){
				 %>
					data_arr[<%= counter%>][2] = "<%=masGrade.getId()%>"
				<%}else if(masEmp.getGrade().getId().equals(masGrade.getId()) && masGrade.getStatus().equals("n")){%>
					data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masGrade.getId()%>";
					
				<%}
			}
	}else {%>
	data_arr[<%= counter%>][2] = "";
	<%}%>
	data_arr[<%= counter%>][3] = "<%=masEmp.getHalJoinDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masEmp.getHalJoinDate()): ""%>";

data_arr[<%= counter%>][4] = '<%=masEmp.getCurrentDivisionJoinDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masEmp.getCurrentDivisionJoinDate()): ""%>'


	<%if(masEmp.getTitle() != null){
			Iterator itrTitleList=titleList.iterator();
			 while(itrTitleList.hasNext())
	            {
	             MasTitle  masTitleGrid = (MasTitle)itrTitleList.next(); 
				 if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][5] = "<%=masTitleGrid.getTitleName()%>"
				<%}else if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=masTitleGrid.getTitleName()%>";
					
				<%}
	}
	}else{%>
	data_arr[<%= counter%>][5] = ""
	<%}%>
	
	<%

	String firstName=masEmp.getFirstName()!=null ? masEmp.getFirstName():"";
	firstName = firstName.replace("\r", "$");
	firstName = firstName.replace("\n", "^");

	%>

	var firstName = "<% out.print(firstName); %>";		
	firstName = firstName.split('$').join("\r");
	firstName = firstName.split('^').join("\n");	  
	  
	data_arr[<%= counter%>][6] = firstName;
		
	
	
		
		
data_arr[<%= counter%>][7] = '<%=masEmp.getMiddleName()!=null ? masEmp.getMiddleName(): ""%>'
data_arr[<%= counter%>][8] = '<%=masEmp.getLastName()!=null ? masEmp.getLastName(): ""%>'


	<%if(masEmp.getDivision() != null){
		Iterator itrDivisionList=divisionList.iterator();
		 while(itrDivisionList.hasNext())
	        {
	         MasDivision  masDivisionGrid = (MasDivision)itrDivisionList.next(); 
			 if(masEmp.getDivision().getId().equals(masDivisionGrid.getId()) && masDivisionGrid.getStatus().equalsIgnoreCase("y")){%>
				data_arr[<%= counter%>][9] = "<%=masDivisionGrid.getDivisionName().trim()%>"
			<%}else if(masEmp.getDivision().getId().equals(masDivisionGrid.getId()) && masDivisionGrid.getStatus().equalsIgnoreCase("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=masDivisionGrid.getDivisionName().trim()%>";
				
			<%}
	}
	}else{%>
	data_arr[<%= counter%>][9] = ""
	<%}%>
	

	<% if(masEmp.getDepartment() != null){

			Iterator itrDepartmentList=departmentList.iterator();
			 while(itrDepartmentList.hasNext())
	            {
	             MasDepartment  masDepartmentGrid = (MasDepartment)itrDepartmentList.next(); 
				 if(masEmp.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][10] = "<%=masDepartmentGrid.getId()%>"
				<%}else if(masEmp.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masDepartmentGrid.getId()%>";
						
				<%}
	            }
	}else{%>
	  data_arr[<%= counter%>][10]=""
	<%}%>
		
	data_arr[<%= counter%>][11] = '<%=masEmp.getDateOfBirth()!=null ? HMSUtil.convertDateToStringWithoutTime(masEmp.getDateOfBirth()): ""%>'
			
			<%if(masEmp.getEmployeeType() != null){
				Iterator itrEmployeeList=employeeTypeList.iterator();
				 while(itrEmployeeList.hasNext())
			        {
			         MasEmployeeType  masEmployeeTypeGrid = (MasEmployeeType)itrEmployeeList.next(); 
					 if(masEmp.getEmployeeType().getId().equals(masEmployeeTypeGrid.getId()) && masEmployeeTypeGrid.getStatus().equals("y")){%>
						data_arr[<%= counter%>][12] = "<%=masEmployeeTypeGrid.getEmployeeTypeName()%>"
					<%}else if(masEmp.getEmployeeType().getId().equals(masEmployeeTypeGrid.getId()) && masEmployeeTypeGrid.getStatus().equals("n")){%>
						data_arr[<%= counter%>][12] = "<font id='error'>*</font>Parent InActivated--<%=masEmployeeTypeGrid.getEmployeeTypeName()%>";
						
					<%}
			}
			}else{%>
			data_arr[<%= counter%>][12] = ""
			<%}%>
data_arr[<%= counter%>][13] = '<%=masEmp.getDepartmentNo()!=null ? masEmp.getDepartmentNo(): ""%>'
data_arr[<%= counter%>][14] = '<%=masEmp.getAadharCard()!=null ? masEmp.getAadharCard(): ""%>'

	<%	if(masEmp.getEmpCategory() != null){
	%>
	<%
			for(MasEmpCategory masEmpCategory : empCategoryList){
				if(masEmp.getEmpCategory().getId().equals(masEmpCategory.getId()) && masEmpCategory.getStatus().equals("y")){
				 %>
					data_arr[<%= counter%>][15] = "<%=masEmpCategory.getEmpCategoryName()%>"
				<%}else if(masEmp.getEmpCategory().getId().equals(masEmpCategory.getId()) && masEmpCategory.getStatus().equals("n")){%>
					data_arr[<%= counter%>][15] = "<font id='error'>*</font>Parent InActivated--<%=masEmpCategory.getEmpCategoryName()%>";
					
				<%}
	            }
	}else {%>
	data_arr[<%= counter%>][15] = ""
	<%}%>
	

	 <%if(masEmp.getRank() != null){
	 %>
		<%
				for(MasRank masRank : rankList){
					if(masEmp.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("y")){
					 %>
						data_arr[<%= counter%>][16] = "<%=masRank.getRankName()%>"
					<%}else if(masEmp.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("n")){%>
						data_arr[<%= counter%>][16] = "<font id='error'>*</font>Parent InActivated--<%=masRank.getRankName()%>";
						
					<%}
				}
		}else {%>
		data_arr[<%= counter%>][16] = ""
		<%} 
		if(masEmp.getBloodGroup() != null){
		%>
		<%
				for(MasBloodGroup masBloodGroup : bloodGroupList){
		            if(masEmp.getBloodGroup() != null){
					if(masEmp.getBloodGroup().getId().equals(masBloodGroup.getId()) && masBloodGroup.getStatus().equals("y")){
					 %>
						data_arr[<%= counter%>][17] = "<%=masBloodGroup.getBloodGroupName()%>"
					<%}else if(masEmp.getBloodGroup().getId().equals(masBloodGroup.getId()) && masBloodGroup.getStatus().equals("n")){%>
						data_arr[<%= counter%>][17] = "<font id='error'>*</font>Parent InActivated--<%=masBloodGroup.getBloodGroupName()%>";
						
					<%}
		            }
				}
		} else {%>
		data_arr[<%= counter%>][17] = ""
		<%}%>
		
		<%
		if(masEmp.getGender() != null){
		%>
		<%
				for(MasAdministrativeSex administrativeSex : sexList){
		            if(masEmp.getGender() != null){
					if(masEmp.getGender().getId().equals(administrativeSex.getId()) && administrativeSex.getStatus().equals("y")){
					 %>
						data_arr[<%= counter%>][18] = "<%=administrativeSex.getAdministrativeSexName()%>"
					<%}else if(masEmp.getGender().getId().equals(administrativeSex.getId()) && administrativeSex.getStatus().equals("n")){%>
						data_arr[<%= counter%>][18] = "<font id='error'>*</font>Parent InActivated--<%=administrativeSex.getAdministrativeSexName()%>";
						
					<%}
		            }
				}
		} else {%>
		data_arr[<%= counter%>][18] = ""
		<%}%>

	
		
data_arr[<%= counter%>][19] = '<%=masEmp.getCellNoEmergency()!=null ? masEmp.getCellNoEmergency(): ""%>'
data_arr[<%= counter%>][20] = '<%=masEmp.getTelNoOffice()!=null ? masEmp.getTelNoOffice(): "" %>'
		<%
		
		String localAddress=masEmp.getLocalAddress()!=null ? masEmp.getLocalAddress().trim():"";
		
		localAddress = localAddress.replace("\r", "$");
		localAddress = localAddress.replace("\n", "^"); 
		/* localAddress = decodeURIComponent(localAddress); */
		
		%>
	
		<%-- var str_local = decodeURIComponent('<%=localAddress%>');	 --%>
		var str_local = "<% out.print(localAddress); %>";
		 str_local = str_local.split('$').join("\r");
		str_local = str_local.split('^').join("\n");	
		str_local = decodeURIComponent(str_local);	
		  
		data_arr[<%= counter%>][21] = str_local;


		
	<%
	if(masEmp.getLocalCountry() != null){

			Iterator itrCountryList=countryList.iterator();
			 while(itrCountryList.hasNext())
	            {
	             MasCountry  c = (MasCountry)itrCountryList.next(); 
	             if(masEmp.getLocalCountry().getId().equals(c.getId()) && c.getStatus().equals("y")){%>
					data_arr[<%= counter%>][22] = "<%=c.getCountryName()%>"
				<%}else if(masEmp.getLocalCountry().getId().equals(c.getId()) && c.getStatus().equals("n")){%>
					data_arr[<%= counter%>][22] = "<font id='error'>*</font>Parent InActivated--<%=c.getCountryName()%>";
					
				<%}
	            }
	} else {%>
	  data_arr[<%= counter%>][22] = "";
	<%} %>

<%
if(masEmp.getLocalState() != null){

	Iterator itrStateList=stateList.iterator();
	 while(itrStateList.hasNext())
        {
         MasState  s = (MasState)itrStateList.next(); 
         if(masEmp.getLocalState().getId().equals(s.getId()) && s.getStatus().equals("y")){%>
			data_arr[<%= counter%>][23] = "<%=s.getStateName()%>"
		<%}else if(masEmp.getLocalState().getId().equals(s.getId()) && s.getStatus().equals("n")){%>
			data_arr[<%= counter%>][23] = "<font id='error'>*</font>Parent InActivated--<%=s.getStateName()%>";
			
		<%}
        }
} else {%>
data_arr[<%= counter%>][23] = "";
<%} %>


<%
if(masEmp.getLocalDistrict() != null){

	Iterator itrDistrictList=districtList.iterator();
	 while(itrDistrictList.hasNext())
        {
         MasDistrict  d = (MasDistrict)itrDistrictList.next(); 
         if(masEmp.getLocalDistrict().getId().equals(d.getId()) && d.getStatus().equals("y")){%>
			data_arr[<%= counter%>][24] = "<%=d.getDistrictName()%>"
		<%}else if(masEmp.getLocalDistrict().getId().equals(d.getId()) && d.getStatus().equals("n")){%>
			data_arr[<%= counter%>][24] = "<font id='error'>*</font>Parent InActivated--<%=d.getDistrictName()%>";
			
		<%}
        }
} else {%>
data_arr[<%= counter%>][24] = "";
<%} %>

<%

String permanentAddress=masEmp.getPerAddress()!=null ? masEmp.getPerAddress().trim():"";
permanentAddress = permanentAddress.replace("\r", "$");
permanentAddress = permanentAddress.replace("\n", "^"); 

%>

 var str_permanent = "<% out.print(permanentAddress); %>";		
str_permanent = str_permanent.split('$').join("\r");
str_permanent = str_permanent.split('^').join("\n"); 
str_permanent = decodeURIComponent(str_permanent);	

<%-- var str_permanent = decodeURIComponent('<%=permanentAddress%>'); --%>
  
data_arr[<%= counter%>][25] = str_permanent;
	
			
			
			
			
			
		
		<%
		if(masEmp.getPerCountry() != null){

				Iterator itrCountryList=countryList.iterator();
				 while(itrCountryList.hasNext())
		            {
		             MasCountry  c = (MasCountry)itrCountryList.next(); 
		             if(masEmp.getPerCountry().getId().equals(c.getId()) && c.getStatus().equals("y")){%>
						data_arr[<%= counter%>][26] = "<%=c.getCountryName()%>"
					<%}else if(masEmp.getPerCountry().getId().equals(c.getId()) && c.getStatus().equals("n")){%>
						data_arr[<%= counter%>][26] = "<font id='error'>*</font>Parent InActivated--<%=c.getCountryName()%>";
						
					<%}
		            }
		} else {%>
		  data_arr[<%= counter%>][26] = "";
		<%} %>

	<%
	if(masEmp.getPerState() != null){

		Iterator itrStateList=stateList.iterator();
		 while(itrStateList.hasNext())
	        {
	         MasState  s = (MasState)itrStateList.next(); 
	         if(masEmp.getPerState().getId().equals(s.getId()) && s.getStatus().equals("y")){%>
				data_arr[<%= counter%>][27] = "<%=s.getStateName()%>"
			<%}else if(masEmp.getPerState().getId().equals(s.getId()) && s.getStatus().equals("n")){%>
				data_arr[<%= counter%>][27] = "<font id='error'>*</font>Parent InActivated--<%=s.getStateName()%>";
				
			<%}
	        }
	} else {%>
	data_arr[<%= counter%>][27] = "";
	<%} %>


	<%
	if(masEmp.getPerDistrict() != null){

		Iterator itrDistrictList=districtList.iterator();
		 while(itrDistrictList.hasNext())
	        {
	         MasDistrict  d = (MasDistrict)itrDistrictList.next(); 
	         if(masEmp.getPerDistrict().getId().equals(d.getId()) && d.getStatus().equals("y")){%>
				data_arr[<%= counter%>][28] = "<%=d.getDistrictName()%>"
			<%}else if(masEmp.getPerDistrict().getId().equals(d.getId()) && d.getStatus().equals("n")){%>
				data_arr[<%= counter%>][28] = "<font id='error'>*</font>Parent InActivated--<%=d.getDistrictName()%>";
				
			<%}
	        }
	} else {%>
	data_arr[<%= counter%>][28] = "";
	<%} %>
			
			
			
	<%
	if(masEmp.getEmployeeStatus() != null){

			Iterator itrEmpStatusList=empStatusList.iterator();
			 while(itrEmpStatusList.hasNext())
	            {
	             MasEmpStatus  masEmpStatusGrid = (MasEmpStatus)itrEmpStatusList.next(); 
	             if(masEmp.getEmployeeStatus().getId().equals(masEmpStatusGrid.getId()) && masEmpStatusGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][29] = "<%=masEmpStatusGrid.getEmpStatusName()%>"
				<%}else if(masEmp.getEmployeeStatus().getId().equals(masEmpStatusGrid.getId()) && masEmpStatusGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][29] = "<font id='error'>*</font>Parent InActivated--<%=masEmpStatusGrid.getEmpStatusName()%>";
					
				<%}
	            }
	} else {%>
	  data_arr[<%= counter%>][29] = "";
	<%} %>


data_arr[<%= counter%>][30] = '<%=masEmp.getEmail()!=null ? masEmp.getEmail(): ""%>'
data_arr[<%= counter%>][31] = '<%=masEmp.getLastChgBy()!=null ? masEmp.getLastChgBy(): "" %>'
data_arr[<%= counter%>][32] = '<%=masEmp.getLastChgDate()!=null ? masEmp.getLastChgDate(): "" %>'		
data_arr[<%= counter%>][33] = '<%=masEmp.getLastChgTime()!=null ? masEmp.getLastChgTime(): "" %>'	

	<%if(masEmp.getRankCategory() != null){
		%>
		<%
				for(MasRankCategory masRankCategory : rankCategoryList){
					if(masEmp.getRankCategory().getId().equals(masRankCategory.getId()) && masRankCategory.getStatus().equals("y")){
					 %>
						data_arr[<%= counter%>][34] = "<%=masRankCategory.getRankCategoryName()%>"
					<%}else if(masEmp.getRankCategory().getId().equals(masRankCategory.getId()) && masRankCategory.getStatus().equals("n")){%>
						data_arr[<%= counter%>][34] = "<font id='error'>*</font>Parent InActivated--<%=masRankCategory.getRankCategoryName()%>";
						
					<%}
				}
		}else {%>
		data_arr[<%= counter%>][34] = "";
		<%}%>
		

	<%
	
	if(uploadDocuments.size()>0){
		for(UploadDocuments uploadDocs :uploadDocuments){
		
			if(uploadDocs.getEmployee()!=null)
			{%>
				
			data_arr[<%= counter%>][35] = '-----------';
			<%}
			}}	%>
	
		


	<% if(masEmp.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][36] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][36] = "InActive"
	<%}%>
	
	<%
	if(masEmp.getHospital() != null){

			Iterator itrHospitalList=hospitalList.iterator();
			 while(itrHospitalList.hasNext())
	            {
	             MasHospital  masHospitalGrid = (MasHospital)itrHospitalList.next(); 
	             if(masEmp.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equals("y")){%>
					data_arr[<%= counter%>][37] = "<%=masHospitalGrid.getHospitalName()%>"
				<%}else if(masEmp.getHospital().getId().equals(masHospitalGrid.getId()) && masHospitalGrid.getStatus().equals("n")){%>
					data_arr[<%= counter%>][37] = "<font id='error'>*</font>Parent InActivated--<%=masHospitalGrid.getHospitalName()%>";
					
				<%}
	            }
	} else {%>
	  data_arr[<%= counter%>][37] = "";
	<%} 
	
	
	
	%>
	 <%
  	if("y".equalsIgnoreCase(masEmp.getAuthorizedForHighValueMedicine())){ %> 
		data_arr[<%= counter%>][38] ="y" 
		<%}else{ %>
		data_arr[<%= counter%>][38] ="n" 
		<%}%>
		data_arr[<%= counter%>][39] = str_permanent;

			data_arr[<%= counter%>][40] = '<%=masEmp.getPerCountry()!=null ? masEmp.getPerCountry().getId(): "0" %>'

				data_arr[<%= counter%>][41] = '<%=masEmp.getPerState()!=null ? masEmp.getPerState().getId(): "0" %>'

					data_arr[<%= counter%>][42] = '<%=masEmp.getPerDistrict()!=null ? masEmp.getPerDistrict().getId(): "0"%>'
							
						
							data_arr[<%= counter%>][43] = "<%=masEmp.getContractDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masEmp.getContractDate()): ""%>";
								
							data_arr[<%= counter%>][44] = '<%=masEmp.getRemarks()!=null ? masEmp.getRemarks(): ""%>'
								data_arr[<%= counter%>][45] = '<%=masEmp.getExtensionDate()!=null ? HMSUtil.convertDateToStringWithoutTime(masEmp.getExtensionDate()): ""%>';
								data_arr[<%= counter%>][46] = '<%=masEmp.getPFNo()!=null ? masEmp.getPFNo():""%>';
								 data_arr[<%= counter%>][47] = '<%=masEmp.getPANNo()!=null ? masEmp.getPANNo(): ""%>';
								data_arr[<%= counter%>][48] = '<%=masEmp.getAccountNo()!=null ? masEmp.getAccountNo(): ""%>';
								data_arr[<%= counter%>][49] = '<%=masEmp.getBankName()!=null ? masEmp.getBankName(): ""%>';
								
								
	<%
String loginName="";
String pwdd="";
if(masEmp.getUsers()!=null){
	Set<Users> userSet=new HashSet<Users>();
	userSet=masEmp.getUsers();
	if(userSet.size()>0){
		for(Users user:userSet){
			loginName=user.getLoginName();
			pwdd=user.getPassword();
		}
	}
}
%>





	
				
<%
		     counter++;
		
}
%>
		formName = "employee"
		
		nonEditable = ['<%= SERVICE_NO%>']
		 
		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
			
			
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');
</script>
<script language="javascript">

function jsImport()
{
	if (document.getElementById('fileNameId').value == "")
		
	{
	alert('Please select a file to Upload');
	return;
	}
	var fname = document.getElementById('fileNameId').value;
	var ind1 = fname.lastIndexOf("\\");
	var filename = fname.substring(ind1+1);
	document.getElementById("fileName").value=filename;
	document.getElementById("flag").value="y";
	document.employee.method="post";
		
}

</script>
<script>
function categorySelectDoctor(val){
	if(val=='8'){
	document.getElementById('doctorDiv').style.display='inline';
	}else{
		document.getElementById('doctorDiv').style.display='none';
	}
}

function getAddresschk(){
if(document.getElementById('addresschk').checked==true){
	if(document.getElementById('localAddress').value=='')
	{
			alert("Please  fill Local Address");
			document.getElementById('addresschk').checked=false;
			return false;
	}
	if(document.getElementById('localCountry').value=='0')
	{
			alert("Please  fill Local Country");
			document.getElementById('addresschk').checked=false;
			return false;
	}

	if(document.getElementById('localState').value=='0')
	{
			alert("Please  fill Local State");
			document.getElementById('addresschk').checked=false;
			return false;
	}
	if(document.getElementById('localDistrict').value=='0')
	{
			alert("Please  fill Local District");
			document.getElementById('addresschk').checked=false;
			return false;
	}
	else
	{
		document.getElementById('perAddress').value=document.getElementById('localAddress').value;
		if(document.getElementById('localCountry').value!='0'){
			document.getElementById('perCountry').value=document.getElementById('localCountry').value;
		}
		if(document.getElementById('localState').value!='0'){
			document.getElementById('perState').value=document.getElementById('localState').value;
		}
		if(document.getElementById('localDistrict').value!='0'){
			document.getElementById('perDistrict').value=document.getElementById('localDistrict').value;
		}
		document.getElementById('addresschk').checked=true;
		document.getElementById('perAddress').readOnly=true;
		document.getElementById('perCountry').readOnly=true;
		document.getElementById('perState').readOnly=true;
		document.getElementById('perDistrict').readOnly=true;
		return true;
	}
}
if(document.getElementById('addresschk').checked==false)
{
	
	
	document.getElementById('addresschk').checked=false;
	document.getElementById('perAddress').readOnly=false;
	document.getElementById('perCountry').readOnly=false;
	document.getElementById('perState').readOnly=false;
	document.getElementById('perDistrict').readOnly=false;
	
	if(document.getElementById('hiddenLocalAddress').value!=''){
		document.getElementById('perAddress').value=document.getElementById('hiddenLocalAddress').value;
	}else{
		document.getElementById('perAddress').value='';
	}
	if(document.getElementById('hiddenLocalCountry').value!=''){
		document.getElementById('perCountry').value=document.getElementById('hiddenLocalCountry').value;
	}else{
		
		document.getElementById('perCountry').value=0;
	}
	if(document.getElementById('hiddenLocalState').value!=''){
		document.getElementById('perState').value=document.getElementById('hiddenLocalState').value;
	}else{
		
		document.getElementById('perState').value=0;
	}
	if(document.getElementById('hiddenLocalDistrict').value!=''){
		document.getElementById('perDistrict').value=document.getElementById('hiddenLocalDistrict').value;
	}else{
		document.getElementById('perDistrict').value=0;
	}
	
	
	
	
}
return true;
}


function checkDateYear()
{
	var dob = document.getElementById('dob').value;
	var doj = document.getElementById('halJoiningDate').value;
	if(doj!="" && dob!=""){

	if(doj<dob){
			alert("Please Check Date of Joining");
			document.getElementById('halJoiningDate').value="";
			return false;
			}
			return true;
		}

	}
function checkDateBirthYear()
{
	var dob = document.getElementById('dob').value;
	var d = new Date();
	
	var dependentCardIssueDate = new Date(dob.substring(6),
			(dob.substring(3, 5) - 1), dob
					.substring(0, 2));
	if(dob!=""){
	if(d<dependentCardIssueDate){
			alert("Please Check Date of Birth");
			return false;
		}
	return true;
	}

	}
	function checkEmpPBNo(empNo){
	
	var empNo =trimAll(empNo);
	
	 var xmlHttp;
	  try {
	    // Firefox, Opera 8.0+, Safari
	    xmlHttp=new XMLHttpRequest();
	  }catch (e){
	    // Internet Explorer
	    try{
	      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
	    }catch (e){
	    	alert(e)
	      try{
	        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
	      }catch (e){
	        alert("Your browser does not support AJAX!");
	        return false;
	      }
	     }
	   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
      
      	var items =xmlHttp.responseXML.getElementsByTagName('items')[0];
		
      	for (loop = 0; loop < items.childNodes.length; loop++) {
	   	    var item = items.childNodes[loop];
	        var exists  = item.getElementsByTagName("exists")[0];
	          if(exists.childNodes[0].nodeValue =="yes"){
	        
	        	alert("Employee Id/PB No. already Exists");
	        	document.getElementById("serviceNo").value="";
	        	return true;
	        }
	   	} 
      }
    }
   var url="/hms/hms/personnel?method=checkEmpPBNo&empNo="+empNo;
     
    xmlHttp.open("GET",url,true);
    xmlHttp.setRequestHeader("Content-Type", "text/xml");
    xmlHttp.send(null);

}
</script>