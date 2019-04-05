<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * costCenter.jsp  
 * Purpose of the JSP -  This is for Cost Center Details.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.13  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCostCenter;"%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchCostCenterList = (ArrayList)map.get("searchCostCenterList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><span><%=message%></span></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Cost Center Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Cost Center Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>Cost
Center Name</label> <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" />  <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="CostCenter Code,string,no"
	MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchCostCenter')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchCostCenter','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_cost_center"></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchCostCenterList.size()>0)
   {
   String strForCode = (String)map.get("costCenterCode");
   String strForCodeDescription = (String)map.get("costCenterName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
<h4><a href="hospital?method=showCostCenterJsp">Show All Records</a></h4> <%
   }
   }
   
 if(searchCostCenterList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showCostCenterJsp">Show All Records</a></h4> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
    [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
 </script></div>

<form name="costCenter" method="post" action="">

<input
	type="hidden" name="<%= POJO_NAME %>" value="MasCostCenter"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CostCenterName">
<input type="hidden" name="<%=JSP_NAME %>" value="costCenter"> <input
	type="hidden" name="pojoPropertyCode" value="CostCenterCode"> 

<div class="Clear"></div>
<div class="Block">
<label class="noWidth"> Cost Center Code <span>*</span></label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Cost Center Code,string,yes"
	 MAXLENGTH="8" / tabindex=1> <label class="noWidth">Cost Center
Name <span>*</span></label> <input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Cost Center Name,string,yes" 
	MAXLENGTH="30" / tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=addCostCenter')">
<script>
    document.costCenter.<%=CODE%>.focus();
   </script> 

</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('costCenter','hospital?method=addCostCenter');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('costCenter','hospital?method=editCostCenter')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('costCenter','hospital?method=deleteCostCenter&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>

<label>Changed Date:</label>
<label class="value"><%=date%></label>

<label>Changed Time:</label>
<label class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Cost Center Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Cost Center Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchCostCenterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasCostCenter  masCostCenter = (MasCostCenter)itr.next();   

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masCostCenter.getId()%>
data_arr[<%= counter%>][1] = "<%=masCostCenter.getCostCenterCode()%>"
data_arr[<%= counter%>][2] = "<%= masCostCenter.getCostCenterName()%>"
data_arr[<%= counter%>][3] = "<%= masCostCenter.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masCostCenter.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masCostCenter.getLastChgTime() %>"
<% if(masCostCenter.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%> 
formName = "costCenter"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>