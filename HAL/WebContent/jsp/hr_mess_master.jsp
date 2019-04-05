<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrorderlyMessMaster"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%
	Map map = new HashMap();
	if(request.getAttribute("map") != null){
		map = (Map) request.getAttribute("map");
	}
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String date = (String)utilMap.get("currentDate");	 
	String time = (String)utilMap.get("currentTime");
		
	List messMasterList = (List)map.get("messMasterList");
    List masUnitList = (List)map.get("masUnitList");
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	
%>
<%
if(map.get("message") != null){
		   String message = (String)map.get("message");
%>
<h4><span><%=message%></span></h4>
  <%
		  }
%>
<div class="titleBg">
<h2>Mess Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Mess Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>Mess
Name</label> <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" />  <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Search Field Required,string,no" MAXLENGTH="8"
	tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchMess','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="" accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_country"></div></form>
</div>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %> <h4><a href="hrOrderly?method=showMessMasterJsp">Show All Records</a></h4> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"], [3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=UNIT_NAME%>"],[7,"<%=STATUS%>"] ];
	 statusTd = 7;
	</script></div>

<form name="speciality" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrorderlyMessMaster">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="MessName">
<input type="hidden" name="title" value="Mess"> <input
	type="hidden" name="<%=JSP_NAME %>" value="Mess"> <input
	type="hidden" name="pojoPropertyCode" value="MessCode"> 

<div class="Clear"></div>
<div class="blockFrame">
<label><span>*</span> Mess Code</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Speciality Code,string,yes"
	 MAXLENGTH="8" tabindex=1 /> <label><span>*</span> Mess Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Speciality Name,string,yes" 
	MAXLENGTH="30" tabindex=1 /> <script>
				document.speciality.<%=CODE%>.focus();
			</script> <label><span>*</span> Unit
Name</label> <select id="<%=UNIT_NAME %>" name="<%=UNIT_NAME %>"
	validate="Trade Name,string,yes" tabindex=1>
	<option value="">Select</option>
	<%if(masUnitList!=null){
	             Iterator itr = masUnitList.iterator();
	             while(itr.hasNext())
	             {		
	            	MasUnit masUnit= (MasUnit)itr.next(); 
			%>
	<option value="<%=masUnit.getId() %>"><%= masUnit.getUnitName()%></option>
	<%}} %>
</select>

</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('speciality','hrOrderly?method=addMess');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('speciality','hrOrderly?method=editMess')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('speciality','hrOrderly?method=deleteMess&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div class="bottom">
<label>Changed By:</label>
<label  class="value"><%=userName%></label>

<label>Changed Date:</label>
<label  class="value"><%=date%></label>

<label>Changed Time:</label>
<label  class="value"><%=time%></label>

<input type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input
	type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
				<input type="hidden" name="<%=HOSPITAL_ID %>"  value="<%=hospitalId%>" />
	
</div>




</form>
</div>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = " Mess Code"
data_header[0][1] = "data";
data_header[0][2] = "15%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Mess Name"
data_header[1][1] = "data";
data_header[1][2] = "30%";
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
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_TIME %>"

data_header[5] = new Array;
data_header[5][0] = "UnitName"
data_header[5][1] = "data";
data_header[5][2] = "25%";
data_header[5][3] = "<%=UNIT_NAME%>"


data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "data";
data_header[6][2] = "15%";
data_header[6][3] = "<%=STATUS %>";

data_arr = new Array();

<%
if(messMasterList!=null){
Iterator itr=messMasterList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
             HrorderlyMessMaster hrorderlyMessMaster = (HrorderlyMessMaster)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrorderlyMessMaster.getId()%>
data_arr[<%= counter%>][1] = "<%=hrorderlyMessMaster.getMessCode()%>"
data_arr[<%= counter%>][2] = "<%= hrorderlyMessMaster.getMessName()%>"
data_arr[<%= counter%>][3] = "<%= hrorderlyMessMaster.getLstChangedBy()%>"
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrorderlyMessMaster.getLstChangedDate()) %>"
data_arr[<%= counter%>][5] = "<%= hrorderlyMessMaster.getLstChangedTime() %>"
<% if (hrorderlyMessMaster.getUnitId()!=null && hrorderlyMessMaster.getUnitId().getId()!=0 ){ %>
data_arr[<%= counter%>][6] ="<%=hrorderlyMessMaster.getUnitId().getUnitName()%>"
<%}else{ %>
data_arr[<%= counter%>][6] ="-"
<%}%>
<% if(hrorderlyMessMaster.getStatus().equals("y")){ %>
data_arr[<%= counter%>][7] = "Active"
<%}else{%>
data_arr[<%= counter%>][7] = "InActive"
<%}%>
<%
		     counter++;
}}
%>
formName = "speciality"

nonEditable = ['<%= CODE%>'];
start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
