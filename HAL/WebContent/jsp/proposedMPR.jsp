
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasProposedMPR"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
	ArrayList searchProposedMPRList = (ArrayList)map.get("searchProposedMPRList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><%=message%></h4>
  <% }%>
<div class="titleBg">
<h2>Proposed For MPR </h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Proposed MPR Code</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" />
<label>Proposed MPR Name</label>
<input type="radio" class="radioAuto"	name="<%=SELECTED_RADIO %>" value="2" />
<input type="text" id="searchField" name="<%= SEARCH_FIELD%>" value="" validate="ProposedMPR Code,string,no" MAXLENGTH="8" tabindex=1 onkeypress="return submitenter(this,event,'generalMaster?method=searchProposedMPR')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','generalMaster?method=searchProposedMPR','checkSearch')"	tabindex="1" />
<%--- Report Button   --%>
<input type="button"	name="Report" value="Generate Report Based on Search" class="buttonBig3" onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex="1" />
<input type="hidden" name="<%=JASPER_FILE_NAME%>" value="Mas_proposedMPR">
</div>
</form>
</div>
</div>
<div class="Clear"></div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchProposedMPRList.size()>0)
		 {
			String strForCode = (String)map.get("proposedMPRCode");
			String strForCodeDescription = (String)map.get("proposedMPRName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <h2><a href="generalMaster?method=showProposedMPRJsp">Show All Records</a> </h2>
<%
			}
		 }
	 if(searchProposedMPRList.size()==0 && map.get("search") != null)
	  {
	 %> <h2><a href="generalMaster?method=showProposedMPRJsp">Show All Records</a> </h2>
	 <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
	 statusTd = 6;
	</script>
	</div>
<div class="Clear paddingTop15"></div>	
<form name="proposedMPR" method="post" action="">
<input	type="hidden" name="<%= POJO_NAME %>" value="MasProposedMPR">
<input	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ProposedMPRName">
<input type="hidden" name="title" value="ProposedMPR">
<input type="hidden" name="<%=JSP_NAME %>" value="proposedMPR">
<input type="hidden" name="pojoPropertyCode" value="ProposedMPRCode"> 
<div class="Clear"></div>
<div class="Block">
<label > Proposed MPR Code <span>*</span></label>
<input id="codeId" type="text"	name="<%= CODE%>" value="" validate="ProposedMPR Code,string,yes"	 MAXLENGTH="8" tabindex=1 />
<label> Proposed MPR Name <span>*</span></label>
<input type="text" name="<%= SEARCH_NAME %>" value="" validate="ProposedMPR Name,string,yes" MAXLENGTH="30" tabindex=1	onkeypress="return submitenter(this,event,'generalMaster?method=addProposedMPR')">
<script>
document.proposedMPR.<%=CODE%>.focus();
</script> 
</div>
<div class="Clear"></div>
<div id="edited"></div>
<div class="Clear"></div>
<div class="proposedMPR"></div>
<div class="Clear"></div>
<input type="button" name="add" id="addbutton"	value="Add" class="button"	onClick="submitForm('proposedMPR','generalMaster?method=addProposedMPR');"accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('proposedMPR','generalMaster?method=editProposedMPR')" accesskey="u" tabindex=1 />
<input type="button" name="Delete"	id="deletebutton" value="Activate" class="button" onClick="submitForm('proposedMPR','generalMaster?method=deleteProposedMPR&flag='+this.value)" accesskey="d" tabindex=1 />
<input type="reset" name="Reset" id="reset"	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />
<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="proposedMPR"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label class="value"><%=userName%></label>
<label>Changed Date:</label>
<label class="value"><%=date%></label>
<label>Changed Time:</label>
<label class="value"><%=time%></label>
<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" />
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>
</form>
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "ProposedMPR Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "ProposedMPR Name"
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
Iterator itr=searchProposedMPRList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasProposedMPR  masProposedMPR = (MasProposedMPR)itr.next(); 
             
			%>data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masProposedMPR.getId()%>
data_arr[<%= counter%>][1] = "<%=masProposedMPR.getProposedMPRCode()%>"
data_arr[<%= counter%>][2] = "<%= masProposedMPR.getProposedMPRName()%>"
data_arr[<%= counter%>][3] = "<%= masProposedMPR.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masProposedMPR.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masProposedMPR.getLastChgTime() %>"
<% if(masProposedMPR.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "proposedMPR"
nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
