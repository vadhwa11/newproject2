<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasLinenWeight"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>


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
	ArrayList<MasLinenWeight> searchLinenWeightList = (ArrayList<MasLinenWeight>)map.get("searchLinenWeightList");
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
<script>
function weightCheck(){
var weight;
weight = document.getElementById('weight').value;
if(weight == ""){
alert("Weight cannot be blank")
return false;
} else if(weight == '0'){
alert("Weight cannot be 0,Please Check")
return false;
}
else{
return true;
}
}
</script>

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
<div id="contentHolder">
<div class="Clear"></div>
<h6>Linen Weight Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Item
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" /> <label>Item Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radio" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Item Name,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'laundry?method=searchLinenWeight')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','laundry?method=searchLinenWeight','checkSearch')"
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
	if(searchLinenWeightList.size()>0)
	 {
		String strForCode = (String)map.get("linenCode");
		String strForCodeDescription = (String)map.get("linenName");
		if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
		{
	%> <a href="laundry?method=showLinenWeightJsp">Show All Records</a> <%
			}
		 }
	 if(searchLinenWeightList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="laundry?method=showLinenWeightJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"],[1,"<%= CODE%>"],[2,"<%= SEARCH_NAME%>"],[3,"<%= WEIGHT%>"],[4,"<%= CHANGED_BY%>"],[5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd =7;
	</script></div>
<div class="Clear"></div>
<form name="linen" method="post" action=""><input type="hidden"
	name="<%= POJO_NAME %>" value="MasLinenWeight"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ItemName">
<input type="hidden" name="title" value="Linen Weight Master"> <input
	type="hidden" name="<%=JSP_NAME %>" value="linenWeightMaster">
<input type="hidden" name="pojoPropertyCode" value="ItemCode">

<div class="division"></div>
<label class="common"><span>*</span>Item Code</label> <input id="codeId"
	type="text" name="<%=CODE%>" value="" validate="Item Code,string,yes"
	maxlength="10" tabindex=1
	onkeypress="return submitenter(this,event,'laundry?method=addLaundry ')" />

<script>
				document.linen.<%=CODE%>.focus();
			</script> <label class="common"><span>*</span> Item Name</label> <input
	id="<%= SEARCH_NAME%>" type="text" name="<%= SEARCH_NAME%>" value=""
	validate="Item Name,string,yes" maxlength="25" tabindex=1 /> <label
	class="common"><span>*</span>Weight</label> <input id="weight"
	type="text" name="<%= WEIGHT%>" value="" validate="Weight,float,no"
	maxlength="6" tabindex=1 /> kg
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>



<input type="button" name="add" id="addbutton" value="Save"
	class="button"
	onClick="if(weightCheck()&& checkSpecialChar()){submitForm('linen','laundry?method=addLinenWeight');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(weightCheck() && checkSpecialChar()){submitForm('linen','laundry?method=editLinenWeight');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('linen','laundry?method=deleteLinenWeight&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
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
data_header[0][0] = "Item Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Item Name"
data_header[1][1] = "data";
data_header[1][2] = "25%";
data_header[1][3] = "<%= SEARCH_NAME%>"

data_header[2] = new Array;
data_header[2][0] = "Weight"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "<%= WEIGHT%>"


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
Iterator<MasLinenWeight> itr=searchLinenWeightList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            MasLinenWeight  masLinen = (MasLinenWeight)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= masLinen.getId()%>"
data_arr[<%= counter%>][1] = "<%=masLinen.getItemCode()%>"
data_arr[<%= counter%>][2] = "<%=masLinen.getItemName()%>"
<%if(masLinen.getWeight() != null){%>
data_arr[<%= counter%>][3] = "<%=masLinen.getWeight()%>"
<%}%>
data_arr[<%= counter%>][4] = "<%= masLinen.getLastChgBy() %>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masLinen.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masLinen.getLastChgTime() %>"
<% if(masLinen.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "linen"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
