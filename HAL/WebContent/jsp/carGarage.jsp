<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasCarGarage"%>
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
	ArrayList<MasCarGarage> searchCarGarageList = (ArrayList<MasCarGarage>)map.get("searchCarGarageList");
	String userName = "";
	if(session.getAttribute("userName") != null)
	{
		userName = (String)session.getAttribute("userName");
	}
	String message="";
	if(map.get("message") != null){
	 	message = (String)map.get("message");
%>

<h4><span><%=message %></span></h4>
<div class="Clear"></div>
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
<div class="titleBg">
<h2>Car Garage</h2>
</div>
<div class="Clear"></div>

<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Car Garage Code</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>" value="1"	checked="checked" class="radioAuto" /> 
<label>Car Garage Name</label> <input
	type="radio" name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" /> <input
	type="text" id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Car Garage Code,string,no" MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=searchCarGarage')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','accom?method=searchCarGarage','checkSearch')"
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
		if(searchCarGarageList.size()>0)
		 {
			String strForCode = (String)map.get("carGarageCode");
			String strForCodeDescription = (String)map.get("carGarageName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%>
<div class="Clear"></div>
<h4><a href="accom?method=showCarGarageJsp">Show All Records</a></h4>
<div class="Clear"></div>
<%
			}
		 }
	 if(searchCarGarageList.size()==0 && map.get("search") != null)
	  {
	 %>
<div class="Clear"></div>
<h4><a href="accom?method=showCarGarageJsp">Show All Records</a></h4>
<div class="Clear"></div>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<form name="poolCategory" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasCarGarage"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="CarGarageName">
<input type="hidden" name="title" value="CarGarage"> <input
	type="hidden" name="<%=JSP_NAME %>" value="carGarage"> <input
	type="hidden" name="pojoPropertyCode" value="CarGarageCode"> 
	<div class="Block">
	<label
	class="common"><span>*</span> Car Garage Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Car Garage Code,string,yes" maxlength="8" tabindex=1 /> <label
	class="common"><span>*</span> Car Garage Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" id="<%= SEARCH_NAME %>" value=""
	validate="Car Garage Name,string,yes" maxlength="30" tabindex=1
	onkeypress="return submitenter(this,event,'accom?method=addCarGarage ')" />
<script>
				document.poolCategory.<%=CODE%>.focus();
			</script>
			<div class="clear"></div>
</div>
<div class="division"></div>
			<div class="clear"></div>
<input type="button" name="add" id="addbutton"
	value="Save" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=addCarGarage');}"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('poolCategory','accom?method=editCarGarage');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('poolCategory','accom?method=deleteCarGarage&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex="1" /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" />
			<div class="clear"></div>
<div class="division"></div>
			<div class="clear"></div>
			<div class="bottom">
<label>Changed By:</label> <label class="value"><%=userName%></label> <label>Changed
Date:</label> <label class="value"><%=date%></label> <label>Changed Time:</label>
<label class="value"><%=time%></label></div>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>

<div id="edited"></div>



<div class="Clear"></div>
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Car Garage Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Car Garage Name"
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
Iterator<MasCarGarage> itr=searchCarGarageList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
        	  MasCarGarage  masCarGarage = (MasCarGarage)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masCarGarage.getId()%>
data_arr[<%= counter%>][1] = "<%=masCarGarage.getCarGarageCode()%>"
data_arr[<%= counter%>][2] = "<%= masCarGarage.getCarGarageName()%>"

data_arr[<%= counter%>][3] = "<%= masCarGarage.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masCarGarage.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masCarGarage.getLastChgTime() %>"
<% if(masCarGarage.getStatus().equals("y")){ %>
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
