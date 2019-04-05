<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * sample.jsp  
 * Purpose of the JSP -  This is for dgUom.jsp.
 * @author  Dipali
 * Create Date: 08th Jul,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.11
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.DgUom"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
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
	ArrayList searchInvestigationUomList = (ArrayList)map.get("searchInvestigationUomList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<h2 align="left" class="style1">Investigation UOM</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">UOM Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">UOM
Name:</font> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Collection Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'laboratory?method=searchInvestigationUom')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','laboratory?method=searchInvestigationUom','checkSearch')"
	tabindex=1 /></form>

</div>
</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchInvestigationUomList.size()>0)
		 {
			String strForCode = (String)map.get("uomCode");
			String strForCodeDescription = (String)map.get("uomName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<a href="laboratory?method=showInvestigationUomJsp">Show All Records</a>
<%
			}
		 }
	 if(searchInvestigationUomList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="laboratory?method=showInvestigationUomJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<br />
<form name="InvestigationUom" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="DgUom"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="UomName">
<input type="hidden" name="title" value="DgUom"> <input
	type="hidden" name="<%=JSP_NAME %>" value="InvestigationUom"> <input
	type="hidden" name="pojoPropertyCode" value="UomCode"> <br>

<div id=contentoperation><label class="bodytextB_blue"><font
	id="error">*</font>UOM Code:</label> <input type="text" name="<%= CODE%>"
	value="" validate="UOM Code,string,yes" class="textbox_size20"
	MAXLENGTH="8" / tabindex=1> <label class="bodytextB_blue"><font
	id="error">*</font>UOM Name:</label> <input type="text"
	name="<%= SEARCH_NAME %>" value="" validate="UOM Name,string,yes"
	class="textbox_size20" MAXLENGTH="30" / tabindex=1
	onkeypress="return submitenter(this,event,'laboratory?method=addInvestigationUom')">
<script>
				document.InvestigationUom.<%=CODE%>.focus();
			</script> <br />
<br />


<label class="bodytextB">Changed By:</label>
<div class="changebydt"><%=userName%></div>

<label class="bodytextB">Changed Date:</label>
<div class="changebydt"><%=date%></div>

<label class="bodytextB">Changed Time:</label>
<div class="changebydt"><%=time%></div>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>
<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('InvestigationUom','laboratory?method=addInvestigationUom');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('InvestigationUom','laboratory?method=editInvestigationUom')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('InvestigationUom','laboratory?method=deleteInvestigationUom'+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "UOM Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "UOM Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%= CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%

Iterator itr=searchInvestigationUomList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             DgUom  dgUom = (DgUom)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= dgUom.getId()%>
data_arr[<%= counter%>][1] = "<%=dgUom.getUomCode()%>"
data_arr[<%= counter%>][2] = "<%= dgUom.getUomName()%>"
data_arr[<%= counter%>][3] = "<%= dgUom.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(dgUom.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= dgUom.getLastChgTime() %>"
<% if(dgUom.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "InvestigationUom"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
