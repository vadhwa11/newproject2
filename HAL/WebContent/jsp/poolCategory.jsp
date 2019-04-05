<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasPoolCategory"%>
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
	ArrayList<MasPoolCategory> searchPoolCategoryList = (ArrayList<MasPoolCategory>)map.get("searchPoolCategoryList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>
<%} %>
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
<h4><span><%=message %></span></h4>
<div class="titleBg">
<h2>Pool Category</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label >Pool Category Code</label> <input type="radio"
	name="<%=SELECTED_RADIO  %>" class="radioAuto" value="1" checked="checked" />
<label class="NoWidth">Pool Category Name</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Pool Category Code,string,no" MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=searchPoolCategory')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','accom?method=searchPoolCategory','checkSearch')"
	tabindex=1 /></div>
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
		if(searchPoolCategoryList.size()>0)
		 {
			String strForCode = (String)map.get("poolCategoryCode");
			String strForCodeDescription = (String)map.get("poolCategoryName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h4><a href="accom?method=showPoolCategoryJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchPoolCategoryList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h4><a href="accom?method=showPoolCategoryJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="Clear"></div>
<form name="poolCategory" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasPoolCategory">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="PoolCategoryName"> <input type="hidden" name="title"
	value="PoolCategory"> <input type="hidden"
	name="<%=JSP_NAME %>" value="poolCategory"> <input
	type="hidden" name="pojoPropertyCode" value="PoolCategoryCode">

<div class="Block">
<label class="common"><span>*</span> Pool Category Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Pool Category Code,string,yes" maxlength="8" tabindex=1 /> <label
	class="common"><span>*</span> Pool Category Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value=""
	validate="Pool Category Name,string,yes" maxlength="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=addPoolCategory ')" />
<script>
				document.poolCategory.<%=CODE%>.focus();
			</script>
<div class="Clear"></div></div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=addPoolCategory');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=editPoolToCategory');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('poolCategory','accom?method=deletePoolCategory&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
	<div class="Clear"></div>
<div class="division"></div>
<div class="bottom">
<div class="Clear"></div>
<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
Date:</label> <label class="value"><%=date%></label> <label>Changed Time:</label>
<label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Pool Category Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Pool Category Name"
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
Iterator<MasPoolCategory> itr=searchPoolCategoryList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasPoolCategory  masPoolCat = (MasPoolCategory)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masPoolCat.getId()%>
data_arr[<%= counter%>][1] = "<%=masPoolCat.getPoolCategoryCode()%>"
data_arr[<%= counter%>][2] = "<%= masPoolCat.getPoolCategoryName()%>"

data_arr[<%= counter%>][3] = "<%= masPoolCat.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masPoolCat.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masPoolCat.getLastChgTime() %>"
<% if(masPoolCat.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "poolCategory"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>