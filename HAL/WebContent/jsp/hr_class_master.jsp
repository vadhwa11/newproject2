
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.*;"%>
<%
		Map map = new HashMap();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
			
		ArrayList searchClassList = (ArrayList)map.get("searchClassList");
		List<HrSpecialistMaster>searchSpecialistList=new ArrayList<HrSpecialistMaster>();
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		
		if(map.get("searchSpecialistList")!=null)
		{
			searchSpecialistList=(List<HrSpecialistMaster>)map.get("searchSpecialistList");	
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
<h2>Class Master</h2>
</div>
<div class="Clear"></div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<label>Class Code</label><input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" /> <label>Class
Name</label> <input type="radio" class="radioAuto"
	name="<%=SELECTED_RADIO %>" value="2" />  <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Country Code,string,no" MAXLENGTH="8" tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchSpeciality','checkSearch')"
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
		 %> <h4><a href="hrOrderly?method=showClassJsp">Show All Records</a></h2> <%
	     }
		%> <script type="text/javascript">
		
		formFields = [
				[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SPECIALITY_NAME %>"], [3,"<%= SEARCH_NAME %>"], [4,"<%= CHANGED_BY%>"], [5,"<%= CHANGED_DATE %>"],[6,"<%= CHANGED_TIME %>"],[7,"<%=STATUS%>"] ];
		 statusTd = 7;
		</script></div>
<form name="classMaster" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="HrClassMaster"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ClassName">
<input type="hidden" name="title" value="classMaster"> <input
	type="hidden" name="<%=JSP_NAME %>" value="classMaster"> <input
	type="hidden" name="pojoPropertyCode" value="ClassCode"> 

<div class="Clear"></div>
<div class="Block">
<label><span>*</span> Class code</label> <input id="codeId" type="text"
	name="<%= CODE%>" value="" validate="Class Code,string,yes"
	 MAXLENGTH="8" tabindex=1 /> <label><span>*</span> Class Name</label> <input
	type="text" name="<%= SEARCH_NAME %>" value=""
	validate="Class Name,string,yes"  MAXLENGTH="30"
	tabindex=1 /> <label><span>*</span> Speciality Name</label> <select
	name="<%= SPECIALITY_NAME %>" validate="Class Name,string,yes"
	tabindex=1>
	<option value="">Select</option>
	<%for(HrSpecialistMaster hrSpecialistMaster:searchSpecialistList){ %>
	<option value="<%=hrSpecialistMaster.getId() %>"><%=hrSpecialistMaster.getSpecialistName() %></option>
	<%} %>
</select> <script>
					document.classMaster.<%=CODE%>.focus();
				</script>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="Clear"></div>
<div id="edited"></div>
 <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('classMaster','hrOrderly?method=addClass');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('classMaster','hrOrderly?method=editClass')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('classMaster','hrOrderly?method=deleteClass&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> 
<div class="Clear"></div>
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
</div>




</form>
</div>

<script type="text/javascript">
	data_header = new Array();
	
	data_header[0] = new Array;
	data_header[0][0] = "Class Code"
	data_header[0][1] = "data";
	data_header[0][2] = "25%";
	data_header[0][3] = "<%= CODE%>"
	
	data_header[1] = new Array;
	data_header[1][0] = "Speciality Name"
	data_header[1][1] = "data";
	data_header[1][2] = "40%";
	data_header[1][3] = "<%= SPECIALITY_NAME %>";

	data_header[2] = new Array;
	data_header[2][0] = "Class Name"
	data_header[2][1] = "data";
	data_header[2][2] = "40%";
	data_header[2][3] = "<%= SEARCH_NAME %>";
	
	
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
	data_header[5][2] = 0;
	data_header[5][3] = "<%= CHANGED_TIME %>"
	
	data_header[6] = new Array;
	data_header[6][0] = "Status"
	data_header[6][1] = "data";
	data_header[6][2] = "15%";
	data_header[6][3] = "<%=STATUS %>";
	
	data_arr = new Array();
	
	<%
	if(searchClassList!=null){
	Iterator itr=searchClassList.iterator();
	          int  counter=0;
	          while(itr.hasNext())
	           {
	            
	             HrClassMaster hrClassMaster = (HrClassMaster)itr.next(); 
	%>
	
	data_arr[<%= counter%>] = new Array();
	data_arr[<%= counter%>][0] = <%= hrClassMaster.getId()%>
	data_arr[<%= counter%>][1] = "<%=hrClassMaster.getClassCode()%>"
	data_arr[<%= counter%>][2] = "<%=hrClassMaster.getSpeciality().getSpecialistName()%>"
	data_arr[<%= counter%>][3] = "<%=hrClassMaster.getClassName()%>"	
	data_arr[<%= counter%>][4] = "<%= hrClassMaster.getLastChgBy() %>"
	data_arr[<%= counter%>][5] = "<%= HMSUtil.convertDateToStringWithoutTime(hrClassMaster.getLastChgDate()) %>"
	data_arr[<%= counter%>][6] = "<%= hrClassMaster.getLastChgTime() %>"
	<% if(hrClassMaster.getStatus().equals("y")){ %>
	data_arr[<%= counter%>][7] = "Active"
	<%}else{%>
	data_arr[<%= counter%>][7] = "InActive"
	<%}%>
	<%
			     counter++;
	}}
	%>
	formName = "classMaster"
	
	nonEditable = ['<%= CODE%>'];
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');		
	</script>