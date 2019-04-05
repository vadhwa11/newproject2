<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdMaterialMaster"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>

<script language="Javascript">
function changeLengthOfTextBox(len)
{
document.getElementById("searchField").value="";
document.getElementById("searchField").maxLength = len;
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
	ArrayList<CssdMaterialMaster> materialMasterList = (ArrayList<CssdMaterialMaster>)map.get("materialMasterList");
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
<h6>Container Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Container
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" onChange="changeLengthOfTextBox('10');" />
<label>Container Name</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radio"
	onChange="changeLengthOfTextBox('25');" /> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Container Code/Name,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'cssd?method=searchMaterialMaster')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','cssd?method=searchMaterialMaster','checkSearch')"
	tabindex=1 /></form>
</div>
</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults">
<div id="searchtable"></div>

<% 
		if (map.get("search")!=null)
		{
	%> <br />
<div align="left"><a href="cssd?method=showMaterialMasterJsp">Show
All Records</a></div>
<%
		 }
	%> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="Clear"></div>
<form name="materialMaster" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="CssdMaterialMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="MaterialName"> <input type="hidden" name="title"
	value="Material Master"> <input type="hidden"
	name="<%=JSP_NAME %>" value="cssdMaterialMaster"> <input
	type="hidden" name="pojoPropertyCode" value="MaterialCode">

<div class="division"></div>
<label class="common"><span>*</span> Container Code</label>
<input id="codeId" type="text" name="<%= CODE%>" value="" validate="Container Code,string,yes" maxlength="10" tabindex=1 />
<label class="common"><span>*</span> Container Name</label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="Container Name,goodString,yes" maxlength="25" tabindex=1
	onkeypress="return submitenter(this,event,'cssd?method=addMaterialMaster')" />
<script>
				document.materialMaster.<%=CODE%>.focus();
			</script>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>

<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('materialMaster','cssd?method=addMaterialMaster');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('materialMaster','cssd?method=editMaterialMaster')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('materialMaster','cssd?method=deleteMaterialMaster&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
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
data_header[0][0] = "Container Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Container Name"
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
Iterator<CssdMaterialMaster> itr = materialMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            CssdMaterialMaster  cssdMaterialMaster = (CssdMaterialMaster)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= cssdMaterialMaster.getId()%>
data_arr[<%= counter%>][1] = "<%=cssdMaterialMaster.getMaterialCode()%>"
data_arr[<%= counter%>][2] = "<%=cssdMaterialMaster.getMaterialName()%>"
data_arr[<%= counter%>][3] = "<%= cssdMaterialMaster.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(cssdMaterialMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= cssdMaterialMaster.getLastChgTime() %>"
<% if(cssdMaterialMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "materialMaster"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
