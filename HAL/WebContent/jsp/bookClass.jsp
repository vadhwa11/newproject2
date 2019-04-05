<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasBookClass"%>
<%@page import="jkt.hms.masters.business.MasBookCategory"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script>
function checkSpecialChar(){
var code;
 code = document.getElementById('codeId').value;
 
 var name ;
 name= document.getElementById('search_name').value;
 if(code.match("\"")|| name.match("\"")){
 alert('Please Do not enter " as Entry field')
 return false;
 }else if(code.match("\<")|| name.match("\<")){
 alert('Please Do not enter < as Entry field')
 return false;
 }
 else{
 return true;
 }
}
</script>


<%
	Map<String ,Object> map = new HashMap<String ,Object>();
	if(request.getAttribute("map") != null)
	{
		map = (Map<String ,Object>) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map<String ,Object>)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList<MasBookClass> searchBookClassList = (ArrayList<MasBookClass>)map.get("searchBookClassList");
	ArrayList<MasBookCategory> bookCategoryList = (ArrayList<MasBookCategory>)map.get("bookCategoryList");
	ArrayList<MasBookCategory> gridBookCategoryList = (ArrayList<MasBookCategory>)map.get("gridBookCategoryList");

	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h2><%=message %></h2>

<%} %>

<div id="contentHolder">
<div class="Clear"></div>
<h6>Book Class Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Class
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <label>Class Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radio" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Class Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'lib?method=searchBookClass')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','lib?method=searchBookClass','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
<div class="Clear"></div>
</div>

<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
		if(searchBookClassList.size()>0)
		 {
			String strForCode = (String)map.get("bookClassCode");
			String strForCodeDescription = (String)map.get("bookClassName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="lib?method=showBookClass">Show All Records</a> <%
			}
		 }
	 if(searchBookClassList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="lib?method=showBookClass">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"],[2,"<%= SEARCH_NAME %>"],[3,"<%= BOOK_CATEGORY_ID %>"],[4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd =7;
	</script></div>
<div class="Clear"></div>
<form name="bookClass" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasBookClass"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ClassName">
<input type="hidden" name="title" value="Book Class"> <input
	type="hidden" name="<%=JSP_NAME %>" value="bookClass"> <input
	type="hidden" name="pojoPropertyCode" value="ClassCode">

<div class="division"></div>
<label class="common"><span>*</span>Class Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Class Code,string,yes" maxlength="10" tabindex=1 /> <label
	class="common"><span>*</span>Class Name</label> <input type="text"
	name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value=""
	validate="Class Name,string,yes" maxlength="20" tabindex=1 /> <script>
				document.bookClass.<%=CODE%>.focus();
			</script> <label class="common"><span>*</span>Category Name</label> <select
	name="<%= BOOK_CATEGORY_ID %>" tabindex=1
	validate="Category Name,string,yes" />
	<option value="0">Select</option>
	<% 
    			for (MasBookCategory  masbookCategory : bookCategoryList){
    		%>
	<option value="<%=masbookCategory.getId ()%>"><%=masbookCategory.getBookCategoryName()%></option>

	<%}%>
</select>
<div class="division"></div>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=addBookClass');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookClass','lib?method=editBookClass');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('bookClass','lib?method=deleteBookClass&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />

<div class="division"></div>

<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>



<div class="Clear"></div>
</form>

</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Class Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Class Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Category Name"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%=BOOK_CATEGORY_ID %>";

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_DATE %>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = "15%";
data_header[5][3] = "<%= CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator<MasBookClass> itr=searchBookClassList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasBookClass  masbookClass = (MasBookClass)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masbookClass.getId()%>"
data_arr[<%= counter%>][1] = "<%=masbookClass.getClassCode()%>"



data_arr[<%= counter%>][2] = "<%= masbookClass.getClassName()%>"


<%
		Iterator<MasBookCategory> itrGridBookCategoryList=gridBookCategoryList.iterator();
		 while(itrGridBookCategoryList.hasNext())
            {try{
             MasBookCategory  bookCategoryGrid = (MasBookCategory)itrGridBookCategoryList.next(); 
			 if(masbookClass.getBookCategory().getId().equals(bookCategoryGrid.getId()) && bookCategoryGrid.getStatus().equals("y")){%>
				data_arr[<%= counter%>][3] = "<%=bookCategoryGrid.getBookCategoryName()%>"
			<%}else if(masbookClass.getBookCategory().getId().equals(bookCategoryGrid.getId()) && bookCategoryGrid.getStatus().equals("n")){%>
				data_arr[<%= counter%>][3] = "<font id='error'>*</font>Parent InActivated--<%=bookCategoryGrid.getBookCategoryName()%>";
				
			<%}
            }catch(Exception e){System.out.println("Exception in poolCategory ----> "+e);}}
%>

data_arr[<%= counter%>][4] = "<%= masbookClass.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masbookClass.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masbookClass.getLastChgTime() %>"
<% if(masbookClass.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
          
%>
 
formName = "bookClass"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
