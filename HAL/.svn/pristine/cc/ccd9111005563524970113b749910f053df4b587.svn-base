<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
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
	ArrayList<MasBookCategory> searchBookCategoryList = (ArrayList<MasBookCategory>)map.get("searchBookCategoryList");
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
<h6>Book Category Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label
	class="NoWidth">Book Category Code</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" class="radio" value="1" checked="checked" />
<label class="NoWidth">Book Category Name</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radio" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Book Category Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'lib?method=searchBookCategory')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','lib?method=searchBookCategory','checkSearch')"
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
		if(searchBookCategoryList.size()>0)
		 {
			String strForCode = (String)map.get("bookCategoryCode");
			String strForCodeDescription = (String)map.get("bookCategoryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="lib?method=showBookCategory">Show All Records</a> <%
			}
		 }
	 if(searchBookCategoryList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="lib?method=showBookCategory">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="Clear"></div>
<form name="bookCategory" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasBookCategory">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="BookCategoryName"> <input type="hidden" name="title"
	value="BookCategory"> <input type="hidden"
	name="<%=JSP_NAME %>" value="bookCategory"> <input
	type="hidden" name="pojoPropertyCode" value="BookCategoryCode">

<div class="division"></div>
<label class="common"><span>*</span>Book Category Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Book Category Code,string,yes" maxlength="10" tabindex=1 />

<label class="common"><span>*</span>Book Category Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value=""
	validate="Book Category Name,string,yes" maxlength="20" tabindex=1
	onkeypress="return submitenter(this,event,'lib?method=addBookCategory ')" />
<script>
				document.bookCategory.<%=CODE%>.focus();
			</script>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>



<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="if(checkSpecialChar()){submitForm('bookCategory','lib?method=addBookCategory');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('bookCategory','lib?method=editBookCategory');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('bookCategory','lib?method=deleteBookCategory&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Book Category Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Book Category Name"
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
Iterator<MasBookCategory> itr=searchBookCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasBookCategory  masBookCat = (MasBookCategory)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masBookCat.getId()%>
data_arr[<%= counter%>][1] = "<%=masBookCat.getBookCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masBookCat.getBookCategoryName()%>"

data_arr[<%= counter%>][3] = "<%= masBookCat.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masBookCat.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masBookCat.getLastChgTime() %>"
<% if(masBookCat.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "bookCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
