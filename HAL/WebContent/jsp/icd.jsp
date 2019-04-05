<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * icd.jsp  
 * Purpose of the JSP -  This is for icd.
  * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By: 
 * @version 1.8
--%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="jkt.hms.masters.business.MasIcdcausegrp"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	List<MasIcdSubCategory> icdSubCategoryList = new ArrayList<MasIcdSubCategory>();
	List<MasIcdcausegrp> icdCauseList = new ArrayList<MasIcdcausegrp>();
	icdSubCategoryList = (ArrayList)map.get("icdSubCategoryList");
	icdCauseList = (ArrayList)map.get("icdCauseList");
	ArrayList searchIcdList = (ArrayList)map.get("searchIcdList");
	ArrayList gridIcdSubCategoryList = (ArrayList)map.get("gridIcdSubCategoryList");
	ArrayList gridIcdCauseList=(ArrayList)map.get("gridIcdCauseList");
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
<h6>ICD Master</h6>
<div class="Clear"></div>


<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><div class="Block"><label>ICD Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>ICD
Description</label> <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" />  <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="ICD Code,string,no"
	MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'hospital?method=searchIcd')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hospital?method=searchIcd','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');"
	accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_icd"></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchIcdList.size()>0 && icdSubCategoryList.size() > 0)
		 {
			String strForCode = (String)map.get("icdCode");
			String strForCodeDescription = (String)map.get("icdName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h4><a href="hospital?method=showIcdJsp">Show All Records</a></h4> <%
			}
		 }
	if(searchIcdList.size()==0 && map.get("search") != null)
	  {
	 %> <h4><a href="hospital?method=showIcdJsp">Show All Records</a></h4> <%
  }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%=CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= ICD_SUB_CATEGORY_ID %>"],[4,"<%= ICD_CAUSE_GROUP_ID %>"], [5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"<%=STATUS%>"] ];
	 statusTd = 8;
	</script></div>

<form name="icd" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasIcd"> <input type="hidden"
	name="<%=POJO_PROPERTY_NAME %>" value="IcdName"> <input
	type="hidden" name="title" value="Icd"> <input type="hidden"
	name="<%=JSP_NAME %>" value="icd"> <input type="hidden"
	name="pojoPropertyCode" value="IcdCode"> 


<div class="Clear"></div>
<div class="Block">
<label> ICD Code <span>*</span></label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="ICD Code,string,yes"
	 MAXLENGTH="8" / tabindex=1> <label> ICD Name <span>*</span></label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="ICD Name,string,yes"  MAXLENGTH="30"
	/ tabindex=1> <script>
				document.icd.<%=CODE%>.focus();
			</script> <label> ICD
Sub Category <span>*</span></label> <select id="unitId" name=<%=ICD_SUB_CATEGORY_ID %>
	validate="ICD SubCategory,string,yes">
	<option value="0">Select</option>

	<%
				         		if(icdSubCategoryList != null){ 	
				         			for (Iterator iter = icdSubCategoryList.iterator(); iter.hasNext();) {
				         				MasIcdSubCategory masIcdSubCategory = (MasIcdSubCategory) iter.next();
				         %>
	<option value="<%=masIcdSubCategory.getId() %>"><%=masIcdSubCategory.getIcdSubCategoryName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select>
<div class="Clear"></div>
<label>ICD Cause Grp<span>*</span> </label> <select class="large2" id="unitId" name=<%=ICD_CAUSE_GROUP_ID %>
	validate="ICD Cause Grp,string,yes">
	<option value="0">Select</option>

	<%
				         		if(icdCauseList != null){ 	
				         			for (Iterator iter = icdCauseList.iterator(); iter.hasNext();) {
				         				MasIcdcausegrp masIcdcausegrp = (MasIcdcausegrp) iter.next();
				         %>
	<option value="<%=masIcdcausegrp.getId() %>"><%=masIcdcausegrp.getIcdCauseName() %></option>
	<%		
				        			}
				        		 } 
				        %>
</select> 

</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="division"></div>
<div class="Clear"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('icd','hospital?method=addIcd');" accesskey="a"
	tabindex=1 /> <input type="button" name="edit" id="editbutton"
	value="Update" class="button"
	onClick="submitForm('icd','hospital?method=editIcd')" accesskey="u"
	tabindex=1 /> <input type="button" name="Delete" id="deletebutton"
	value="Activate" class="button"
	onClick="submitForm('icd','hospital?method=deleteIcd&flag='+this.value)"
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
data_header[0][0] = "ICD Code"
data_header[0][1] = "data";
data_header[0][2] = "8%";
data_header[0][3] = "<%=CODE%>"

data_header[1] = new Array;
data_header[1][0] = "ICD Name"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "ICD Sub Category"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%=ICD_SUB_CATEGORY_ID %>";

data_header[3] = new Array;
data_header[3][0] = "ICD Cause Grp"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "<%=ICD_CAUSE_GROUP_ID %>"

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
data_header[6][2] = "0";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = "Status"
data_header[7][1] = "data";
data_header[7][2] = "15%";
data_header[7][3] = "<%=STATUS %>";


data_arr = new Array();

<%
Iterator itr=searchIcdList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasIcd  masIcd = (MasIcd)itr.next(); 

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masIcd.getId()%>
data_arr[<%= counter%>][1] = "<%=masIcd.getIcdCode()%>"
data_arr[<%= counter%>][2] = "<%= masIcd.getIcdName()%>"
<% if(masIcd.getIcdSubCategory() != null){%>
<%
		Iterator itrGridIcdSubCategoryList=gridIcdSubCategoryList.iterator();
		 while(itrGridIcdSubCategoryList.hasNext())
            {
             MasIcdSubCategory  icdSubCategoryGrid = (MasIcdSubCategory)itrGridIcdSubCategoryList.next(); 
			 if(masIcd.getIcdSubCategory().getId().equals(icdSubCategoryGrid.getId()) && icdSubCategoryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=icdSubCategoryGrid.getIcdSubCategoryName()%>"
			<%}else if(masIcd.getId().equals(icdSubCategoryGrid.getId()) && icdSubCategoryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=icdSubCategoryGrid.getIcdSubCategoryName()%>";
				
			<%}
            }

}%>




<% if(masIcd.getIcdCause() != null){%>
<%
		Iterator itrGridIcdcausegrpList=icdCauseList.iterator();
		 while(itrGridIcdcausegrpList.hasNext())
            {
			 MasIcdcausegrp  icdIcdcausegrpGrid = (MasIcdcausegrp)itrGridIcdcausegrpList.next(); 
			 if(masIcd.getIcdSubCategory().getId().equals(icdIcdcausegrpGrid.getId()) && icdIcdcausegrpGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][4] = "<%=icdIcdcausegrpGrid.getIcdCauseName()%>"
			<%}else if(masIcd.getId().equals(icdIcdcausegrpGrid.getId()) && icdIcdcausegrpGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][4] = "<font id='error'>*</font>Parent InActivated--<%=icdIcdcausegrpGrid.getIcdCauseName()%>";
				
			<%}
            }

}%>

data_arr[<%= counter%>][5] = "<%= masIcd.getLastChgBy() %>"
<%if(masIcd.getLastChgDate()!=null){%>
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(masIcd.getLastChgDate()) %>"
<%}%>
data_arr[<%= counter%>][7] = "<%= masIcd.getLastChgTime() %>"
<% if(masIcd.getStatus().equals("y")){ %>
data_arr[<%= counter%>][8] = "Active"
<%}else{%>
data_arr[<%= counter%>][8] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "icd"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
