<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * itemGeneric.jsp  
 * Purpose of the JSP -  This is for DietMenuItem.
 * @author Dipali
 * Create Date: 26th March,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasDietMenuItem"%>
<%@page import="jkt.hms.masters.business.MasDietItems"%>
<%
	Map map = new HashMap();

	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}

	Map<String, Object> utilMap = new HashMap<String, Object>();
	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	String date = (String) utilMap.get("currentDate");
	String time = (String) utilMap.get("currentTime");

	List<MasDietMenuItem> menuItemList = new ArrayList<MasDietMenuItem>();
	List<MasDietItems> itemList = new ArrayList<MasDietItems>();

	if (map.get("menuItemList") != null) {
		menuItemList = (List<MasDietMenuItem>) map.get("menuItemList");
	}
	if (map.get("itemList") != null) {
		itemList = (List<MasDietItems>) map.get("itemList");
	}

	String userName = "";
	if (session.getAttribute("userName") != null) {
		userName = (String) session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
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
<h2>	Diet Menu Item</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Menu Type</label> 
<input type="text" id="searchField" name="<%=SEARCH_NAME%>" value=""
	validate="Menu Type,string,no" MAXLENGTH="30"
	onkeypress="return submitenter(this,event,'canteen?method=searchDietMenuItem')" />

<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','canteen?method=searchDietMenuItem','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%><!--  
<input type="button" name="Report" value="Generate Report Based on Search" class="cmnButton" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
     
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_diet_diet_type">
       --></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
 	if (menuItemList.size() > 0) {
 		String searchField = (String) map.get("searchField");
 		if (searchField != null && searchField != "") {
 %> 
<h4><a href="canteen?method=showDietMenuItemJsp">Show All Records</a></h4> <%
		}
		}
		if (menuItemList.size() == 0 && map.get("search") != null) {
	%> <h4><a href="canteen?method=showDietMenuItemJsp">Show All Records</a></h4> <%
	 	}
	 %> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= MENU_TYPE %>"],[2,"<%= DIET_ITEMS_ID %>"], [3,"<%= CHANGED_BY %>"],[4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd =6;
 </script></div>

<form name="dietMenuItem" method="post" action="">
<div class="Block">
<label><span>*</span>  Menu Type </label> 
<input
	id="codeId" type="text" name="<%= MENU_TYPE%>" value=""
	validate="Menu Type,string,yes"  MAXLENGTH="30"
	tabindex=1 /> 
<label><span>*</span> Diet Item </label>
 <select name="<%=DIET_ITEMS_ID %>"	validate="Diet Item,string,yes" tabindex=1 multiple="3">
	<option value="">Select</option>
	<%
         	if (itemList != null) {
         		for (Iterator iter = itemList.iterator(); iter.hasNext();) {
         			MasDietItems masDietItems = (MasDietItems) iter.next();
         %>
	<option value="<%=masDietItems.getId() %>"><%=masDietItems.getDietItemsName()%></option>
	<%
                    	}
                    	}
                    %>
</select> 

</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 
<input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('dietMenuItem','canteen?method=addDietMenuItem');"
	accesskey="a" tabindex=1 /> <!--
   
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('dietMenuItem','canteen?method=editDietDietType')" accesskey="u" tabindex=1 />
   --> 
<input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('dietMenuItem','canteen?method=deleteDietMenuItem&flag='+this.value)"
	accesskey="d" tabindex=1 /> 
<input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />


<input type="hidden" name="<%=STATUS %>" value="" /> 
<input
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


<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /> 
			<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />

</div>

</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Menu Type"
data_header[0][1] = "data";
data_header[0][2] = "10%";
data_header[0][3] = "<%= MENU_TYPE%>"

data_header[1] = new Array;
data_header[1][0] = "Diet Items"
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%= DIET_ITEMS_ID %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = "0";
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = "0";
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "0";
data_header[5][3] = "<%=STATUS %>"


data_arr = new Array();
<%
     int  counter=0;
	 

     for(MasDietMenuItem  masDietMenuItem : menuItemList){            
%>

			data_arr[<%= counter%>] = new Array();
			data_arr[<%= counter%>][0] = <%= masDietMenuItem.getId()%>
			<%
				if(masDietMenuItem.getMenuType() != null){
			%>
			data_arr[<%= counter%>][1] = "<%= masDietMenuItem.getMenuType()  %>"
			<%}else{%>
			data_arr[<%= counter%>][1] = ""
			<%}%>
			<%
			for(MasDietItems obj : itemList){
				 if(masDietMenuItem.getDietItems().getId().equals(obj.getId()) && obj.getStatus().equals("y")){%>
				data_arr[<%= counter%>][2] = "<%= obj.getDietItemsName()  %>"
				<%}else if(masDietMenuItem.getDietItems().getId().equals(obj.getId()) && obj.getStatus().equals("n")){%>
					data_arr[<%= counter%>][1] = "<font id='error'>*</font>Parent InActivated--<%=obj.getDietItemsName()%>";
				<%}
			}%>
			
			data_arr[<%= counter%>][3] = "<%= masDietMenuItem.getLastChgBy() %>"
			data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masDietMenuItem.getLastChgDate()) %>"
			data_arr[<%= counter%>][5] = "<%= masDietMenuItem.getLastChgTime() %>"
			<% if(masDietMenuItem.getStatus().equals("y")){ %>
			data_arr[<%= counter%>][6] = "Active"
			<%}else{%>
			data_arr[<%= counter%>][6] = "InActive"
			<%}%>
			<%
				  counter++;
			}
			%>
 
formName = "dietMenuItem"

start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>