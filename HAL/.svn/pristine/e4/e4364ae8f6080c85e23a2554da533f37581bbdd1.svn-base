<!-------------------------Sanction Authority Master----------------------------->
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MdMasAuthority"%>

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
	 document.getElementById('search_name').value=""
	 document.getElementById('codeId').value=""
	 return false;
	 }else if(code.match("\<")|| name.match("\<")){
	 alert('Please Do not enter < as Entry field')
	 document.getElementById('search_name').value=""
	  document.getElementById('codeId').value=""
	 return false;
	 }
	 else{
	 return true;
	 }
}

</script>

<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchAuthorityList = (ArrayList)map.get("searchAuthorityList");
	
	String userName = "";
	String message ="";
	
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<h6>Sanction Authority Master</h6>
<div class="Clear"></div>
<div class="header">
<div id="searcharea">
<div id="searchbar">

<form name="search" method="post" action=""><label>Authority
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" tabindex=1 /> <label>Authority
Name</label> <input type="radio" name="<%=SELECTED_RADIO %>" value="2"
	class="radio" /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="Authority Code,string,no"
	MAXLENGTH="20" tabindex=1
	onkeypress="return submitenter(this,event,'mediClaim?method=searchAuthority')"
	tabindex=1 /> <input type="button" name="search" value="Search"
	class="cmnButton"
	onclick="submitForm('search','mediClaim?method=searchAuthority','checkSearch')"
	tabindex=1 /></form>

</div>

</div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchAuthorityList.size()>0)
   {
   String strForCode = (String)map.get("authorityCode");
   String strForCodeDescription = (String)map.get("authorityName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <a href="mediClaim?method=showAuthorityJsp">Show All Records</a> <%
			}
		 }
	if(searchAuthorityList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="mediClaim?method=showAuthorityJsp">Show All Records</a> <%
  }
	%> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%=CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
  statusTd = 6;
 </script></div>
<div class="Clear"></div>
<form name="authority" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MdMasAuthority"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="AuthorityName">
<input type="hidden" name="authority" value="Authority"> <input
	type="hidden" name="<%=JSP_NAME %>" value="md_authority"> <input
	type="hidden" name="pojoPropertyCode" value="AuthorityCode">

<div class="blockFrame"><label><span>*</span> Authority
Code </label> <input id="codeId" type="text" name="<%= CODE%>" value=""
	validate="Authority Code,string,yes" class="textbox_size20"
	MAXLENGTH="10" tabindex=1 /> <label><span>*</span> Authority
Name</label> <input id="search_name" type="text" name="<%= SEARCH_NAME %>"
	value="" validate="Authority Name,string,yes" class="textbox_size20"
	MAXLENGTH="20" tabindex=1
	onkeypress="return submitenter(this,event,'mediClaim?method=addAuthority')" />
<script>
	    document.authority.<%=CODE%>.focus();
	   </script> <input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" />
<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" /></div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<div class="bottom"><input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="if(checkSpecialChar());submitForm('authority','mediClaim?method=addAuthority');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="if(checkSpecialChar()){submitForm('authority','mediClaim?method=editAuthority');}"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('authority','mediClaim?method=deleteAuthority&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex=1 />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=STATUS %>" value="" /> <input type="hidden"
	name="<%= COMMON_ID%>" value="" />
</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Authority Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Authority Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = ""
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "<%= CHANGED_BY%>"

data_header[3] = new Array;
data_header[3][0] = ""
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "<%= CHANGED_DATE%>"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = "15%";
data_header[4][3] = "<%=CHANGED_TIME %>";

data_header[5] = new Array;
data_header[5][0] = "Status"
data_header[5][1] = "data";
data_header[5][2] = "15%";
data_header[5][3] = "<%=STATUS %>";

data_arr = new Array();

<%
Iterator itr=searchAuthorityList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MdMasAuthority  masAuthority = (MdMasAuthority)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masAuthority.getId()%>
data_arr[<%= counter%>][1] = "<%=masAuthority.getAuthorityCode()%>"
data_arr[<%= counter%>][2] = "<%= masAuthority.getAuthorityName()%>"

data_arr[<%= counter%>][3] = "<%= masAuthority.getLastChgBy() %>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(masAuthority.getLastChgDate()) %>"
data_arr[<%= counter%>][5] = "<%= masAuthority.getLastChgTime() %>"
<% if(masAuthority.getStatus().equals("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else{%>
data_arr[<%= counter%>][6] = "InActive"
<%}%>
<%
       counter++;
}
%>
 
formName = "authority"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>