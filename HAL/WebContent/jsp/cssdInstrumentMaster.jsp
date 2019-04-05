<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.CssdInstrumentMaster"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>

<script language="Javascript">
function changeLengthOfTextBox(len)
{
document.getElementById("searchField").value="";
document.getElementById("searchField").maxLength = len;
}

</script>


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
	ArrayList<CssdInstrumentMaster> instrumentMasterList = (ArrayList<CssdInstrumentMaster>)map.get("instrumentMasterList");
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
<h6>Instrument Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action=""><label>Instrument
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" onChange="changeLengthOfTextBox('10');" />
<label>Instrument Name</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radio"
	onChange="changeLengthOfTextBox('25');" /> <input type="text"
	id="searchField" name="<%= SEARCH_FIELD%>" value=""
	validate="Instrument Code/Name,goodString,no" MAXLENGTH="10" tabindex=1
	onkeypress="return submitenter(this,event,'cssd?method=searchInstrumentMaster')" />
<input type="button" name="search" value="Search" class="cmnButton"
	onclick="submitForm('search','cssd?method=searchInstrumentMaster')"
	tabindex=1 />
	
	<%--- Report Button   --%> 
<input type="button" name="Report" value="Generate Report Based on Search" class="cmnButton" onClick="submitForm('search','hospital?method=generateReportForHospitalRelatedMasters');" accesskey="g" tabindex=1 /> 
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="mas_cssd_instrument">
	
	</form>
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
<div align="left"><a href="cssd?method=showInstrumentMasterJsp">Show
All Records</a></div>
<%
		 }
	%> <script type="text/javascript">
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script></div>
<div class="Clear"></div>
<form name="instrumentMaster" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="CssdInstrumentMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="InstrumentName"> <input type="hidden" name="title"
	value="Instrument Master"> <input type="hidden"
	name="<%=JSP_NAME %>" value="cssdInstrumentMaster"> <input
	type="hidden" name="pojoPropertyCode" value="InstrumentCode">

<div class="division"></div>
<label class="common"><span>*</span> Instrument Code</label> <input
	id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Instrument Code,goodString,yes" maxlength="10" tabindex=1 />

<label class="common"><span>*</span> Instrument Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Instrument Name,goodString,yes" maxlength="25" tabindex=1
	onkeypress="return submitenter(this,event,'cssd?method=addInstrumentMaster')" />
<script>
				document.instrumentMaster.<%=CODE%>.focus();
			</script>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="Clear"></div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>



<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="submitForm('instrumentMaster','cssd?method=addInstrumentMaster');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('instrumentMaster','cssd?method=editInstrumentMaster')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('instrumentMaster','cssd?method=deleteInstrumentMaster&flag='+this.value)"
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
data_header[0][0] = "Instrument Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Instrument Name"
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
Iterator<CssdInstrumentMaster> itr= instrumentMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            CssdInstrumentMaster  cssdInstrumentMaster = (CssdInstrumentMaster)itr.next(); 
             
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= cssdInstrumentMaster.getId()%>
data_arr[<%= counter%>][1] = "<%=cssdInstrumentMaster.getInstrumentCode()%>"
data_arr[<%= counter%>][2] = "<%=cssdInstrumentMaster.getInstrumentName()%>"

data_arr[<%= counter%>][3] = "<%= cssdInstrumentMaster.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(cssdInstrumentMaster.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= cssdInstrumentMaster.getLastChgTime() %>"
<% if(cssdInstrumentMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "instrumentMaster"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
