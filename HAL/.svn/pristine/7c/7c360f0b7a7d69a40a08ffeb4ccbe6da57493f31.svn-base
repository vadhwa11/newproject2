<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MovementInOtherPerson"%>
<%@page import="jkt.hms.masters.business.MasEmpStatus"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.TransactionSequence"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchcontent.js"></script>
<script type="text/javascript" src="/hms/jsp/js/switchicon.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="/hms/jsp/js/phase2/jquery-1.2.2.pack.js"></script>
<script type="text/javascript"
	src="/hms/jsp/js/phase2/animatedcollapse.js"></script>
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
	function openPopupWindowForUnit()
	{
	 var url="/hms/hms/adt?method=showUnitSearchJsp";
	 newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
	}
	function jsSetUnitData(unitId,unitAddress)
	{
	 for(var i=0;i<document.getElementById("newUnitId").length;i++)
	 {
		 if (document.getElementById("newUnitId").options[i].value==unitId)
		 {
		 	document.getElementById("newUnitId").selectedIndex = i;
		 }
	 }
	
	}	
</script>
<%
int personelId = 0;
Map map = new HashMap();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}
		Map<String,Object> mapEmployee = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			mapEmployee = (Map<String,Object>) request.getAttribute("map");
		}
		
		List<MasTitle> titleList = new ArrayList<MasTitle>();
		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<MasEmpStatus> empStatusList = new ArrayList<MasEmpStatus>();
		List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
		List<MasGrade> gradeList = new ArrayList<MasGrade>();
		List<MasUnit> unitList = new ArrayList<MasUnit>();
		List<MasRank> rankList = new ArrayList<MasRank>();
		List<MasTrade> tradeList = new ArrayList<MasTrade>();
		List<TransactionSequence> seqList = new ArrayList<TransactionSequence>();
		List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
		List<MovementInOtherPerson> movementinotherpersonList = new ArrayList<MovementInOtherPerson>();
		
		if(mapEmployee.get("movementinotherpersonList")!=null && !mapEmployee.get("movementinotherpersonList").equals("")){
			movementinotherpersonList=(List<MovementInOtherPerson>)mapEmployee.get("movementinotherpersonList");
		}
		if(mapEmployee.get("personelId")!=null && !mapEmployee.get("personelId").equals("")){
			personelId=(Integer)mapEmployee.get("personelId");
		}
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
		
		if(mapEmployee.get("unitList") != null){
			unitList = (List<MasUnit>)mapEmployee.get("unitList");
			session.setAttribute("unitList", unitList);
		}else if(session.getAttribute("unitList") != null){
			unitList = (List<MasUnit>)session.getAttribute("unitList");
		}
		if(mapEmployee.get("rankList") != null){
			rankList = (List<MasRank>)mapEmployee.get("rankList");
			session.setAttribute("rankList", rankList);
		}else if(session.getAttribute("rankList") != null){
			rankList = (List<MasRank>)session.getAttribute("rankList");
		}
		
		if(mapEmployee.get("tradeList") != null){
			tradeList = (List<MasTrade>)mapEmployee.get("tradeList");
			session.setAttribute("tradeList", tradeList);
		}else if(session.getAttribute("tradeList") != null){
			tradeList = (List<MasTrade>)session.getAttribute("tradeList");
		}
		if(mapEmployee.get("serviceTypeList") != null){
			serviceTypeList = (List<MasServiceType>)mapEmployee.get("serviceTypeList");
			session.setAttribute("serviceTypeList", serviceTypeList);
		}else if(session.getAttribute("serviceTypeList") != null){
			serviceTypeList = (List<MasServiceType>)session.getAttribute("serviceTypeList");
		}
		
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map<String,Object>)HMSUtil.getCurrentDateAndTime();
		
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
				
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message = "";
		if(mapEmployee.get("message") != null){
			message =(String)mapEmployee.get("message");
			   out.println(message);
			 }
		
			ArrayList chafbUnitList = new ArrayList();
			if(mapEmployee.get("chafbUnitList") != null){
			chafbUnitList = (ArrayList)mapEmployee.get("chafbUnitList");
		}	
		
			
			
%>

<div id="contentspace">
<h1 style="font-size: 15px; color: red;"><%=message %></h1>
</div>

