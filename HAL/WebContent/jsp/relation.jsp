<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * relation.jsp  
 * Purpose of the JSP -  This is for Relation.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.10
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@ page import="jkt.hms.masters.business.MasRelation"%>
<script language="javascript">

function populateCode(val){
	if(val!='')
		{
		  document.getElementById('codeRelation').value = val;
		  document.getElementById('codeNewRelation').value = val;
		  var w = document.getElementById('nameRelation').selectedIndex;
		  var selectedText = document.getElementById('nameRelation').options[w].text;
		  document.getElementById('nameRelationVal').value = selectedText;
		  
		}else{
			document.getElementById('code').value = '';
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
	ArrayList searchRelationList = (ArrayList)map.get("searchRelationList");
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
<h2>Relation Master</h2>
</div>
<div id="searcharea"> 
<form name="search" method="post" action="">
<div class="Block">
        <label>Relation Name</label>
        <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
     <label>New Relation Name</label>
     <input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
    <input type="hidden" name="colCode" value="relation_name">
<input type="hidden" name="colName" value="new_relation_name">
      <input type="text"  id="searchField" name="<%= SEARCH_FIELD%>" value=""  validate="Relation Code,string,no"   MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchRelation')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchRelation','checkSearch')" tabindex=1  />
                    	            <%--- Report Button   --%>  <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
                    <input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_relation">
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
  if(searchRelationList.size()>0)
   {
   String strForCode = (String)map.get("relationCode");
   String strForCodeDescription = (String)map.get("relationName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  

    <h4><a href="generalMaster?method=showRelationJsp">Show All Records</a></h4>
	<%
			}
		 }
	if(searchRelationList.size()==0 && map.get("search") != null)
	  {
	 %>
				<h4><a href="generalMaster?method=showRelationJsp">Show All Records</a></h4>

	 <%
  }
	%>
  <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"nameRelation"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%="codeRelation"%>"],[7,"<%="codeNewRelation"%>"],[8,"<%=STATUS%>"] ];
  statusTd =8;
 </script>
 </div>
 
  <form name="relation" method="post" action="">
  <input type="hidden" name="ctoken" value="<%=session.getAttribute("csrfToken")%>">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasRelation">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="RelationName">
  <input type="hidden" name="relation" value = "Relation">
  <input type="hidden" name="<%=JSP_NAME %>" value = "relation">
  <input type="hidden" name="pojoPropertyCode" value = "NewRelationCode">
  
     
     
     
  <div class="Clear"></div>
<div class="Block">

	
	    <label ><span>*</span>  Relation Name:</label>
	   	<select name="nameRelation" id="nameRelation" tabindex=1 validate="Relation Name,string,yes" onblur="populateCode(this.value);">
			  <option value="0">Select</option>
			  <option value="01">Father</option>
			  <option value="03">Son</option>
			  <option value="04">Daughter</option>
			  <option value="05">PSO</option>
			  <option value="07">Brother</option>
			  <option value="08">Wife</option>
			  <option value="09">Husband</option>
			  <option value="10">Sister</option>
			  <option value="gn">Grand son</option>
			  <option value="gd">Grand Daughter</option>			  
			 </select>	
	   
	    <input id="nameRelationVal" type="hidden" name="<%=CODE %>" value="">
	   
	    <label ><span>*</span>  Relation Code: </label>
	   <input id="codeRelation" type="text" name="codeRelation" value="" validate="Relation Code,string,yes"  MAXLENGTH="8" tabindex=1 readonly="readonly">
  
      
      <label ><span>*</span> New Relation Code: </label>
       <input type="text" name="codeNewRelation" id="codeNewRelation" value="" validate="Relation Name,string,yes"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'/hms/hms/generalMaster/generalMaster?method=addRelation')">
	
	
	<label ><span>*</span> New Relation Name: </label>
       <input type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>"  validate="Relation Name,string,yes"  MAXLENGTH="30" tabindex=1 onkeypress="return submitenter(this,event,'/hms/hms/generalMaster/generalMaster?method=addRelation')">
	
		   <script>
	    document.relation.<%=CODE%>.focus();
	   </script>
	   

			</div>
<div class="Clear"></div>
   <div id="edited"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('relation','/hms/hms/generalMaster?method=addRelation');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('relation','/hms/hms/generalMaster?method=editRelation')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('relation','/hms/hms/generalMaster?method=deleteRelation&flag='+this.value)" accesskey="d" tabindex=1/>  
  <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
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
data_header[0][0] = "Relation Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "nameRelation"

data_header[1] = new Array;
data_header[1][0] = "New Relation Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Code Relation "
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "codeRelation";



data_header[6] = new Array;
data_header[6][0] = "Code New Relation"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "codeNewRelation";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";



data_arr = new Array();

<%
Iterator itr=searchRelationList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasRelation  masRelation = (MasRelation)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masRelation.getId()%>


	<% if(masRelation.getRelationCode().equals("01")){ %>
	data_arr[<%= counter%>][1] = "Father"
	<%}else if(masRelation.getRelationCode().equals("02")){%>
	data_arr[<%= counter%>][1] = "Mother"
	<%}else if(masRelation.getRelationCode().equals("03")){%>
	data_arr[<%= counter%>][1] = "Son"
	<%}else if(masRelation.getRelationCode().equals("04")){%>
	data_arr[<%= counter%>][1] = "Daughter"
	<%}else if(masRelation.getRelationCode().equals("05")){%>
	data_arr[<%= counter%>][1] = "PSO"
	<%}else if(masRelation.getRelationCode().equals("06")){%>
	data_arr[<%= counter%>][1] = "Self"
	<%}else if(masRelation.getRelationCode().equals("07")){%>
	data_arr[<%= counter%>][1] = "Brother"
	<%}else if(masRelation.getRelationCode().equals("08")){%>
	data_arr[<%= counter%>][1] = "Wife"
	<%}else if(masRelation.getRelationCode().equals("09")){%>
	data_arr[<%= counter%>][1] = "Husband"
	<%}else if(masRelation.getRelationCode().equals("10")){%>
	data_arr[<%= counter%>][1] = "Sister"
	<%}else if(masRelation.getRelationCode().equals("11")){%>
	data_arr[<%= counter%>][1] = "Other"
	<%}else if(masRelation.getRelationCode().equals("00")){%>
	data_arr[<%= counter%>][1] = "Non-Entitlled"
	<%}else if(masRelation.getRelationCode().equals("gn")){%>
	data_arr[<%= counter%>][1] = "Grand Son"
	<%}else if(masRelation.getRelationCode().equals("gd")){%>
	data_arr[<%= counter%>][1] = "Grand Daughter"
	<%}%>
	
data_arr[<%= counter%>][2] = "<%= masRelation.getNewRelationName()%>"

data_arr[<%= counter%>][3] = "<%= masRelation.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%if(masRelation.getLastChgDate()!=null){ out.print(HMSUtil.convertDateToStringWithoutTime(masRelation.getLastChgDate()));} %>"
data_arr[<%= counter%>][5] = "<%= masRelation.getLastChgTime() %>"


	data_arr[<%= counter%>][6] = "<%= masRelation.getRelationCode()%>"
	
		data_arr[<%= counter%>][7] = "<%= masRelation.getNewRelationCode()%>"

<% if(masRelation.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "relation"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>