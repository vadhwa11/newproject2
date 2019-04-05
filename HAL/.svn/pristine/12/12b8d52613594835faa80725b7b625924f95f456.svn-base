<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * diet.jsp  
 * Purpose of the JSP -  This is for Diet Details.
 * @author  Deepali
 * @author  Vikas
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.7 
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDiet;"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchDietList = (ArrayList)map.get("searchDietList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>


<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>	Diet Master</h2>
</div>
<div class="Clear"></div>

<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action="">
<div class="Block">
<label>Diet Code</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> 
<label>Diet Name</label> 
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="Diet,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'canteen?method=searchDiet')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','canteen?method=searchDiet','checkSearch')" tabindex=1 />
	<%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_diet">
</div>
</form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchDietList.size()>0)
		 {
			String strForCode = (String)map.get("dietCode");
			String strForCodeDescription = (String)map.get("dietName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="canteen?method=showDietJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchDietList.size()==0 && map.get("search") != null)
	  {
%> <h4><a href="canteen?method=showDietJsp">Show All Records</a></h4> <%
    }
%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= DIET_CATEGORY_NAME%>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="diet" method="post" action="">
<input type="hidden"
	name="<%= POJO_NAME %>" value="MasDiet"> 
<input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="DietName"> 
<input
	type="hidden" name="title" value="Diet"> 
<input type="hidden"
	name="<%=JSP_NAME %>" value="diet"> 
<input type="hidden"
	name="pojoPropertyCode" value="DietCode"> 
<div class="Clear"></div>
<div class="Block">
<label><span>*</span>  Diet Code </label> 
<input id="codeId" type="text" name="<%= CODE%>" value=""	validate="Diet Code,string,yes"  MAXLENGTH="8" tabindex=1 />
<label><span>*</span> Diet Name</label> 
<input type="text"	name="<%= SEARCH_NAME %>" value="" validate="Diet Name,string,yes"	 MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'canteen?method=addDiet')">
<script>
document.diet.<%=CODE%>.focus();
</script> 
<label><span>*</span> Type </label>
<select name="<%=DIET_CATEGORY_NAME %>"
	validate="Type,string,yes">
	<option value="">Select</option>
	<option value="G">General</option>
	<option value="T">Therapeutic</option>
	<option value="S">Supplementary</option>
</select> 

</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 
<input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('diet','canteen?method=addDiet');" accesskey="a"
	tabindex=1 /> 
<input type="button" name="edit" id="editbutton"
	value="Update" class="button"
	onClick="submitForm('diet','canteen?method=editDiet')" accesskey="u"
	tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('diet','canteen?method=deleteDiet&flag='+this.value)"
	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"
	value="Reset" onclick="resetCheck();" class="button" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> 
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 

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

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
</div>

</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Diet Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Diet Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Category"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%= DIET_CATEGORY_NAME %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchDietList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasDiet  masDiet = (MasDiet)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masDiet.getId()%>
data_arr[<%= counter%>][1] = "<%=masDiet.getDietCode()%>"
data_arr[<%= counter%>][2] = "<%= masDiet.getDietName()%>"
<% if(masDiet.getDietCategory().equals("G")){ %>
data_arr[<%= counter%>][3] = "General"
<%}else{%>
data_arr[<%= counter%>][3] = "Therapeutic"
<%}%>
data_arr[<%= counter%>][4] = "<%= masDiet.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masDiet.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masDiet.getLastChgTime() %>"
<% if(masDiet.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "diet"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
