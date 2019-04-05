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
<%@page import="jkt.hms.masters.business.MasDietCombination"%>
<%@page import="jkt.hms.masters.business.MasDietType"%>
<%@page import="jkt.hms.masters.business.MasDiet"%>
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
<h2>	Diet Combination</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Diet</label> 
<input type="text" id="searchField"	name="<%=SEARCH_NAME%>" value="" validate="Diet Diet Type,string,no" MAXLENGTH="8"
	onkeypress="return submitenter(this,event,'canteen?method=searchDietCombination')" />

<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','canteen?method=searchDietCombination','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> 
<input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"
	accesskey="g" tabindex=1 /> 
<input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_diet_diet_type">
</div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
  if(searchDietDietTypeList.size()>0)
   {
   String strForCode = (String)map.get("dietName");
   if(strForCode!= null && strForCode!= "" )
   {
 %> 
<h4><a href="canteen?method=showDietCombinationJsp">Show All Records</a></h4> <%
		
		  }
	   }
	 if(searchDietDietTypeList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="canteen?method=showDietCombinationJsp">Show All
Records</a></h4> <%
    }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= DIET_ID%>"], [2,"<%= DIET_TYPE_ID %>"],[3,"<%= DIET_COMBINATION_NAME %>"],[4,"<%=DISPLAY_FOR_DEMAND %>"],[5,"<%= CHANGED_BY %>"], [5,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
  statusTd =8;
 </script></div>

<form name="dietDietType" method="post" action="">
<input
	type="hidden" name="<%= POJO_NAME %>" value="MasDietCombination">

<input type="hidden" name="title" value="DietCombination"> 
<input
	type="hidden" name="<%=JSP_NAME %>" value="dietCombination"> <br>

<div class="Clear"></div>
<div class="Block">
<label><span>*</span> Diet </label>
<select name="<%=DIET_ID %>"
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
</select> 
<label><span>*</span> Diet Type </label>
<select name="<%=DIET_TYPE_ID %>" validate="Diet Type,string,yes"
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
</select> 
<label class="auto"><span>*</span>  Diet Combination Name </label> 
<input type="text" name="<%= DIET_COMBINATION_NAME%>"
	value="" validate="Diet Combination Name,string,yes"
	 MAXLENGTH="30" tabindex=1 /> 

<div class="clear"></div>
<label> Demand Display </label> 
<input	type="checkbox" name="<%=DISPLAY_FOR_DEMAND %>" value=""
	class="radio" /> 


</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 
<input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('dietDietType','canteen?method=addDietCombination');"
	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('dietDietType','canteen?method=editDietCombination')"
	accesskey="u" tabindex=1 /> 
<input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('dietDietType','canteen?method=deleteDietCombination&flag='+this.value)"
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
data_header[2][0] = "Diet Combination Name"
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=DIET_COMBINATION_NAME %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=DISPLAY_FOR_DEMAND %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_BY %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_DATE %>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%=CHANGED_TIME %>"

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "10%";
data_header[7][3] = "<%=STATUS %>"


data_arr = new Array();
<%
Iterator itr=searchDietDietTypeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
        	  MasDietCombination  masDietDietType = (MasDietCombination)itr.next();       
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

data_arr[<%= counter%>][3] = "<%= masDietDietType.getDietCombinationName() %>"
data_arr[<%= counter%>][4] = "<%= masDietDietType.getDemandDisplay() %>"
data_arr[<%= counter%>][5] = "<%= masDietDietType.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masDietDietType.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= masDietDietType.getLastChgTime() %>"
<% if(masDietDietType.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
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