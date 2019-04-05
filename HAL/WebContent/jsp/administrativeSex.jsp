<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * administrativeSex.jsp  
 * Purpose of the JSP -  
 * @author  Dipali
 * @author  Mansi
 * Create Date: 12th Nov,2007 
 * Revision Date:      
 * Revision By:
 * @version 1.4  
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.MasAdministrativeSex"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchAdministrativeSexList = (ArrayList)map.get("searchAdministrativeSexList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Administrative Sex</h2>
</div>
   <div id="searcharea">
   
    
    
     <form name="search" method="post" action="">
     <div class="Block">
       
   <label>AS Code </label>
<input type="radio"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked"
	class="radioCheckCol1" />  
<label>AS Name </label>
<input type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioCheckCol1" />   

<input type="hidden" name="colCode" value="administrative_sex_code">
<input type="hidden" name="colName" value="administrative_sex_name">
      <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="AS Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'generalMaster?method=searchAdministrativeSex')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchAdministrativeSex','checkSearch')" tabindex=1  />
                    <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_administrative_sex">
       <div class="Clear"></div>
</div>
</form>
 </div>
 <div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
 <% 
  if(searchAdministrativeSexList.size()>0)
   {
   String strForCode = (String)map.get("administrativeSexCode");
   String strForCodeDescription = (String)map.get("administrativeSexName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %>   
    <h4><a href="generalMaster?method=showAdministrativeSexJsp">Show All Records</a></h4>
 <%
   }
   }
 if(searchAdministrativeSexList.size()==0 && map.get("search") != null)
 {
%>
			<h4><a href="generalMaster?method=showAdministrativeSexJsp">Show All Records</a></h4>

<%
 }
%>
 <script type="text/javascript">
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[5,"<%=CHANGED_TIME %>"],[6,"<%=STATUS %>"] ];
  statusTd = 6;
 </script>
 </div>
 
  <form name="administrativeSex" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasAdministrativeSex">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AdministrativeSexName">
  <input type="hidden" name="title" value = "AdministrativeSex">
  <input type="hidden" name="<%=JSP_NAME %>" value = "administrativeSex">
  <input type="hidden" name="pojoPropertyCode" value = "AdministrativeSexCode">
  
     
     
     
  <div class="Clear"></div>
<div class="Block">

  <label > AS Code <span>*</span></label>
  <input id="codeId" type="text" name="<%= CODE%>" value="" validate="AS Code,string,yes"  MAXLENGTH="8"/ tabindex=1 >
  
  <label >AS Name <span>*</span></label>
   <input type="text" name="<%= SEARCH_NAME %>" value="" validate="AS Name,string,yes"  MAXLENGTH="30"/ tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=addAdministrativeSex')">
   <script>
    document.administrativeSex.<%=CODE%>.focus();
   </script>

			</div>
<div class="Clear"></div>
  <div class="division"></div>
    <div class="Clear"></div>
 <div id="edited"></div>

   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('administrativeSex','generalMaster?method=addAdministrativeSex');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('administrativeSex','generalMaster?method=editAdministrativeSex')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('administrativeSex','generalMaster?method=deleteAdministrativeSex&flag='+this.value)" accesskey="d" tabindex=1/>  
  <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />

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
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
   </div> 
   
 <div class="Clear"></div>
</form>
 </div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "AS Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "AS Name"
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
Iterator itr=searchAdministrativeSexList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasAdministrativeSex  masAdministrativeSex = (MasAdministrativeSex)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAdministrativeSex.getId()%>
data_arr[<%= counter%>][1] = "<%=masAdministrativeSex.getAdministrativeSexCode()%>"
data_arr[<%= counter%>][2] = "<%= masAdministrativeSex.getAdministrativeSexName()%>"

data_arr[<%= counter%>][3] = "<%= masAdministrativeSex.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masAdministrativeSex.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masAdministrativeSex.getLastChgTime() %>"
<% if(masAdministrativeSex.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "administrativeSex"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>