<div id="contentHolder">
<h6>Update For TD Employee</h6>
<div class="Clear"></div>
<form name="employee" method="post" action=""
	onLoad="changeMandatoryField();">

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<%if(movementinotherpersonList!=null && movementinotherpersonList.size()>0){
  		MovementInOtherPerson movementinotherperson =movementinotherpersonList.get(0);	
  		%> <label><span>*</span> Employee Code </label> <%if(movementinotherperson.getEmployeeCode()!=null){ %>
<input id="codeId" type="text" name="<%= EMPLOYEE_CODE%>"
	value="<%=movementinotherperson.getEmployeeCode()%>"
	validate="Employee Code,string,yes" readonly="readonly"
	style="width: 50px" tabindex="1"/  > <%} %> <script>
				document.employee.<%=EMPLOYEE_CODE%>.focus();
			</script> <label>PreFix</label> <%if(movementinotherperson.getPrefix()!=null){ %>
<input name="<%=PREFIX%>" style="width: 40px;"
	value="<%=movementinotherperson.getPrefix() %>" class="textbox_size20"
	tabindex="1" /> <%}else{ %> <input name="<%=PREFIX%>"
	style="width: 40px;" value="" class="textbox_size20" tabindex="1" /> <%} %>
<label><span>*</span> Service No. </label> <%if(movementinotherperson.getServiceNo()!=null){ %>
<input type="text" name="<%= SERVICE_NO%>"
	value="<%=movementinotherperson.getServiceNo() %>" readonly="readonly"
	validate="Service No.,string,yes" style="width: 80px" MAXLENGTH="10"
	class="textbox_size20" tabindex="1"/  > <%} %> <label><span>*</span>SuFFix</label>
<%if(movementinotherperson.getSuffix()!=null ){ %> <select id="suffixId"
	name="<%=SUFFIX%>" validate="Suffix,string,yes" tabindex="1"
	style="width: 40px;">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
			if(movementinotherperson.getSuffix().equals(String.valueOf(i))){	
			
		%>
	<option value="<%=i%>" selected="selected"><%=i%></option>
	<%}else{ %>
	<option value="<%=i%>"><%=i%></option>
	<%}} %>
	<option value="-">-</option>
</select> <%} %>
<div class="Clear"></div>
<label><span>*</span> Service Type </label> <%if(movementinotherperson.getServiceType()!=null ){  %>
<select id="serviceTypeId" name=<%=SERVICE_TYPE_ID %>
	validate="Service Type,string,yes" maxlength="8" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(serviceTypeList != null){ 	
				         			for (Iterator iter = serviceTypeList.iterator(); iter.hasNext();) {
				         				MasServiceType masServiceType = (MasServiceType) iter.next();
				         				if(movementinotherperson.getServiceType().getId().equals(masServiceType.getId())){
				         %>
	<option value="<%=masServiceType.getId() %>" selected="selected"><%=masServiceType.getServiceTypeName() %></option>
	<%}else{ %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%}		
				        			}
				        		 } 
				        %>
</select> <%} %> <label><span>*</span> Rank </label> <%if(movementinotherperson.getRank()!=null ){  %>
<select id="rankId" name="<%=RANK_ID %>"
	onchange="rankForOfficerfunction();" validate="Rank,string,yes"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         				if(movementinotherperson.getRank().getId().equals(masRank.getId())){
				         %>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName() %></option>
	<%}else{ %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}		
				        			}
				        		 } 
				        %>
</select> <%} %> <label>Title </label> <select id="titleId" name="<%=TITLE_ID %>"
	tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(titleList != null){ 	
				         			for (Iterator iter = titleList.iterator(); iter.hasNext();) {
				         				MasTitle masTitle = (MasTitle) iter.next();
				         				if(movementinotherperson.getTitle()!=null ){
				         				if(movementinotherperson.getTitle().getId().equals(masTitle.getId())){
				         %>
	<option value="<%=masTitle.getId() %>" selected="selected"><%=masTitle.getTitleName() %></option>
	<%}else{ %>
	<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>
	<%}}else{%>
	<option value="<%=masTitle.getId() %>"><%=masTitle.getTitleName() %></option>
	<%}}} %>

</select>


<div class="Clear"></div>

<label><span>*</span> First Name</label> <input type="text"
	name="<%=FIRST_NAME %>"
	value="<%=movementinotherperson.getFirstName() %>"
	validate="First Name,name,yes" MAXLENGTH="25" / tabindex="1"> <label>Middle
