<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * bloodGroup.jsp  
 * Purpose of the JSP -  This is for Blood Group Type
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14  
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasBloodGroup;"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>



<div id="contentHolder">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchBloodGroupList = (ArrayList)map.get("searchBloodGroupList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <label class="noWidth"><span><%=message %></span></label>
	   <% 
	  }

%>
<h6>Blood Group Master</h6>

   <div id="searcharea">
   
    <div id="searchbar">
    <div class="header">
    
     <form name="search" method="post" action="">
       
        <input type="radio" class="radio" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
     <label >Blood Group Code:</label>
     <input type="radio" class="radio" name="<%=SELECTED_RADIO %>" value="2"  />
     <label >Blood Group Name:</label>
      <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Blood Group Code,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'bloodBankMaster?method=searchBloodGroup')"/>
                    <input type="button" name="search" value="Search" class="cmnButton" onclick="submitForm('search','bloodBankMaster?method=searchBloodGroup','checkSearch')" tabindex=1  />
<%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="cmnButton" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_blood_group">
       </form>
	   <div class="Clear"></div>
</div>
   </div>
  
 </div>

      
 <div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
	 <% 
	  if(searchBloodGroupList.size()>0)
	   {
	   String strForCode = (String)map.get("bloodGroupCode");
	   String strForCodeDescription = (String)map.get("bloodGroupName");
	   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
	   {
	 %>   
	 
	    <h2> <a href="bloodBankMaster?method=showBloodGroupJsp">Show All Records</a></h2>
	 <%
	   }
	   }
		 if(searchBloodGroupList.size()==0 && map.get("search") != null)
		 {
		%>
					<h2> <a href="bloodBankMaster?method=showBloodGroupJsp">Show All Records</a></h2>
		
		<%
		}
		%>
 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[5,"<%=CHANGED_TIME %>"],[6,"<%=STATUS %>"] ];
  statusTd = 6;
 </script>
 </div>
 
  <form name="bloodGroup" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasBloodGroup">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="BloodGroupName">
  <input type="hidden" name="title" value = "BloodGroup">
  <input type="hidden" name="<%=JSP_NAME %>" value = "bloodGroup">
  <input type="hidden" name="pojoPropertyCode" value = "BloodGroupCode">
  
     
     
  <div class="blockFrame">

   <label ><span>*</span> Blood Group Code:</label>
  <input id="codeId" type="text" name="<%= CODE%>" value="" validate="Blood Group Code,string,yes"  MAXLENGTH="8" tabindex=1 >
   <label ><span>*</span> Blood Group Name:</label>
   <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Blood Group Name,string,yes"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'bloodBankMaster?method=addBloodGroup')">
   <script>
    document.bloodGroup.<%=CODE%>.focus();
   </script>
   
   
   
			</div>
<div class="Clear"></div>
   <div id="edited"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('bloodGroup','bloodBankMaster?method=addBloodGroup');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('bloodGroup','bloodBankMaster?method=editBloodGroup')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('bloodGroup','bloodBankMaster?method=deleteBloodGroup&flag='+this.value)" accesskey="d" tabindex=1/>  
  <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date:</label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time:</label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  		
	   </div> 
          
    

   
   
   </form>
 </div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Blood Group Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Blood Group Name"
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
Iterator itr=searchBloodGroupList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasBloodGroup  masBloodGroup = (MasBloodGroup)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBloodGroup.getId()%>
data_arr[<%= counter%>][1] = "<%=masBloodGroup.getBloodGroupCode()%>"
data_arr[<%= counter%>][2] = "<%= masBloodGroup.getBloodGroupName()%>"

data_arr[<%= counter%>][3] = "<%= masBloodGroup.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masBloodGroup.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masBloodGroup.getLastChgTime() %>"
<% if(masBloodGroup.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "bloodGroup"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>