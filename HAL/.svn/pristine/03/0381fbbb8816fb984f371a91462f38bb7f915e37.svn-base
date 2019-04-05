<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasPool"%>
<%@page import="jkt.hms.masters.business.SmqVacation"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasTitle"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.MasEmpCategory"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder">
<form name="employeeUpdate" action="" method="post"><script
	type="text/javascript" language="javascript">
<%

Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String date=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(date.length()<2){
date="0"+date;
}
%>
serverdate = '<%=date+"/"+month+"/"+year%>'
</script> <%
Map<String, Object> utilMap = new HashMap<String, Object>();
Map<String, Object> detailsMap = new HashMap<String, Object>();
utilMap = (Map<String,Object>) HMSUtil.getCurrentDateAndTime();
String currentDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
date = (String) utilMap.get("currentDate");
String userName = "";
String message="";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}
int deptId =0;
if(session.getAttribute("deptId") != null){
	deptId = (Integer)session.getAttribute("deptId");
}
int hospitalId =0;
if(session.getAttribute("hospitalId") != null){
	hospitalId = (Integer)session.getAttribute("hospitalId");
}
Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
map = (Map<String, Object>)request.getAttribute("map");
}

if(map.get("detailsMap") !=null){
detailsMap=(Map<String, Object>)map.get("detailsMap");
}
if(map.get("message") !=null){
	message=(String)map.get("message");
}
List<MasRank> rankList = new ArrayList<MasRank>();
if(map.get("rankList") != null){
rankList = (List<MasRank>)map.get("rankList");
}
List<MasServiceType> serviceTypeList=  new ArrayList<MasServiceType>();
if(detailsMap.get("serviceTypeList") != null){
	serviceTypeList = (List<MasServiceType>)detailsMap.get("serviceTypeList");
	}
List<MasPool> poolList=  new ArrayList<MasPool>();
if(detailsMap.get("poolList") != null){
	poolList = (List<MasPool>)detailsMap.get("poolList");
	}
Map<String, Object> patientMap = new HashMap<String, Object>();
List<MasEmployee> searchEmployeeList = new ArrayList<MasEmployee>();

if(map.get("searchEmployeeList") != null){
	searchEmployeeList= (List<MasEmployee>)map.get("searchEmployeeList");
	}
List<MasTitle> titleList = new ArrayList<MasTitle>();
if(map.get("titleList") != null){
	titleList = (List<MasTitle>)map.get("titleList");
	session.setAttribute("titleList", titleList);
}else if(session.getAttribute("titleList") != null){
	titleList = (List<MasTitle>)session.getAttribute("titleList");
}
List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
if(map.get("departmentList") != null){
	departmentList = (List<MasDepartment>)map.get("departmentList");
	session.setAttribute("departmentList", departmentList);
}else if(session.getAttribute("departmentList") != null){
	departmentList = (List<MasDepartment>)session.getAttribute("departmentList");
}
List<MasEmpCategory> empCategoryList = new ArrayList<MasEmpCategory>();
if(map.get("empCategoryList") != null){
	empCategoryList = (List<MasEmpCategory>)map.get("empCategoryList");
	session.setAttribute("empCategoryList", empCategoryList);
}else if(session.getAttribute("empCategoryList") != null){
	empCategoryList = (List<MasEmpCategory>)session.getAttribute("empCategoryList");
}
List<MasUnit> unitList = new ArrayList<MasUnit>();
if(map.get("unitList") != null){
	unitList = (List<MasUnit>)map.get("unitList");
	session.setAttribute("unitList", unitList);
}else if(session.getAttribute("unitList") != null){
	unitList = (List<MasUnit>)session.getAttribute("unitList");
}
List<MasTrade> tradeList = new ArrayList<MasTrade>();
if(map.get("tradeList") != null){
	tradeList = (List<MasTrade>)map.get("tradeList");
	session.setAttribute("tradeList", tradeList);
}else if(session.getAttribute("tradeList") != null){
	tradeList = (List<MasTrade>)session.getAttribute("tradeList");
}
%>
<div id="contentHolder">
<h1 style="font-size: 15px; color: red;"><%=message %></h1>
<h6>Employee Search</h6>
<div class="Clear"></div>
<div class="blockTitle">Search</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame">
<div class="Clear"></div>


<label>Service No</label></label> <input type="text" name="<%=SERVICE_NO %>"
	value="" MAXLENGTH="20" /> <label>Rank</label> <select id="rankId"
	name="<%=RANK_ID %>">
	<option value="0">Select</option>
	<%
					for(MasRank masRank : rankList){
				%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName() %></option>
	<%}%>
</select>

<div class="Clear"></div>
<label>First Name</label> <input type="text" name="<%=S_FIRST_NAME %>"
	id="<%=S_FIRST_NAME %>" value="" MAXLENGTH="30" tabindex="1" /> <label>Last
