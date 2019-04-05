<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemGeneric.jsp  
 * Purpose of the JSP -  This is forDietDietType.
 * @author Dipali
 * Create Date: 26th March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDietDietType"%>
<%@page import="jkt.hms.masters.business.MasDietType"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<style>
#contentspace label {
	text-align: right;
	padding-right: 10px;
	width: 130px;
	float: left;
	height: 9px;
}
</style>
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDietDietTypeList = (ArrayList)map.get("searchDietDietTypeList");
	List<MasDiet> dietList = new ArrayList<MasDiet>();
	List<MasDietType> dietTypeList = new ArrayList<MasDietType>();
	dietTypeList = (ArrayList)map.get("dietTypeList");
	dietList = (ArrayList)map.get("dietList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	 if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
 %>
<h2 align="left" class="style1">Diet Diet Type</h2>
<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><font
	class="bodytextB_blue">Diet:</font> <input type="text" id="searchField"
	name="<%=SEARCH_NAME%>" value="" validate="Diet Diet Type,string,no"
	MAXLENGTH="8"
	onkeypress="return submitenter(this,event,'canteen?method=searchDietType')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','canteen?method=searchDietDietType','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="button"
	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_diet_diet_type"></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchDietDietTypeList.size()>0)
   {
   String strForCode = (String)map.get("dietName");
   if(strForCode!= null && strForCode!= "" )
   {
 %> <br />
<a href="canteen?method=showDietDietTypeJsp">Show All Records</a> <%
		
		  }
	   }
	 if(searchDietDietTypeList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="canteen?method=showDietDietTypeJsp">Show All Records</a> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= DIET_ID%>"], [2,"<%= DIET_TYPE_ID %>"],[3,"<%= CHANGED_BY %>"] [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd =6;
 </script></div>
<br />
<form name="dietDietType" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasDietDietType">
<input type="hidden" name="title" value="DietDietType"> <input
	type="hidden" name="<%=JSP_NAME %>" value="dietDietType"> <br>

<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>Diet: </label> <select name="<%=DIET_ID %>"
	validate="Diet,string,yes" tabindex=1>
	<option value="">Select</option>
	<%
          		if(dietList != null){ 	
          			for (Iterator iter = dietList.iterator(); iter.hasNext();) {
          				MasDiet masDiet = (MasDiet) iter.next();
          %>
	<option value="<%=masDiet.getId() %>"><%=masDiet.getDietName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <label class="bodytextB_blue"><font id="error">*</font>Diet
Type: </label> <select name="<%=DIET_TYPE_ID %>" validate="Diet Type,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%
          		if(dietTypeList != null){ 	
          			for (Iterator iter = dietTypeList.iterator(); iter.hasNext();) {
          				MasDietType masDietType = (MasDietType) iter.next();
          %>
	<option value="<%=masDietType.getId() %>"><%=masDietType.getDietTypeName() %></option>
	<%		
         			}
         		 } 
         %>
</select> <br />
<br />

<label class="bodytextB_blue">Changed By:</label> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 /> <label
	class="bodytextB_blue">Changed Date:</label> <input type="text"
	name="<%= CHANGED_DATE %>" value="<%=date%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /> <label class="bodytextB_blue">Changed
Time:</label> <input type="text" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('dietDietType','canteen?method=addDietDietType');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('dietDietType','canteen?method=editDietDietType')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('dietDietType','canteen?method=deleteDietDietType&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Diet"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%= DIET_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Diet Type"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%= DIET_TYPE_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "10%";
data_header[5][3] = "<%=STATUS %>"


data_arr = new Array();
<%
Iterator itr=searchDietDietTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasDietDietType  masDietDietType = (MasDietDietType)itr.next();       
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDietDietType.getId()%>
<%
Iterator itrDietList=dietList.iterator();
while(itrDietList.hasNext())
      {
       MasDiet  masDietGrid = (MasDiet)itrDietList.next(); 
	 if(masDietDietType.getDiet().getId().equals(masDietGrid.getId()) && masDietGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][1] = "<%=masDietGrid.getDietName()%>"
	<%}else if(masDietDietType.getDiet().getId().equals(masDietGrid.getId()) && masDietGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=masDietGrid.getDietName()%>";
	<%}
}%>
<%
Iterator itrDietTypeList=dietTypeList.iterator();
while(itrDietTypeList.hasNext())
      {
       MasDietType  masDietTypeGrid = (MasDietType)itrDietTypeList.next(); 
	 if(masDietDietType.getDietType().getId().equals(masDietTypeGrid.getId()) && masDietTypeGrid.getStatus().equals("y")){%>
		data_arr[<%= counter%>][2] = "<%=masDietTypeGrid.getDietTypeName()%>"
	<%}else if(masDietDietType.getDietType().getId().equals(masDietTypeGrid.getId()) && masDietTypeGrid.getStatus().equals("n")){%>
		data_arr[<%= counter%>][2] = "<font id='error'>*</font>Parent InActivated--<%=masDietTypeGrid.getDietTypeName()%>";
	<%}
}%>
data_arr[<%= counter%>][3] = "<%= masDietDietType.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masDietDietType.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masDietDietType.getLastChgTime() %>"
<% if(masDietDietType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "dietDietType"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>