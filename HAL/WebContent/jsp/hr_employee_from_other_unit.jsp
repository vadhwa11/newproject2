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
String personnelCode = "";
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
		
		if(mapEmployee.get("personnelCode")!=null && !mapEmployee.get("personnelCode").equals("")){
			personnelCode=(String)mapEmployee.get("personnelCode");
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
		
		if(mapEmployee.get("seqList") != null){
			seqList = (List<TransactionSequence>)mapEmployee.get("seqList");
			session.setAttribute("seqList", seqList);
		}else if(session.getAttribute("seqList") != null){
			seqList = (List<TransactionSequence>)session.getAttribute("seqList");
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
<h6>ADD TD Strength</h6>
<div class="Clear"></div>
<form name="employee" method="post" action=""
	onLoad="changeMandatoryField();">

<div class="blockTitle">Employee Details</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Employee
Code </label> <input id="codeId" type="text" name="<%= EMPLOYEE_CODE%>"
	value="<%=personnelCode%>" validate="Employee Code,string,yes"
	style="width: 50px" tabindex="1"/  > <script>
				document.employee.<%=EMPLOYEE_CODE%>.focus();
			</script> <label>PreFix</label> <input name="<%=PREFIX%>" style="width: 40px;"
	class="textbox_size20" tabindex="1" /> <label><span>*</span>
Service No. </label> <input type="text" name="<%= SERVICE_NO%>" value=""
	validate="Service No.,string,yes" style="width: 80px" MAXLENGTH="10"
	class="textbox_size20" tabindex="1"/  > <label><span>*</span>SuFFix</label>
<select id="suffixId" name="<%=SUFFIX%>" validate="Suffix,string,yes"
	tabindex="1" style="width: 40px;">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select>
<div class="Clear"></div>
<label><span>*</span> Service Type </label> <select id="serviceTypeId"
	name=<%=SERVICE_TYPE_ID %> validate="Service Type,string,yes"
	maxlength="8" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(serviceTypeList != null){ 	
				         			for (Iterator iter = serviceTypeList.iterator(); iter.hasNext();) {
				         				MasServiceType masServiceType = (MasServiceType) iter.next();
				         %>
	<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label><span>*</span> Rank </label> <select id="rankId"
	name="<%=RANK_ID %>" onchange="rankForOfficerfunction();"
	validate="Rank,string,yes" tabindex="1">
	<option value="0">Select</option>

	<%
				         		if(rankList != null){ 	
				         			for (Iterator iter = rankList.iterator(); iter.hasNext();) {
				         				MasRank masRank = (MasRank) iter.next();
				         %>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <label>Title </label> <select id="titleId" name="<%=TITLE_ID %>"
	tabindex="1">
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

<label><span>*</span> First Name</label> <input type="text"
	name="<%=FIRST_NAME %>" value="" validate="First Name,name,yes"
	MAXLENGTH="25" / tabindex="1"> <label>Middle Name</label> <input
	type="text" name="<%=MIDDLE_NAME%>" value=""
	validate="Middle Name,name,no" MAXLENGTH="15" tabindex="1" /> <label><span>*</span>
Last Name</label> <input type="text" name="<%=LAST_NAME %>" value=""
	validate="Last Name,name,yes" MAXLENGTH="15" tabindex="1" />



<div class="Clear"></div>


<label><span>*</span> Category </label> <select id="employeeCategoryId"
	name="<%=EMPLOYEE_CATEGORY_ID %>" validate="Category,string,yes"
	tabindex="1">
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
</select> <label>Grade</label> <select id="gradeId"
	name="<%=EMPLOYEE_GRADE_ID %>" tabindex="1">
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
</select> <label><span>*</span> Trade</label> <select id="unitId"
	name="<%=TRADE_ID %>" tabindex="1" validate="Trade,string,yes">
	<option value="0">Select</option>

	<%
				         		if(tradeList != null){ 	
				         			for (Iterator iter = tradeList.iterator(); iter.hasNext();) {
				         				MasTrade masTrade = (MasTrade) iter.next();
				         %>
	<option value="<%=masTrade.getId() %>"><%=masTrade.getTradeName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select>


<div class="Clear"></div>



<label><span>*</span> Present Unit </label> <select
	style="text-align: left; width: 105px;" "id="newUnitId"
	name="<%=POSTED_UNIT_ID %>" tabindex="1"
	validate="Present Unit,string,yes">
	<option value="0">Select</option>
	<%
				         		if(unitList != null){ 	
				         			for (Iterator iter = unitList.iterator(); iter.hasNext();) {
				         				MasUnit masUnit = (MasUnit) iter.next();
				         %>
	<option value="<%=masUnit.getId() %>"><%=masUnit.getUnitName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> <img class="newUnitId" SRC="/hms/jsp/images/s_search.gif" WIDTH="26"
	HEIGHT="26" style="cursor: pointer;"
	validate="Present Unit ,string,yes"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Posted From"> <label><span
	id="spanDepartment" style="display: none">*</span> Department </label> <select
	id="departmentId" name="<%=DEPARTMENT_ID %>" tabindex="1">
	<option value="0">Select</option>

	<%
			           		if(departmentList != null){ 	
			           			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
			           				MasDepartment masDepartment = (MasDepartment) iter.next();
			           %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
			          			}
			          		 } 
			          %>
</select></div>
</form>
<div class="Clear"></div>
<div class="division"></div>
<div class="bottom"><input type="button" class="cmnButton"
	name="add" id="add" value="Add"
	onClick="submitForm('employee','hrOrderly?method=addPersonnelFromOtherUnitJsp');"
	accesskey="a" /> <input type="button" class="cmnButton" name="Update"
	id="Update" value="Update"
	onClick="window.open('hrOrderly?method=searchOtherPerson');"
	accesskey="u" /> <input type="button" class="cmnButton" name="Close"
	id="Close" value="Close" onClick="window.close();" accesskey="d" /> <input
	type="reset" class="cmnButton" name="Reset" id="reset" value="Reset"
	onclick="location.reload();" accesskey="r" /></div>
</div>


