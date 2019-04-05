
<%@page import="jkt.hms.masters.business.MasSession"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>


<SCRIPT language=javascript src="/hms/jsp/js/calendar.js"	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/common.js"
	type=text/javascript></SCRIPT>

<SCRIPT language=javascript src="/hms/jsp/js/hms.js"
	type=text/javascript></SCRIPT>
<script>
	<%
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String dateCal=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(Calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(dateCal.length()<2){
			dateCal="0"+dateCal;
		}
		
			
	%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>';
</script>
<%
Map map = new HashMap();
if(request.getAttribute("map") != null)
{
	map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");
ArrayList<MasSession> searchSessionList = (ArrayList<MasSession>)map.get("searchSessionList");
String userName = "";
if(session.getAttribute("userName") != null){
	userName = (String)session.getAttribute("userName");
}


if(map.get("message") != null){
	   String message = (String)map.get("message");
	    	   %>
	   <h4><%=message %></h4>
	   <% 
	  }

%>
<div class="titleBg">
<h2>Session Master</h2>
</div>
<div class="clear"></div>

<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Session Name</label> <input type="text" id="searchField" name="<%= SEARCH_NAME%>"	value="" validate="Session Name,string,no" MAXLENGTH="8" tabindex=1	onkeypress="return submitenter(this,event,'hospital?method=searchSession')" />
<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','hospital?method=searchSession','checkSearch')"	tabindex=1 />
 <%--- Report Button   --%> 
 <input type="button"	name="Report" value="Generate Report" class="buttonBig"	onClick="submitForm('search','generalMaster?method=generateReportForGeneralMasters');"	accesskey="g" tabindex=1 /> 
 <input type="hidden"	name="<%=JASPER_FILE_NAME%>" value="Mas_session">
  
 </form>
</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="clear"></div>
<div id="searchresults" tabindex=1>
<div id="searchtable" tabindex=1></div>

<% 
		if(searchSessionList.size()>0)
		 {
			String strForAddressDescription = (String)map.get("sessionName");
			if(strForAddressDescription!= null && strForAddressDescription!= "")
			{
	%> <a href="hospital?method=showSessionJsp">Show All Records</a> <%
			}
		 }
	 if(searchSessionList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="hospital?method=showSessionJsp">Show All Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= SEARCH_NAME%>"], [2,"<%= FROM_TIME%>"],[3,"<%= TO_TIME%>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="session" method="post" action="">


 
<input type="hidden"	name="<%= POJO_NAME %>" value="MasSession"> 
<input type="hidden"	name="<%=POJO_PROPERTY_NAME %>" value="SessionName">
 <input	type="hidden" name="title" value="Session"> 
 <input type="hidden"	name="<%=JSP_NAME %>" value="session"> 
 <input type="hidden"	name="pojoPropertyName" value="SessionName">

<div class="paddingTop15"></div>
<div class="clear"></div>
<div class="Block">
<label><span>*</span>Session Name</label> 
<input	type="text" name="<%= SEARCH_NAME %>" value=""	validate="Session Name,metachar,yes" class="textbox_size20" MAXLENGTH="30"	tabindex=1> 
	<script>
		document.session.<%=SEARCH_NAME%>.focus();
	</script>

<label><span>*</span>From Time</label> 
<input type="text"    id="<%= FROM_TIME %>"  name="<%= FROM_TIME %>" onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);"  maxlength="5" validate="From Time,string,yes"/>

<label><span>*</span>To Time</label> 
<input type="text"   id="<%= TO_TIME %>"  name="<%= TO_TIME %>"  onKeyUp="mask(this.value,this,'2',':');"	onBlur="IsValidTime(this.value,this.id);"  maxlength="5" validate="To Time,string,yes"/>
	
	
<div class="clear"></div></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div id="edited"></div>

<input type="button" name="add" id="addbutton" value="Add" 	class="button" onClick="submitForm('session','hospital?method=addSession');"	accesskey="a" tabindex=1 /> 
<input type="button" name="edit"	id="editbutton" value="Update" class="button" style="display: none;"	onClick="submitForm('session','hospital?method=editSession')" accesskey="u"	tabindex=1 /> 
<input type="button" name="Delete" id="deletebutton"	value="Activate" class="button" style="display: none;"	onClick="submitForm('session','hospital?method=deleteSession&flag='+this.value)"	accesskey="d" tabindex=1 />
 <input type="reset" name="Reset"	id="reset" value="Reset" class=button	onClick="submitForm('session','hospital?method=showSessionJsp')"  accesskey="r" /> 
 <input type="hidden"	name="<%=STATUS %>" value="" /> 
 <input type="hidden"	name="<%= COMMON_ID%>" value="" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div class="bottom">
<label>Changed By:</label> 
<label	class="value"><%=userName%></label> 
<label>Changed Date:</label> 
<label	class="value"><%=date%></label> 
<label>Changed Time:</label> 
<label	class="value"><%=time%></label> 
<input type="hidden"	name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input type="hidden"	name="<%=CHANGED_DATE %>" value="<%=date%>" /> 
<input type="hidden"	name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>

 


</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Session Name"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= SEARCH_NAME%>"



	data_header[1] = new Array;
	data_header[1][0] = "From Time"
	data_header[1][1] = "data";
	data_header[1][2] = "25%";
	data_header[1][3] = "<%= FROM_TIME%>"
	

		data_header[2] = new Array;
		data_header[2][0] = "To Time"
		data_header[2][1] = "data";
		data_header[2][2] = "25%";
		data_header[2][3] = "<%= TO_TIME%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_BY %>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "0";
data_header[4][3] = "<%= CHANGED_DATE %>";

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%=CHANGED_TIME %>";

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchSessionList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasSession  masSession = (MasSession)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masSession.getId()%>
data_arr[<%= counter%>][1] = "<%=masSession.getSessionName()%>"

data_arr[<%= counter%>][2] = "<%= masSession.getFromTime()%>"
data_arr[<%= counter%>][3] = "<%= masSession.getToTime()%>"





data_arr[<%= counter%>][4] = "<%= masSession.getLastChgBy()!=null?(masSession.getLastChgBy().getId()!=null?masSession.getLastChgBy().getId():"0" ):"0"%>"
data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(masSession.getLastChgDate()) %>"
data_arr[<%= counter%>][6] = "<%= masSession.getLastChgTime() %>"
<% if(masSession.getStatus().equals("Y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}
%>
 
formName = "session"


start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
