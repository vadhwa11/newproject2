<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * icdSubCategory.jsp  
 * Purpose of the JSP -  This is for icd Sub Category.
 * @author  Mansi
 * @author  Dipali
 * Create Date: 08th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.14
--%>

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="jkt.hms.masters.business.MasIcdMainCategory"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasIcdMainCategory> icdMainCategoryList = new ArrayList<MasIcdMainCategory>();
	icdMainCategoryList = (ArrayList)map.get("icdMainCategoryList");
	ArrayList searchIcdSubCategoryList = (ArrayList)map.get("searchIcdSubCategoryList");
	ArrayList gridIcdMainCategoryList = (ArrayList)map.get("gridIcdMainCategoryList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	

%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><span><%=message%></span></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Icd SubCategory Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>ICD Sub Category Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>ICD Sub Category Name</label> <input
	type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value="2" />  <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="ICD Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchIcdSubCategory')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchIcdSubCategory','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_icd_sub_category"></div>
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
		if(searchIcdSubCategoryList.size()>0 && icdMainCategoryList.size() > 0)
		 {
			String strForCode = (String)map.get("icdSubCategoryCode");
			String strForCodeDescription = (String)map.get("icdSubCategoryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="hospital?method=showIcdSubCategoryJsp">Show All Records</a></h4> <%
			}
		 }
	 if(searchIcdSubCategoryList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showIcdSubCategoryJsp">Show All
Records</a></h4> <%
    }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ICD_MAIN_CATEGORY_ID %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="icdSubCategory" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasIcdSubCategory">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="IcdSubCategoryName"> <input type="hidden" name="title"
	value="IcdSubCategory"> <input type="hidden"
	name="<%=JSP_NAME %>" value="icdSubCategory"> <input
	type="hidden" name="pojoPropertyCode" value="IcdSubCategoryCode">

<div class="Clear"></div>
<div class="Block">


<label>  ICD Sub Category Code <span>*</span></label> <input type="text"
	name="<%= CODE%>" value="" validate="IcdSubCategory Code,string,yes"
	 MAXLENGTH="8" / tabindex=1>



<label class="noWidth">ICD Sub Category Name<span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="IcdSubCategory Name,string,yes" 
	MAXLENGTH="30" / tabindex=1> <script>
				document.icdSubCategory.<%=CODE%>.focus();
			</script>
			
			
			
			
<label class="noWidth"> ICD Main Category Name<span>*</span> </label> <select class="large2" name="<%= ICD_MAIN_CATEGORY_ID %>"
	validate="ICD SubCategory,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=addIcdSubCategory')">
	<option value="">Select</option>
	<% 
				for (MasIcdMainCategory  masIcdMainCategory : icdMainCategoryList){
				%>
	<option value="<%=masIcdMainCategory.getId ()%>"><%=masIcdMainCategory.getIcdMaincategoryName()%></option>
	<%}%>
</select> 


</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('icdSubCategory','hospital?method=addIcdSubCategory');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('icdSubCategory','hospital?method=editIcdSubCategory')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('icdSubCategory','hospital?method=deleteIcdSubCategory&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" /> <input
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

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
	</div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "ICD SubCategory Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "ICD SubCategory Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "ICD Main Category"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=ICD_MAIN_CATEGORY_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%=CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "0";
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchIcdSubCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasIcdSubCategory  masIcdSubCategory = (MasIcdSubCategory)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masIcdSubCategory.getId()%>
data_arr[<%= counter%>][1] = "<%=masIcdSubCategory.getIcdSubCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masIcdSubCategory.getIcdSubCategoryName()%>"

<%
		Iterator itrGridIcdMainCategoryList=gridIcdMainCategoryList.iterator();
		 while(itrGridIcdMainCategoryList.hasNext())
            {try{
             MasIcdMainCategory  icdMainCategoryGrid = (MasIcdMainCategory)itrGridIcdMainCategoryList.next(); 
			 if(masIcdSubCategory.getIcdMaincategory().getId().equals(icdMainCategoryGrid.getId()) && icdMainCategoryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=icdMainCategoryGrid.getIcdMaincategoryName()%>"
			<%}else if(masIcdSubCategory.getId().equals(icdMainCategoryGrid.getId()) && icdMainCategoryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=icdMainCategoryGrid.getIcdMaincategoryName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception----> "+e);}}%>
data_arr[<%= counter%>][4] = "<%= masIcdSubCategory.getLastChgBy() %>"
<%if(masIcdSubCategory.getLastChgDate()!=null){%>
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masIcdSubCategory.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][6] = "<%= masIcdSubCategory.getLastChgTime() %>"
<% if(masIcdSubCategory.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "icdSubCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
