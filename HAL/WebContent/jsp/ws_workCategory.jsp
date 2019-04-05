<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * workCategory.jsp  
 * Purpose of the JSP -  This is for Work Category.
 * @author  Vineet Kumar
 * Create Date: 07th April,2009 
 * Revision Date:      
 * Revision By: 

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


<script type="text/javascript">

function beforeSave()
{
document.getElementById("refreshCheck").value = true;
return true;
}

function afterSave()
{
alert("Refresh check"+ document.getElementById("refreshCheck").value )
if(document.getElementById("refreshCheck").value)
{
document.getElementById("refreshCheck").value = false;
return true;
}
else
return false;
}


function tValue() 
{ 
if(document.getElementById("maxLimit").value=="")
{
document.getElementById("maxLimit").value="4294967295";
}

var t1=parseInt(document.getElementById("minLimit").value);
var t2=parseInt(document.getElementById("maxLimit").value) ;
if(t1 > t2) 
{
alert("Min Limit must be less than Max Limit"); 
document.getElementById("minLimit").focus();
return false;
}
else{
return true;
}
}
</script>
<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
%>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchWorkCategoryList = (ArrayList)map.get("searchWorkCategoryList");
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
<h6>Work Category</h6>
<div class="Clear"></div>
<div class="header">

<form name="search" method="post" action=""><label>Work
Category Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>"
	class="radio" value="1" checked="checked" tabindex="1" /> <label>Work
Category Name</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="2"
	checked="checked" class="radio" tabindex="1" /> <input type="text"
	id="searchField1" name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30"
	tabindex="1" /> <input type="button" name="search" value="Search"
	class="cmnButton"
	onclick="submitForm('search','workCategory?method=searchWorkCategory','checkSearchForSingleWorkService')"
	tabindex="1" /></form>


</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults">
<div id="searchtable"></div>
<% 
		if(searchWorkCategoryList.size()>0)
		 {
			String strForCode = (String)map.get("workCategoryCode");
			String strForCodeDescription = (String)map.get("workCategoryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h5><a href="workCategory?method=showWorkCategoryJsp">Show All
Records</a></h5>
<div class="Clear"></div>
<%
			}
		 }
	if(searchWorkCategoryList.size()==0 && map.get("search") != null)
	  {
    %>
<div class="Clear"></div>
<h5><a href="workCategory?method=showWorkCategoryJsp">Show All
Records</a></h5>
<div class="Clear"></div>

<%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= MIN_LIMIT%>"], [4,"<%= MAX_LIMIT %>"],  [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>

<div class="blockTitle">Work Category</div>
<div class="blockTitleCurve"></div>

<form name="workCategory" method="post" action="">
<div class="blockFrame">
<div class=Clear></div>

<input type="hidden" name="<%= POJO_NAME %>" value="MasWorkCategory">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="WorkCategoryName"> <input type="hidden" name="title"
	value="WorkCategory"> <input type="hidden"
	name="<%=JSP_NAME %>" value="workCategory"> <input
	type="hidden" name="pojoPropertyCode" value="WorkCategoryCode">



<label class="large"><span>*</span> Work Category Code </label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Work Category Code,string,yes" MAXLENGTH="8" tabindex="2" />
<label class="large"><span>*</span> Work Category Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Work Category Name,string,yes" MAXLENGTH="30" tabindex="2" />
<script>
				document.workCategory.<%=CODE%>.focus();
			</script>

<div class=Clear></div>

<label class="large"><span>*</span>Minimum Limit </label> <input
	id="minLimit" type="text" name="<%= MIN_LIMIT%>" value=""
	validate="Minimum Limit,int,yes" MAXLENGTH="12" tabindex="2" /> <label
	class="large">Max Limit</label> <input id="maxLimit" type="text"
	name="<%= MAX_LIMIT %>" value="" validate="Maximum Limit,int,no"
	MAXLENGTH="12" tabindex="2" />

<div class=Clear></div>
</div>
<div class=Clear></div>

<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="submitForm('workCategory','workCategory?method=addWorkCategory','tValue');"
	accesskey="a" tabindex="2" /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('workCategory','workCategory?method=editWorkCategory','tValue')"
	accesskey="u" tabindex="2" /> <input type="button" name="back"
	id="back" value="Back" class="button"
	onclick="javascript:history.back()" accesskey="b" tabindex="2" /> <input
	type="button" name="Delete" id="deletebutton" value="Activate"
	class="button"
	onClick="submitForm('workCategory','workCategory?method=deleteWorkCategory&flag='+this.value)"
	accesskey="d" tabindex="2" /> <input type="reset" name="Reset"
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
data_header[0][0] = "Work Category Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Work Category Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Min Limit"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= MIN_LIMIT %>";

data_header[3] = new Array;
data_header[3][0] = "Max Limit"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= MAX_LIMIT %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%= CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";
data_arr = new Array();

<%
Iterator itr=searchWorkCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  MasWorkCategory  masWorkCategory = (MasWorkCategory)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masWorkCategory.getId()%>
data_arr[<%= counter%>][1] = "<%=masWorkCategory.getWorkCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masWorkCategory.getWorkCategoryName()%>"
data_arr[<%= counter%>][3] = "<%=masWorkCategory.getMinLimit().intValue()%>"
<%if(masWorkCategory.getMaxLimit().longValue()!=4294967295L){%>
data_arr[<%= counter%>][4] = "<%= masWorkCategory.getMaxLimit().longValue()%>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>
data_arr[<%= counter%>][5] = "<%= masWorkCategory.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masWorkCategory.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masWorkCategory.getLastChgTime() %>"
<% if(masWorkCategory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "workCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
