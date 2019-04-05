<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasHospital;"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">
<br />
<div id="contentspace">
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
	 map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	ArrayList searchHospitalList = (ArrayList)map.get("searchHospitalList");
	String userName = "";
	if(session.getAttribute("userName") != null){
	 userName = (String)session.getAttribute("userName");
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<h2 align="left" class="style1">Hospital Master</h2>

<div id="searcharea">

<div id="searchbar">

<form name="search" method="post" action=""><input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <font
	class="bodytextB_blue">Hospital Code:</font> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" /> <font class="bodytextB_blue">Hospital
Name:</font> <input type="text" name="<%= SEARCH_FIELD%>" value=""
	validate="Hospital Code,string,no" MAXLENGTH="8" tabindex=1 /> <input
	type="submit" name="search" value="Search" class="button"
	onclick="submitForm('search','superAdmin?method=searchHospital')"
	tabindex=1 /></form>

</div>

</div>

<br />
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<% 
  if(searchHospitalList.size()>0)
   {
   String strForCode = (String)map.get("hospitalCode");
   String strForCodeDescription = (String)map.get("hospitalName");
   if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
   {
 %> <a href="superAdmin?method=showHospitalJsp">Show All Records</a> <%
   }
   }
   if(searchHospitalList.size()==0)
    {
 %> <a href="superAdmin?method=showHospitalJsp">Show All Records</a> <%
       }
 %> <script type="text/javascript">
 
 formFields = [
   [0, "<%= COST_CENTER_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= ADDRESS1 %>"][4,"<%= PHONE_NO %>"] [5,"addEditBy"], [6,"addEditOn"],[7,"<%=STATUS%>"] ];
  statusTd = 7;
 </script></div>
<br />
<form name="hospital" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasHospital"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="HospitalName">
<input type="hidden" name="<%=JSP_NAME %>" value="hospital"> <input
	type="hidden" name="pojoPropertyCode" value="HospitalCode"> <br>


<div id=contentoperation><span class="bodytextB_blue"><font
	id="error">*</font> Hospital Code: </span> <input type="text"
	name="<%= CODE%>" value="" validate="Hospital Code,string,yes"
	class="textbox_size20" MAXLENGTH="8" / tabindex=1>
<div id=biglabel class="bodytextB_blue"><font id="error">*</font>
Hospital Name:</div>
<input type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Hospital Name,string,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1>
<div id=biglabel class="bodytextB_blue"><font id="error">*</font>
Address:</div>
<input type="text" name="<%= ADDRESS %>" value=""
	validate="Address,address,yes" class="textbox_size20" MAXLENGTH="30"
	/ tabindex=1>
<div id=biglabel class="bodytextB_blue"><font id="error">*</font>
Contact Number:</div>
<input type="text" name="<%= PHONE_NO %>" value=""
	validate="Contact Number,phone,yes" class="textbox_size20"
	MAXLENGTH="30" / tabindex=1> <script>
    document.hospital.<%=CODE%>.focus();
   </script> <br />
<br />

<span class="labeltext">Changed By:</span> <input type="text"
	name="<%= CHANGED_BY%>" value="<%=userName%>" class="textbox_size20"
	readonly="readonly" MAXLENGTH="8" / tabindex=3 />

<div id=biglabel class="labeltext">Changed Date:</div>
<input type="text" name="<%= CHANGED_DATE %>" value="<%=date%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <span
	class="labeltext">Changed Time:</span> <input type="text"
	name="<%=CHANGED_TIME %>" value="<%=time%>" class="textbox_size20"
	readonly="readonly" tabindex=3 /></div>

<br />

<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('hospital','superAdmin?method=addHospital');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('hospital','superAdmin?method=editHospital')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('hospital','superAdmin?method=deleteHospital')"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset"
	value="Reset" class="button" accesskey="r" onclick="clearRecords(this)"
	tabindex=1 /> <input type="button" name="Back" value="Back"
	class="button" accesskey="b"
	onclick="submitFormForButton('hospital','superAdmin?method=showModuleManagementJsp')"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Hospital Code"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Hospital Name"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= SEARCH_NAME %>";

data_header[2] = new Array;
data_header[2][0] = "Address"
data_header[2][1] = "hide";
data_header[2][2] = 0;
data_header[2][3] = "aaa"

data_header[3] = new Array;
data_header[3][0] = "Contact Number"
data_header[3][1] = "hide";
data_header[3][2] = 0;
data_header[3][3] = "bbb"

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "addEditBy"

data_header[5] = new Array;
data_header[5][0] = "Admin"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "addEditOn"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%


Iterator itr=searchHospitalList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             MasHospital  masHospital = (MasHospital)itr.next();   

%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= masHospital.getId()%>
data_arr[<%= counter%>][1] = "<%=masHospital.getHospitalCode()%>"
data_arr[<%= counter%>][2] = "<%= masHospital.getHospitalName()%>"
data_arr[<%= counter%>][3] = "<%= masHospital.getAddress() %>"
data_arr[<%= counter%>][4] = "<%= masHospital.getContactNumber() %>"
data_arr[<%= counter%>][5] = "<%= masHospital.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= masHospital.getLastChgDate() %>"
<% if(masHospital.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
       counter++;
}
%> 
formName = "hospital"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
 end = data_arr.length;
else
 end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');  
</script>