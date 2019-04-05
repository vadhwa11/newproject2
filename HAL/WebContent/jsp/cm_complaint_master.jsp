<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasComplaintsType"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.ComplaintDepartment"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchComplaintTypeList = (ArrayList)map.get("searchComplaintTypeList");
	ArrayList gridDepartmentList = (ArrayList)map.get("gridDepartmentList");
	ArrayList<ComplaintDepartment> complaintDepartment = (ArrayList<ComplaintDepartment>)map.get("complaintDepartment");
	
	List<MasDepartment> departmentTypeList = new ArrayList<MasDepartment>();
	if (map.get("departmentTypeList") != null) {
		System.out.println("departmentTypeList");
		departmentTypeList = (List) map.get("departmentTypeList");
	}
	
	
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	String message ="";
	
%>

<% 
if (map.get("message") != null) {
		 message = (String) map.get("message");
		
	}
if(!message.equalsIgnoreCase("")){
%>
<h2><%=message %></h2>
<%} %>

<div class="Clear"></div>
<div id="contentHolder">
<h6>Complaint Type</h6>
<div class="Clear"></div>
<div class="header">

<form name="search" method="post" action=""><label>Complaint
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" tabindex=1 /> <label>Complaint
Name</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="2"
	class="radio" tabindex=1 /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','complaint?method=searchComplaintType','checkSearch')"
	tabindex=1 /></form>
<div class="Clear"></div>

</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchComplaintTypeList.size()>0)
		 {
			String strForCode = (String)map.get("complaintTypeCode");
			String strForCodeDescription = (String)map.get("complaintTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<a href="complaint?method=showComplaintTypeJsp">Show All Records</a> <%
			}
		 }
	if(searchComplaintTypeList.size()==0 && map.get("search") != null)
	  {
    %> <a href="complaint?method=showComplaintTypeJsp">Show All
Records</a> <%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= DEPARTMENT_TYPE_ID %>"],[3,"<%= SEARCH_NAME%>"], [4,"<%= DEPARTMENT_NAME %>"],[5,"<%= COMPLAINT_TYPE_ID %>"],  [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script></div>

<div class="blockTitle">Complaint Details</div>
<div class="blockTitleCurve"></div>

<form name="complaintType" method="post" action="">
<div class="blockFrame">
<div class=Clear></div>

<input type="hidden" name="<%= POJO_NAME %>" value="MasComplaintsType">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="ComplaintTypeName"> <input type="hidden" name="title"
	value="ComplaintType"> <input type="hidden"
	name="<%=JSP_NAME %>" value="complaintType"> <input
	type="hidden" name="pojoPropertyCode" value="ComplaintTypeCode">

<label class="large"><span>*</span> Complaint Type Code </label> <input
	type="text" id="codeId" name="<%= CODE%>" value=""
	validate="Complaint Code,string,yes" MAXLENGTH="8" tabindex="1" /> <label
	class="large"><span>*</span> Complaint Type Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Complaint Name,string,yes" MAXLENGTH="30" tabindex=1 />

<div class="clear"></div>
<label class="large"><span>*</span> Department </label> <select
	name="<%= DEPARTMENT_TYPE_ID %>" id="dept_id" multiple class="list"
	validate="Department Name,string,yes" tabindex=1>

	<option value="0">Select</option>
	<%
			for (MasDepartment masdepartmentType : departmentTypeList) {
		%>

	<option value=<%=masdepartmentType.getId()%>><%=masdepartmentType.getDepartmentName()%></option>

	<%
			}
		%>
</select>

<div class=Clear></div>
</div>

<div class="division"></div>
<div id="edited"></div>
<!--Bottom labels starts-->
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('complaintType','complaint?method=addComplaintType');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('complaintType','complaint?method=editComplaintType')"
	accesskey="u" tabindex=1 /> <input type="button" name="back" id="back"
	value="Back" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex="1" /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('complaintType','complaint?method=deleteComplaintType&flag='+this.value)"
	accesskey="d" tabindex="1" /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex="2" />
<div class="division"></div>
<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <label>Changed
By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
</form>
<div class=Clear></div>

</div>

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Complaint Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Department Id"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= DEPARTMENT_TYPE_ID%>";

data_header[2] = new Array;
data_header[2][0] = "Complaint Type Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= SEARCH_NAME %>";

data_header[3] = new Array;
data_header[3][0] = "Department"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= DEPARTMENT_NAME %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "40%";
data_header[4][3] = "<%= COMPLAINT_TYPE_ID %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_BY %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_DATE %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = "15%";
data_header[7][3] = "<%= CHANGED_TIME %>";

data_header[8] = new Array;
data_header[8][0] = "Status"
data_header[8][1] = "data";
data_header[8][2] = "15%";
data_header[8][3] = "<%=STATUS %>";
data_arr = new Array();

<%
Iterator itr=searchComplaintTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MasComplaintsType  masComplaintsType = (MasComplaintsType)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masComplaintsType.getId()%>
<%if(masComplaintsType.getComplaintTypeCode() != null) {%>
data_arr[<%= counter%>][1] = "<%= masComplaintsType.getComplaintTypeCode()%>"
<%}else{%>
data_arr[<%= counter%>][1] = "-"
<%}%>

<%
 		  StringBuffer dept_ids = new StringBuffer();
		  StringBuffer dept_names = new StringBuffer();
    	  for (Iterator<ComplaintDepartment> iterator = complaintDepartment.iterator();  iterator.hasNext();)
    	  {
    		  ComplaintDepartment complDepartment = (ComplaintDepartment) iterator.next();
    		  if (masComplaintsType.getId() == complDepartment.getComplaintType().getId())
        	  {
           		  if (dept_ids.toString().length() > 0)
        		  {
           			dept_ids.append(",");
           			dept_ids.append(complDepartment.getDepartment().getId());
        		  }
        		  else
        		  {
        			  dept_ids.append(complDepartment.getDepartment().getId());
        		  }
        		  
        		  if (dept_names.toString().length() > 0)
        		  {
        			  dept_names.append(",");
        			  dept_names.append(complDepartment.getDepartment().getDepartmentName());
        		  }
        		  else
        		  {
        			  dept_names.append(complDepartment.getDepartment().getDepartmentName());
        		  }

        		  
        	  }
	      }
    %>




data_arr[<%= counter%>][2] = "<%=dept_ids.toString()%>"
<%if(masComplaintsType.getComplaintTypeName() != null) {%>
data_arr[<%= counter%>][3] = "<%=masComplaintsType.getComplaintTypeName()%>"
<%}else{%>
data_arr[<%= counter%>][3] = "-"
<%}%>
data_arr[<%= counter%>][4] = "<%=dept_names.toString()%>"


data_arr[<%= counter%>][5] = "<%=masComplaintsType.getId()%>"


<%if(masComplaintsType.getLstChangedBy() != null) {%>
data_arr[<%= counter%>][6] = "<%= masComplaintsType.getLstChangedBy() %>"
<%}else{%>
data_arr[<%= counter%>][6] =  "" 
<%}%>

<%if(masComplaintsType.getLstChangedDate() != null) {%>
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masComplaintsType.getLstChangedDate()) %>"
<%}else{%>
data_arr[<%= counter%>][7] = ""
<%}%>

<%if(masComplaintsType.getLstChangedTime() != null) {%>
data_arr[<%= counter%>][8] = "<%= masComplaintsType.getLstChangedTime() %>"
<%}else{%>
data_arr[<%= counter%>][8] = ""
<%}%>

<% if(masComplaintsType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "complaintType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
