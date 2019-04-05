<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * othersCategory.jsp  
 * Purpose of the JSP -  This is for Others Category.
 * @author  Dipali
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.4
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.MasOthersCategory"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchOthersCategoryList = (ArrayList)map.get("searchOthersCategoryList");
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
<%}%>
<div class="titleBg">
<h2>Others Category Master</h2>
</div>
<div id="searcharea">
<form name="search" method="post" action="">
<div class="Block">
<label>Others Category Code</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO  %>"   value="1" checked="checked" />
<label>Others Category Name</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2"  />
<input type="text" id="searchField"  name="<%= SEARCH_FIELD%>" value=""  validate="Others Category Code,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'personnel?method=searchOthersCategory')"/>

<input type="hidden" name="colCode" value="category_code">
<input type="hidden" name="colName" value="category_name">
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','personnel?method=searchOthersCategory','checkSearch')" tabindex=1  />
<%--- Report Button   --%>  
<%-- <input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','hospital?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1/>
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_others_category"> --%>
</div>
</form>
<div class="clear"></div>
</div>      
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
 <% 
  if(searchOthersCategoryList.size()>0)
   {
   String strForCode = (String)map.get("othersCategoryCode");
   String strForCodeDescription = (String)map.get("othersCategoryName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> 
  
    
   <h4> <a href="personnel?method=showOthersCategoryJsp">Show All Records</a></h4>
 <%
   }
   }
		 if(searchOthersCategoryList.size()==0 && map.get("search") != null)
		 {
		%>
					<h4><a href="personnel?method=showOthersCategoryJsp">Show All Records</a></h4>
		
		<%
		 }
		%>

 <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY %>"], [4,"<%= CHANGED_DATE %>"],[4,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
 </script>
 </div>
<form name="othersCategory" method="post" action="">
  <input type="hidden" name="<%= POJO_NAME %>" value = "MasOthersCategory">
  <input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CategoryName">
  <input type="hidden" name="othersCategory" value = "OthersCategory">
  <input type="hidden" name="<%=JSP_NAME %>" value = "othersCategory">
  <input type="hidden" name="pojoPropertyCode" value = "CategoryCode">
<div class="clear"></div>
<div class="Block">
<label>  Others Category Code <span>*</span></label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Others Category Code,string,yes"  MAXLENGTH="8"/ tabindex=1 >
<label>Others Category Name <span>*</span>  </label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Others Category Name,string,yes"  MAXLENGTH="30"/ tabindex=1 onkeypress="return submitenter(this,event,'personnel?method=addOthersCategory')" >
<script>
document.othersCategory.<%=CODE%>.focus();
</script>
</div>
<div class="clear"></div>
<div id="edited"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('othersCategory','personnel?method=addOthersCategory');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('othersCategory','personnel?method=editOthersCategory')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('othersCategory','personnel?method=deleteOthersCategory&flag='+this.value)" accesskey="d" tabindex=1/>  
<input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label >Changed By:</label>   
			<label class="value"><%=userName%></label>
			        
			<label >Changed Date: </label>   
			<label class="value"><%=date%></label>
			 
			<label >Changed Time: </label>   
			<label class="value"><%=time%></label>
			 
			<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
			<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
			<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />
			</div> 
			</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Others Category Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Others Category Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%=CHANGED_BY %>"

data_header[3] = new Array;
data_header[3][0] = "Admin"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>"

data_arr = new Array();
<%
Iterator itr=searchOthersCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {            
             MasOthersCategory  masOthersCategory = (MasOthersCategory)itr.next();       

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masOthersCategory.getId()%>
data_arr[<%= counter%>][1] = "<%=masOthersCategory.getCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masOthersCategory.getCategoryName()%>"

data_arr[<%= counter%>][3] = "<%= masOthersCategory.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masOthersCategory.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masOthersCategory.getLastChgTime() %>"
<% if(masOthersCategory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "othersCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>