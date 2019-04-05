<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * hrInsuranceDetails.jsp  
 * Purpose of the JSP -  This is for Schedule Master details 
 * @author  Rahul Srivastav
 * Create Date: 04-05-2017
 * Revision Date:      
 * Revision By: 
 * @version 1.0
--%>


<%@page import="jkt.hms.masters.business.MasScheduleMaster"%>
<%@page import="jkt.hms.masters.business.FaMasAccountGroup"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/erp/jsp/js/common.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.js?n=1"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.common.js"></script>
<script type="text/javascript" src="/hms/jsp/js/jquery.datePicker.js"></script>


<script language="javascript">

var $j = jQuery.noConflict();
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
	

	List<MasScheduleMaster> masScheduleMastersList = new ArrayList<MasScheduleMaster>();
	List<FaMasAccountGroup> faMasAccountGroupList = new ArrayList<FaMasAccountGroup>();
	
	if (map.get("accountGroupList") != null){
		faMasAccountGroupList = (List)map.get("accountGroupList");
	}
		
	
	 if(map.get("existingScheduleList")!= null){
		masScheduleMastersList = (List)map.get("existingScheduleList");
		
	} 
	 String searchField="";
	
	 if(map.get("searchField")!= null){
		 searchField = (String)map.get("searchField");
			
		} 
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println("<h4>" +message + "</h4>");
		  }
%>


<div class="titleBg">
	<h2>Schedule Master</h2>
</div>

<div class="Block">
	<div id="searcharea">
		<div id="searchbar">
			<form name="search" method="post" action="">


				<label>Schedule Name</label> 
				<input type="hidden" 	name="<%= SELECTED_RADIO%>" value="2" validate="Account Group Name,string,no" MAXLENGTH="30" tabindex=1 />
				<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Account Group Name,string,no" MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'account?method=searchScheduleMaster')"/>
				<input type="button" name="search" value="Search" class="button"
					onclick="submitForm('search','account?method=searchScheduleMaster','checkSearch')"
					tabindex=1 /> <input type="hidden" name="colName"
					value="f.insurance_name">
			
				<!-- <input type="button" name="Report" value="Generate Report"
					class="buttonBig"
					onclick="submitForm('search','account?method=generateReportForGeneralMasters');"   
					accesskey="g" tabindex=1 /> -->
			
				<%-- <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_fa_acc_group" /> --%>
			</form>
		</div>
		</div>
<form name="ancher" method="post">
</form>	
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2>
	<div id="searchtable" tabindex=2></div>

<% 
		if(masScheduleMastersList.size()>0)
		 {
			
	
			if(searchField!= null && searchField!= "" )
			{
	%> <!-- <h4><a href="masters?method=showTitleJsp">Show All Records</a></h4> -->
	<a href="javascript:void(0)"
			onclick="submitForm('ancher','account?method=showScheduleMasterJsp');">Show All Records</a>
<%
			}
		 }
	 if(masScheduleMastersList.size()==0 && map.get("search") != null)
	  {
	 %> <!-- <h4><a href="masters?method=showTitleJsp">Show All Records</a></h4> -->
 <h4><a href="javascript:void(0)" onclick="submitForm('ancher','account?method=showScheduleMasterJsp');">Show All Records</a></h4>
<%
     }
	%>
	
	<script type="text/javascript">
	formFields = [	
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"],[2,"description"], [3,"<%= DISTRICT_ID%>"],[4,"<%=STATUS%>"]];
	 statusTd = 4;
	</script>
</div>
<div class="clear"></div>
<div class="division"></div>




<form name="addSchedule" method="post" action="">
	<div class="Block">
		<label> Schedule Code <span>*</span></label>
		 <input type="text" name="<%=SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value="" validate="Account Group Code,string,yes" MAXLENGTH="32" tabindex=1>
		<script>
			document.addSchedule.<%=SEARCH_NAME%>.focus();
	</script>

		<label>Schedule Description<span>*</span></label>
		 <input type="text" name="description" value="" validate="Account Group Description,string,yes" MAXLENGTH="200" tabindex=1> 
			
			<label> Account Group Name <span>*</span></label>
				<select name="<%=DISTRICT_ID %>" validate="Account Group Name ,string,yes" tabindex=1>
				<option value="0">Select</option>
			<% 
			for (FaMasAccountGroup  faMasAccountGroup : faMasAccountGroupList){
				
			%>
			<option value="<%=faMasAccountGroup.getId ()%>"><%=faMasAccountGroup.getAccountGroupDesc()%></option>
			<%}%>
		</select>

		<div class="clear"></div>
	</div>

	<div class="division"></div>
	<div id="edited"></div>
		<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('addSchedule','account?method=addScheduleMaster');" accesskey="a" tabindex=1 />
	    <input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('addSchedule','account?method=updateScheduleMaster')" accesskey="u" tabindex=1 />
		<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('addSchedule','account?method=deleteScheduleMaster&flag='+this.value)" accesskey="d" tabindex=1/>	
		<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" /> 
<input type="hidden" name="<%=STATUS %>" value="" />
	<div class="division"></div>


</form>
<div class="clear"></div>


<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Schedule Code"
data_header[0][1] = "data";
data_header[0][2] = "20%";
data_header[0][3] = "<%= SEARCH_NAME%>";

data_header[1] = new Array;
data_header[1][0] = "Schedule description"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "description";

data_header[2] = new Array;
data_header[2][0] = "Account Group Name";
data_header[2][1] = "data";
data_header[2][2] = 0;
data_header[2][3] = "<%=DISTRICT_ID %>";

data_header[3] = new Array;
data_header[3][0] = "Status";
data_header[3][1] = "data";
data_header[3][2] = "15%";
data_header[3][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(masScheduleMastersList != null ){
	
		Iterator itr = masScheduleMastersList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasScheduleMaster   scheduleDetails = (MasScheduleMaster)itr.next(); 
        	  
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= scheduleDetails.getId()%>
data_arr[<%= counter%>][1] = "<%= scheduleDetails.getScheduleCode()%>";
data_arr[<%= counter%>][2] = "<%= scheduleDetails.getScheduleDescription()%>";
data_arr[<%= counter%>][3] = "<%= scheduleDetails.getScheduleGroup().getAccountGroupDesc()%>";

<% if(scheduleDetails.getStatus().equals("y")){ %>
data_arr[<%= counter%>][4] = "Active";
<%}else{%>
data_arr[<%= counter%>][4] = "InActive";
<%}%>
<%
		     counter++;
	}
}
%>
 
formName = "addSchedule"

nonEditable = ['<%=SEARCH_NAME%>' ];
	start = 0
	if (data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start, end);

	intializeHover('searchresulttable', 'TR', ' tableover');
</script>	

