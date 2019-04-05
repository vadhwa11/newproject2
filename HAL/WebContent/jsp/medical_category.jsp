<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * rankCategory.jsp  
 * Purpose of the JSP -  This is for Rank Category.
 * @author  Dipali
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchMedicalCategoryList = (ArrayList)map.get("searchMedicalCategoryList");
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

<div class=titleBg">
<h2>Medical Category Master</h2>
</div>
   <div id="searcharea">
   
   
    
     <form name="search" method="post" action="">
         <div class="Block">
    <label class="noWidth">Medical Category Name</label>
 
     
      <input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Medical Category Name,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'personnel?method=searchRankCategory')"/>
                    <input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchMedicalCategory','checkSearch')" tabindex=1  />
   
       </form>
<div class="Clear"></div>

   </div>
  
 </div>

      
<div class="Clear"></div>

<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>

 <div id="searchresults" tabindex=2 >
 <div id="searchtable" tabindex=2 ></div>
 
 <% 
  if(searchMedicalCategoryList.size()>0)
   {
   String strForCodeDescription = (String)map.get("medicalCategoryName");
   if(strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  
    
   <h4> <a href="personnel?method=showMedicalCategoryJsp">Show All Records</a></h4>
 <%
   }
   }
		 if(searchMedicalCategoryList.size()==0 && map.get("search") != null)
		 {
		%>
					<h4><a href="personnel?method=showMedicalCategoryJsp">Show All Records</a></h4>
		
		<%
		 }
		%>

 

 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME %>"], [2,"<%= CHANGED_BY %>"], [3,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[5,"<%=STATUS%>"] ];
  statusTd = 5;
 </script>
 </div>
   <form name="medicalCategory" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasMedicalCategory">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MedicalCategoryName">
  <input type="hidden" name="medicalCategory" value = "MedicalCategory">
  <input type="hidden" name="<%=JSP_NAME %>" value = "medical_Category">
  
     
  <div class="Clear"></div>
<div class="Block">

     <label > Medical Category Name <span>*</span></label>
   <input type="text" name="<%= SEARCH_NAME %>" value="" validate="Medical Category Name,string,yes"  MAXLENGTH="30"/ tabindex=1 >
   
   			</div>
<div class="Clear"></div>
   <div id="edited"></div>
   <div class="division"></div>
   <div class="Clear"></div>
   <input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('medicalCategory','personnel?method=addMedicalCategory');" accesskey="a" tabindex=1/>
   <input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('medicalCategory','personnel?method=editMedicalCategory')" accesskey="u" tabindex=1 />
   <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('medicalCategory','personnel?method=deleteMedicalCategory&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
   <input type="hidden" name="<%=STATUS %>" value="" />
   <input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="Clear"></div>
   <div class="division"></div>
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

 <script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Rank Category Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"

data_header[1] = new Array;
data_header[1][0] = ""
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= CHANGED_BY %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_DATE %>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_TIME %>"

data_header[4] = new Array;
data_header[4][0] = "Status"
data_header[4][1] = "data";
data_header[4][2] = "15%";
data_header[4][3] = "<%=STATUS %>"



data_arr = new Array();
<%
Iterator itr=searchMedicalCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasMedicalCategory  masMedicalCategory= (MasMedicalCategory)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masMedicalCategory.getId()%>
data_arr[<%= counter%>][1] = "<%= masMedicalCategory.getMedicalCategoryName()%>"

data_arr[<%= counter%>][2] = "<%= masMedicalCategory.getLastChgBy() %>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(masMedicalCategory.getLastChgDate()) %>"
data_arr[<%= counter%>][4] = "<%= masMedicalCategory.getLastChgTime() %>"
<% if(masMedicalCategory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][5] = "Active"
<%}else{%>
data_arr[<%= counter%>][5] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "medicalCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>