Name</label> <input type="text" name="<%=S_LAST_NAME %>" id="<%=S_LAST_NAME %>"
	value="" MAXLENGTH="30" tabindex="1" />
<div class="Clear"></div>
<div class="Clear"></div>
</div>
</div>
</form>

<div class="Clear"></div>
<input type="button" name="search" id="search"
	onclick="submitForm('employeeUpdate','/hms/hms/hrOrderly?method=searchRecordsForEmployeeUpdate');"
	value="Search" class="cmnButton" accesskey="a" />

<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex="2">
<div id="searchtable" tabindex="2"></div>
<form name="postedOut" method="post" action=""><script
	type="text/javascript">
formFields = [
	[0, "<%= COMMON_ID%>", "id"], [1,"<%= EMPLOYEE_CODE%>"],[2,"<%= TITLE_ID %>"],[3,"<%= FIRST_NAME %>"],[4,"<%= LAST_NAME %>"],[5,"<%= DEPARTMENT_ID%>"],[6,"<%= EMPLOYEE_CATEGORY_ID%>"], [7,"<%= SERVICE_NO %>"],[8,"<%=RANK_ID %>"],[9,"<%= UNIT_ID %>"],[10,"<%= TRADE_ID %>"],[11,"<%=STATUS%>"],[12,"empId"] ];
	 statusTd = 12;
</script></form>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> <script
	type="text/javascript" language="javascript">

data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "data";
data_header[0][2] = 0;
data_header[0][3] = "<%= EMPLOYEE_CODE %>"

data_header[1] = new Array;
data_header[1][0] = "Title"
data_header[1][1] = "data";
data_header[1][2] = 0;
data_header[1][3] = "<%= TITLE_ID %>"


data_header[2] = new Array;
data_header[2][0] = "First Name"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= FIRST_NAME %>";


data_header[3] = new Array;
data_header[3][0] = "Last Name"
data_header[3][1] = "data";
data_header[3][2] = 0;
data_header[3][3] = "<%= LAST_NAME %>"



data_header[4] = new Array;
data_header[4][0] = "Department"
data_header[4][1] = "data";
data_header[4][2] = 0;
data_header[4][3] = "<%= DEPARTMENT_ID %>"


data_header[5] = new Array;
data_header[5][0] = "Category"
data_header[5][1] = "data";
data_header[5][2] = 0;
data_header[5][3] = "<%= EMPLOYEE_CATEGORY_ID%>"

data_header[6] = new Array;
data_header[6][0] = "Service No."
data_header[6][1] = "data";
data_header[6][2] = 0;
data_header[6][3] = "<%= SERVICE_NO%>"

data_header[7] = new Array;
data_header[7][0] = "Rank"
data_header[7][1] = "data";
data_header[7][2] = 0;
data_header[7][3] = "<%= RANK_ID%>"

data_header[8] = new Array;
data_header[8][0] = "Unit"
data_header[8][1] = "data";
data_header[8][2] = 0;
data_header[8][3] = "<%=UNIT_ID %>"

data_header[9] = new Array;
data_header[9][0] = "Trade"
data_header[9][1] = "hide";
data_header[9][2] = 0;
data_header[9][3] = "<%= TRADE_ID%>"

data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = 0;
data_header[10][3] = "<%=STATUS %>"

data_header[11] = new Array;
data_header[11][0] = ""
data_header[11][1] = "hide";
data_header[11][2] = "0";
data_header[11][3] = "empId"

data_arr = new Array();

<%
	int  counter=0;
    if(searchEmployeeList.size()>0){
	for (MasEmployee masEmp : searchEmployeeList) {
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%=masEmp.getId()%>"

<%if(masEmp.getEmployeeCode()!= null){%>
data_arr[<%= counter%>][1] = "<%=masEmp.getEmployeeCode()%>"
<%}else {%>
data_arr[<%= counter%>][1] = ""
<%}%>

<%if(masEmp.getTitle() != null){
    if(titleList.size()>0){
	Iterator itrTitleList=titleList.iterator();
	 while(itrTitleList.hasNext())
        {
         MasTitle  masTitleGrid = (MasTitle)itrTitleList.next(); 
		 if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equals("y")){%>
			data_arr[<%= counter%>][2] = "<%=masTitleGrid.getTitleName()%>"
		<%}else if(masEmp.getTitle().getId().equals(masTitleGrid.getId()) && masTitleGrid.getStatus().equals("n")){%>
			data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masTitleGrid.getTitleName()%>";
			
		<%}
}
    }		 
}else{%>
data_arr[<%= counter%>][2] = ""
<%}%>

<%if(masEmp.getFirstName() != null){%>
data_arr[<%= counter%>][3] = "<%= masEmp.getFirstName()%>"
<%}else {%>
data_arr[<%= counter%>][3] = ""
<%}%>

<%if(masEmp.getLastName() != null){%>
data_arr[<%= counter%>][4] = "<%= masEmp.getLastName()%>"
<%}else {%>
data_arr[<%= counter%>][4] = ""
<%}%>

<% if(masEmp.getDepartment() != null){
        if(departmentList.size()>0){ 
		Iterator itrDepartmentList=departmentList.iterator();
		 while(itrDepartmentList.hasNext())
            {
             MasDepartment  masDepartmentGrid = (MasDepartment)itrDepartmentList.next(); 
			 if(masEmp.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][5] = "<%=masDepartmentGrid.getDepartmentName()%>"
			<%}else if(masEmp.getDepartment().getId().equals(masDepartmentGrid.getId()) && masDepartmentGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][5] = "<font id='error'>*</font>Parent InActivated--<%=masDepartmentGrid.getDepartmentName()%>";
				
			<%}
            }
        }
}else{%>
  data_arr[<%= counter%>][5]=""
<%}%>

