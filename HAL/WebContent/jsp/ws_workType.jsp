<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * workType.jsp  
 * Purpose of the JSP -  This is for Work Type.
 * @author  Vineet Kumar
 * Create Date: 15th April,2009 
 * Revision Date:      
 * Revision By: 

--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasWorkType"%>
<%@page import="jkt.hms.masters.business.MasWorkCategory"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script type="text/javascript">

function tValue() 
{ 
if(document.getElementById("maxLimit").value=="" && document.getElementById("workCategory").value=="3")
{
document.getElementById("maxLimit").value="";
}

var t1=document.getElementById("minLimit").value;
var t2=document.getElementById("maxLimit").value ;
if(parseInt(t1)>parseInt(t2) && !document.getElementById("workCategory").value=="3") 
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
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasWorkType> searchWorkTypeList = (ArrayList<MasWorkType>)map.get("searchWorkTypeList");
	ArrayList<MasWorkCategory> searchWorkCategoryList = (ArrayList<MasWorkCategory>)map.get("searchWorkCategoryList");
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
<h6>Work Type</h6>
<div class="Clear"></div>
<div class="header">
<form name="search" method="post" action=""><label>Work
Type Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" value="1"
	checked="checked" class="radio" /> <label>Work Type Name</label> <input
	type="radio" name="<%=SELECTED_RADIO  %>" value="2" checked="checked"
	class="radio" /> <input type="text" id="searchField1"
	name="<%= SEARCH_FIELD%>" value="" MAXLENGTH="30" tabindex=1 /> <input
	type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','workType?method=searchWorkType','checkSearchForSingleWorkService')"
	tabindex=1 />

<div class="Clear"></div>
</form>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchWorkTypeList.size()>0)
		 {
			String strForCode = (String)map.get("workTypeCode");
			String strForCodeDescription = (String)map.get("workTypeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <br />
<div class="Clear"></div>
<h5><a href="workType?method=showWorkTypeJsp">Show All Records</a>
<h5>
<div class="Clear"></div>
<%
			}
		 }
	if(searchWorkTypeList.size()==0 && map.get("search") != null)
	  {
    %>
<div class="Clear"></div>
<h5><a href="workType?method=showWorkTypeJsp">Show All Records</a></h5>
<div class="Clear"></div>

<%
	   }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= WORK_CATEGORY %>"],[4,"<%= MIN_LIMIT%>"], [5,"<%= MAX_LIMIT %>"],  [6,"<%= CHANGED_BY%>"], [7,"<%= CHANGED_DATE %>"],[8,"<%= CHANGED_TIME %>"],[9,"<%=STATUS%>"] ];
	 statusTd = 9;
	</script>
</div>
<div class="Clear"></div>
<div class="blockTitle">Work Type</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<form name="workType" method="post" action="">
<div class="blockFrame"><input type="hidden"
	name="<%= POJO_NAME %>" value="MasWorkType"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="WorkTypeName">
<input type="hidden" name="title" value="WorkType"> <input
	type="hidden" name="<%=JSP_NAME %>" value="workType"> <input
	type="hidden" name="pojoPropertyCode" value="WorkTypeCode"> <label><span>*</span>
Work Type Code </label> <input id="codeId" type="text" name="<%= CODE%>"
	value="" validate="Work Type Code,string,yes" MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Work Type Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" value="" validate="Work Type Name,string,yes"
	MAXLENGTH="30" tabindex=1 /> <script>
document.workType.<%=CODE%>.focus();
</script> <label><span>*</span> Work Category </label> <select id="workCategory"
	name="<%=WORK_CATEGORY %>" validate="Work Category,string,yes"
	tabindex="1" class="select_adt">
	<option value="0">Select</option>
	<% 
			for(MasWorkCategory masWorkCategory : searchWorkCategoryList){
				if(masWorkCategory.getStatus().equalsIgnoreCase("y"))
				{
		%>
	<option value="<%=masWorkCategory.getId() %>"><%=masWorkCategory.getWorkCategoryName() %></option>
	<%}else
			continue;
			}%>
</select>
<div class="Clear"></div>


<label> Minimum Limit </label> <input id="minLimit" type="text"
	name="<%= MIN_LIMIT%>" value="" validate="Min Limit,int,no"
	MAXLENGTH="12" tabindex=1 /> <label> Maximum Limit</label> <input
	id="maxLimit" type="text" name="<%= MAX_LIMIT %>" value=""
	validate="Min Limit,int,no" MAXLENGTH="12" tabindex=1 /></div>

<div class="division"></div>
<!--Bottom labels starts-->
<div id="edited"></div>
<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="submitForm('workType','workType?method=addWorkType','tValue');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('workType','workType?method=editWorkType','tValue')"
	accesskey="u" tabindex=1 /> <input type="button" name="back" id="back"
	value="Back" class="button" onclick="javascript:history.back()"
	accesskey="b" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('workType','workType?method=deleteWorkType&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	id="reset" value="Reset" class="button" onclick="resetCheck();"
	accesskey="r" tabindex="1" />


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
</div>
<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Work Type Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Work Type Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Category"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= WORK_CATEGORY %>";

data_header[3] = new Array;
data_header[3][0] = "Min Limit"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%= MIN_LIMIT %>";



data_header[4] = new Array;
data_header[4][0] = "Max Limit"
data_header[4][1] = "data";
data_header[4][2] = "40%";
data_header[4][3] = "<%= MAX_LIMIT %>";

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
Iterator itr=searchWorkTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasWorkType  masWorkType = (MasWorkType)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masWorkType.getId()%>
data_arr[<%= counter%>][1] = "<%=masWorkType.getWorkTypeCode()%>"
data_arr[<%= counter%>][2] = "<%= masWorkType.getWorkTypeName()%>"

 <%
		Iterator itrSearchWorkCategoryList=searchWorkCategoryList.iterator();
		 while(itrSearchWorkCategoryList.hasNext())
            {try{
             MasWorkCategory  workCategory = (MasWorkCategory)itrSearchWorkCategoryList.next(); 
			 if(masWorkType.getWorkCategory().getId().equals(workCategory.getId()) && workCategory.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=workCategory.getWorkCategoryName()%>"
			<%}else if(masWorkType.getId().equals(workCategory.getId()) && workCategory.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=workCategory.getWorkCategoryName()%>";
				
			<%System.out.println(workCategory.getWorkCategoryName()+"hiiiiiiiii");}
            }catch(Exception e){e.printStackTrace();}}%>
            


<%if(masWorkType.getMinLimit()!=null &&  !masWorkType.getMinLimit().toString().equalsIgnoreCase("")){ %>
data_arr[<%= counter%>][4] = "<%=masWorkType.getMinLimit().intValue()%>"
<%}else{%>
data_arr[<%= counter%>][4] = "";

<%}%>


<%if(masWorkType.getMaxLimit()!=null &&  !masWorkType.getMaxLimit().toString().equalsIgnoreCase("")){ %>
data_arr[<%= counter%>][5] = "<%= masWorkType.getMaxLimit().intValue()%>"
<%}else{%>
data_arr[<%= counter%>][5] = "";

<%}%>
data_arr[<%= counter%>][6] = "<%= masWorkType.getLastChgBy() %>"
data_arr[<%= counter%>][7] = "<%= HMSUtil.convertDateToStringWithoutTime(masWorkType.getLastChgDate()) %>"
data_arr[<%= counter%>][8] = "<%= masWorkType.getLastChgTime() %>"
<% if(masWorkType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][9] = "Active"
<%}else{%>
data_arr[<%= counter%>][9] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "workType"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>