Name</label> <%if(movementinotherperson.getMiddleName()!=null){ %> <input
	type="text" name="<%=MIDDLE_NAME%>"
	value="<%=movementinotherperson.getMiddleName() %>"
	validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" /> <%}else{ %>
<input type="text" name="<%=MIDDLE_NAME%>" value=""
	validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" /> <%} %> <label><span>*</span>
Last Name</label> <input type="text" name="<%=LAST_NAME %>"
	value="<%=movementinotherperson.getLastName() %>"
	validate="Last Name,name,yes" MAXLENGTH="15" tabindex="1" />



<div class="Clear"></div>


<label><span>*</span> Category </label> <% if(movementinotherperson.getCategory()!=null ){ %>
<select id="employeeCategoryId" name="<%=EMPLOYEE_CATEGORY_ID %>"
	validate="Category,string,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(empCategoryList != null){ 	
				         			for (Iterator iter = empCategoryList.iterator(); iter.hasNext();) {
				         				MasEmpCategory masEmpCategory = (MasEmpCategory) iter.next();
				         				if(movementinotherperson.getCategory().getId().equals(masEmpCategory.getId())){
				         %>
	<option value="<%=masEmpCategory.getId() %>" selected="selected"><%=masEmpCategory.getEmpCategoryName() %></option>
	<%}else{ %>
	<option value="<%=masEmpCategory.getId() %>"><%=masEmpCategory.getEmpCategoryName() %></option>
	<%}		
				        			}
				        		 } 
				        %>
</select> <%} %> <label>Grade</label> <% %> <select id="gradeId"
	name="<%=EMPLOYEE_GRADE_ID %>" tabindex="1">
	<option value="0">Select</option>

	<%          	
		           		if(gradeList != null){ 	
		           			for (Iterator iter = gradeList.iterator(); iter.hasNext();) {
		           				MasGrade masGrade = (MasGrade) iter.next();
		           				if(movementinotherperson.getGrade()!=null ){ 
		           				if(movementinotherperson.getGrade().getId().equals(masGrade.getId())){
		           %>
	<option value="<%=masGrade.getId() %>" selected="selected"><%=masGrade.getGradeName() %></option>
	<%}else{ %>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>
	<%}}else{%>
	<option value="<%=masGrade.getId() %>"><%=masGrade.getGradeName() %></option>
	<%}}} %>
</select> <label><span>*</span> Trade</label> <% if(movementinotherperson.getTrade()!=null ){ %>
<select id="unitId" name="<%=TRADE_ID %>" tabindex="1"
	validate="Trade,string,yes">
	<option value="0">Select</option>

	<%
				         		if(tradeList != null){ 	
				         			for (Iterator iter = tradeList.iterator(); iter.hasNext();) {
				         				MasTrade masTrade = (MasTrade) iter.next();
				         				if(movementinotherperson.getTrade().getId().equals(masTrade.getId())){
				         %>
	<option value="<%=masTrade.getId() %>" selected="selected"><%=masTrade.getTradeName() %></option>
	<%}else{ %>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%}		
				        			}
				        		 } 
				        %>
</select> <%} %>


<div class="Clear"></div>



<label><span>*</span> Present Unit </label> <% if(movementinotherperson.getPresentUnit()!=null ){ %>
<select style="text-align: left; width: 105px;" "id="newUnitId"
	name="<%=POSTED_UNIT_ID %>" tabindex="1"
	validate="Present Unit,string,yes">
	<option value="0">Select</option>
	<%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         				if(movementinotherperson.getPresentUnit().getId().equals(masUnit.getId())){
				         %>
	<option value="<%=masUnit.getId() %>" selected="selected"><%=masUnit.getUnitName() %></option>
	<%}else{ %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%}		
				        			}
				        		 } 
				        %>
</select> <%} %> <img class="newUnitId" SRC="/hms/jsp/images/s_search.gif"
	WIDTH="26" HEIGHT="26" style="cursor: pointer;"
	validate="Present Unit,string,yes"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From"> <label>
Department </label> <%  %> <select id="departmentId" name="<%=DEPARTMENT_ID %>"
	tabindex="1">
	<option value="0">Select</option>

	<%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           				if(movementinotherperson.getDepartment()!=null ){
			           				if(movementinotherperson.getDepartment().getId().equals(masDepartment.getId())){
			           %>
	<option value="<%=masDepartment.getId() %>" selected="selected"><%=masDepartment.getDepartmentName() %></option>
	<%}else{ %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}}else{%>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%}}} %>

</select> <%} %>
</div>
<input type="hidden" name="personelId" id="personelId"
	value="<%=personelId %>" /></form>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><input type="button" class="cmnButton"
	name="Update" id="Update" value="Update"
	onClick="submitForm('employee','hrOrderly?method=UpdatePersonFroOtherUnit');"
	accesskey="u" /> <input type="button" class="cmnButton" name="Close"
	id="Close" value="Close" onClick="window.close();" accesskey="d" /> <input
	type="reset" class="cmnButton" name="Reset" id="reset" value="Reset"
	onclick="location.reload();" accesskey="r" /></div>

</div>