<%if(masEmp.getEmpCategory() != null){

		    if(empCategoryList.size()>0){
			for(MasEmpCategory masEmpCategory : empCategoryList){
            if(masEmp.getEmpCategory() != null){
			if(masEmp.getEmpCategory().getId().equals(masEmpCategory.getId()) && masEmpCategory.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][6] = "<%=masEmpCategory.getEmpCategoryName()%>"
			<%}else if(masEmp.getEmpCategory().getId().equals(masEmpCategory.getId()) && masEmpCategory.getStatus().equals("n")){%>
				data_arr[<%= counter%>][6] = "<font id='error'>*</font>Parent InActivated--<%=masEmpCategory.getEmpCategoryName()%>";
				
			<%}
            }}
		    }
}else {%>
data_arr[<%= counter%>][6] = ""
<%}%>

<% if(masEmp.getServiceNo() != null){%>
data_arr[<%= counter%>][7] = "<%=masEmp.getServiceNo()%>"
<%}else {%>
data_arr[<%= counter%>][7] = ""
<%}%>

 <% if(masEmp.getRank() != null){
     if(rankList.size()>0){
		for(MasRank masRank : rankList){
            if(masEmp.getRank() != null){
			if(masEmp.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][8] = "<%=masRank.getRankName()%>"
			<%}else if(masEmp.getRank().getId().equals(masRank.getId()) && masRank.getStatus().equals("n")){%>
				data_arr[<%= counter%>][8] = "<font id='error'>*</font>Parent InActivated--<%=masRank.getRankName()%>";
				
			<%}
            }
		}
}
}else {%>
data_arr[<%= counter%>][8] = ""
<%}%>
 
 <% if(masEmp.getUnit() != null){

         if(unitList.size()>0){
         Iterator itrGridUnitList=unitList.iterator();
		 while(itrGridUnitList.hasNext())
            {try{
            	MasUnit  unitGrid = (MasUnit)itrGridUnitList.next(); 
			 if(masEmp.getUnit().getId().equals(unitGrid.getId()) && unitGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][9] = "<%=unitGrid.getUnitName()%>"
			<%}else if(masEmp.getId().equals(unitGrid.getId()) && unitGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][9] = "<font id='error'>*</font>Parent InActivated--<%=unitGrid.getUnitName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}}

  }else {%>
             data_arr[<%= counter%>][9] = ""
<%} %>
 
<% if(masEmp.getTrade() != null){
      if(tradeList.size()>0){
		for(MasTrade masTrade : tradeList){
            if(masEmp.getTrade() != null){
			if(masEmp.getTrade().getId().equals(masTrade.getId()) && masTrade.getStatus().equals("y")){
			 %>
				data_arr[<%= counter%>][10] = "<%=masTrade.getTradeName()%>"
			<%}else if(masEmp.getTrade().getId().equals(masTrade.getId()) && masTrade.getStatus().equals("n")){%>
				data_arr[<%= counter%>][10] = "<font id='error'>*</font>Parent InActivated--<%=masTrade.getTradeName()%>";
				
			<%}
            }
		}
}
} else {%>
data_arr[<%= counter%>][10] = ""
<%}%>

<%if(masEmp.getStatus() !=null){
    if(!masEmp.getStatus().equals("n")){
%>
	data_arr[<%= counter%>][11]="Active"
<%}else{%>
	data_arr[<%= counter%>][11]="InActive"
<%}}else{%>	
data_arr[<%= counter%>][11]=""
<%}%>

data_arr[<%= counter%>][12]="<%=masEmp.getId()%>"

<% counter++;
}}%>

formName = "employeeUpdate"

nonEditable = ['<%= EMPLOYEE_CODE%>']
 
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
	
	
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');
</script></div>
</div>
