<%--
 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
 * Use is subject to license terms.
 * grade.jsp  
 * Purpose of the JSP -  This is showing Grade.
 * @author  Dipali
 * @author  Mansi
 * Create Date: 07th Feb,2008 
 * Revision Date:      
 * Revision By:  
 * @version 1.14
--%><%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasGrade"%>
<%@page import="jkt.hms.masters.business.MasRankCategory"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<%
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String,Object> utilMap = new HashMap<String,Object>();
		
		List<MasGrade> masGradeList = new ArrayList<MasGrade>();
		List<MasRankCategory> masRankCategoryList = new ArrayList<MasRankCategory>();
		List<MasGrade> gridGradeList = new ArrayList<MasGrade>();
		String userName = "";
		
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		if(map.get("masGradeList") != null){
			masGradeList = (ArrayList)map.get("masGradeList");
		}
		if(map.get("masRankCategoryList") != null){
			masRankCategoryList = (ArrayList)map.get("masRankCategoryList");
		}
	if(map.get("gridGradeList") != null){
	gridGradeList = (ArrayList)map.get("gridGradeList");
	}
	String date ="";
	String time ="";
	try{
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	 date = (String)utilMap.get("currentDate");	 
	 time = (String)utilMap.get("currentTime");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
	%><%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Grade Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Grade Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Grade Description</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField"	name="<%= SEARCH_FIELD%>" value="" validate="Grade Code,string,no"	MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchGrade')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','generalMaster?method=searchGrade','checkSearch')" tabindex=1 />
<%--- Report Button   --%>
<input type="button" name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');" accesskey="g" tabindex=1 />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_grade">
</div>
</form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div><% 
		if(masRankCategoryList.size()>0 && masGradeList.size() > 0)
		 {
			String strForCode = (String)map.get("gradeCode");
			String strForCodeDescription = (String)map.get("gradeName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> 
<h2><a href="generalMaster?method=showGradeJsp">Show All Records </a> </h2> <%
			}
		 }
	 if(masRankCategoryList.size()==0 && map.get("search") != null)
	  {
	 %> <h2><a href="generalMaster?method=showGradeJsp">Show All Records</a> </h2> <%
     }
	%> <script type="text/javascript">	formFields = [
	 			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= RANK_CATEGORY_ID%>"],  [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;	</script>
</div>
<div class="Clear paddingTop15"></div>
<form name="grade" method="post" action="">
<input type="hidden"	name="<%= POJO_NAME %>" value="MasGrade">
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="GradeName">
<input	type="hidden" name="<%=POJO_PROPERTY_CODE %>" value="GradeCode">
<input type="hidden" name="title" value="Grade">
<input	type="hidden" name="<%=JSP_NAME %>" value="grade">
<input	type="hidden" name="pojoPropertyCode" value="GradeCode"> 
<div class="Clear"></div>
<div class="Block">
<label> Grade Code <span>*</span></label>
<input type="text" name="<%= CODE%>" value="" validate="Grade Code,string,yes"  MAXLENGTH="8" tabindex=1 />
<label id=biglabel > Grade Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Grade Name,string,yes" MAXLENGTH="30" tabindex=1 />
 <script>
document.grade.<%=CODE%>.focus();
</script>
<label > Rank Category<span>*</span></label>
<select name="<%= RANK_CATEGORY_ID%>" validate="Rank Category,string,yes" tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=addGrade')">
	<option value="">Select</option>
	<% 
				for (MasRankCategory  masRankCategory : masRankCategoryList){
				%>
	<option value="<%=masRankCategory.getId ()%>"><%=masRankCategory.getRankCategoryName()%></option>
	<%}%>
</select>
</div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button" onClick="submitForm('grade','generalMaster?method=addGrade');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button"	onClick="submitForm('grade','generalMaster?method=editGrade')" accesskey="u" tabindex=1 /> <input type="button" name="Delete" id="deletebutton" value="Activate" class="button" onClick="submitForm('grade','generalMaster?method=deleteGrade&flag='+this.value)"	accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input	type="hidden" name="<%= COMMON_ID%>" value="" /> 
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

<script type="text/javascript">
data_header = new Array();
data_header[0] = new Array;
data_header[0][0] = "Grade Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"
data_header[1] = new Array;
data_header[1][0] = "Grade Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";
data_header[2] = new Array;
data_header[2][0] = "Rank Category"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=RANK_CATEGORY_ID %>";
data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%=CHANGED_BY %>"
data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[3][3] = "<%=CHANGED_DATE %>"
data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>"
data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";
data_arr = new Array();<%
Iterator itr=masGradeList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
             MasGrade  masGrade = (MasGrade)itr.next(); 
%>data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masGrade.getId()%>
data_arr[<%= counter%>][1] = "<%=masGrade.getGradeCode()%>"
data_arr[<%= counter%>][2] = "<%= masGrade.getGradeName()%>"
<%
		Iterator itrGridRankCategoryList=gridGradeList.iterator();
		 while(itrGridRankCategoryList.hasNext())
            {
             MasRankCategory  masRankCategory = (MasRankCategory)itrGridRankCategoryList.next(); 
            
			 if(masGrade.getRankCategory().getId().equals(masRankCategory.getId()) && masRankCategory.getStatus().equals("y")){
			
			 %>
				data_arr[<%= counter%>][3] = "<%=masRankCategory.getRankCategoryName()%>"
			<%}else if(masGrade.getRankCategory().getId().equals(masRankCategory.getId()) && masRankCategory.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=masRankCategory.getRankCategoryName()%>";
				
			<%}
}%>data_arr[<%= counter%>][4] = "<%= masGrade.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masGrade.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masGrade.getLastChgTime() %>"<% if(masGrade.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
formName = "grade"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
