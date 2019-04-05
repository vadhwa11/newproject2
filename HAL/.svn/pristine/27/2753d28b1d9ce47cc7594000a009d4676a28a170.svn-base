<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.HrorderlyLeavechoice"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<script type="text/javascript">
function LeaveChoiceFunction(){
	var leavechoice1=document.getElementById('<%=LEAVE_CHOICE_1 %>').value;
     var leavechoice2=document.getElementById('<%=LEAVE_CHOICE_2 %>').value;
     if(leavechoice1==leavechoice2){
     alert('Both choices cannot be same ');
   
     document.getElementById('<%=LEAVE_CHOICE_2 %>').focus();
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
		
	List<HrorderlyLeavechoice> hrorderlyLeaveChoiceList = new ArrayList<HrorderlyLeavechoice>();
	List<MasServiceType> masservicetypeList = new ArrayList<MasServiceType>();
    List masUnitList = (List)map.get("masUnitList");
    if(map.get("hrorderlyLeaveChoiceList")!=null)
    {
    	hrorderlyLeaveChoiceList=(List)map.get("hrorderlyLeaveChoiceList");
    }
    if(map.get("masservicetypeList")!=null)
    {
    	masservicetypeList=(List)map.get("masservicetypeList");
    }
    
	String userName = "";
	if(session.getAttribute("userName") != null){
		userName = (String)session.getAttribute("userName");
	}
	int hospitalId = 0;
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if(map.get("message") != null){
		   String message = (String)map.get("message");
		   out.println(message);
		  }
%>
<div class="titleBg">
<h2>Leave Choice Master</h2>
</div>
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<div class="Block">
<input type="radio"
	name="<%=SELECTED_RADIO  %>" value="1" checked="checked" class="radioAuto"/> 
	<label>ServiceNo.</label> <input type="radio"
	name="<%=SELECTED_RADIO %>" value="2" class="radioAuto" /> 
	<label>Employee Code</label> <input type="text" id="searchField" name="<%= SEARCH_FIELD%>"
	value="" validate="Search Field Required,string,no" MAXLENGTH="8"
	tabindex=1
	onkeypress="return submitenter(this,event,'generalMaster?method=searchCountry')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','hrOrderly?method=searchLeaveChoice','checkSearch')"
	tabindex=1 /> <%--- Report Button   --%> <input type="button"
	name="Report" value="Generate Report Based on Search" class="buttonBig3"
	onClick="" accesskey="g" tabindex=1 /> <input type="hidden"
	name="<%=JASPER_FILE_NAME%>" value="Mas_country"></div></form>
</div>
</div>
<jsp:include page="searchResultBlock.jsp" />
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<%
	 if(map.get("search") != null)
	  {
	 %><h4> <a href="hrOrderly?method=showLeaveChoiceJsp">Show All Records</a></h4>

<%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= COMMON_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%=SERVICE_NO %>"], [3,"<%=SERVICE_TYPE_CODE%>"], [4,"<%= SEARCH_NAME %>"], [5,"<%=LEAVE_CHOICE_1%>"], [6,"<%=LEAVE_CHOICE_2%>"], [7,"<%= CHANGED_BY%>"], [8,"<%= CHANGED_DATE %>"],[9,"<%= CHANGED_TIME %>"],[10,"<%=YEAR%>"],[11,"<%=STATUS%>"] ];
	 statusTd = 11;
	</script></div>
<form name="speciality" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="MasEmployee"> <input
	type="hidden" name="<%=POJO_PROPERTY_NAME %>" value="ServiceNo">
<input type="hidden" name="title" value="Leave Choice "> <input
	type="hidden" name="<%=JSP_NAME %>" value="Leave Choice "> <input
	type="hidden" name="pojoPropertyCode" value="ServiceType"> <br>

<label class="Block"><label ><span>*</span> ServiceNo.</label> <input id="codeId" type="text"
	name="<%=SERVICE_NO%>" value="" validate="Service No,string,yes" class="textbox_size20" MAXLENGTH="8" tabindex=1 /> 
	<label><span>*</span> ServiceType. </label>
<select id="codeId" name="<%=SERVICE_TYPE_CODE%>" value=""
	validate="Service Type,string,yes" MAXLENGTH="8" tabindex=1 />
	<option value="">select</option>
	<%if(masservicetypeList!=null){
                 for(MasServiceType masservicetype:masservicetypeList){        
        	 %>
	<option value="<%=masservicetype.getId() %>"><%=masservicetype.getServiceTypeName() %></option>
	<%}} %>
</select> <% String year[]=date.split("/");
            int finalyear=Integer.parseInt(year[2])+10;		
		%> <label><span>*</span>Year. </label> 
		<select id="<%=YEAR %>" name="<%=YEAR %>" validate="Year Name,string,yes" tabindex=1>
	<%for(int i=2009;i<finalyear;i++){ %>
	<option value="<%=i %>"><%=i %></option>
	<%} %>

</select> <script>
				document.speciality.<%=SERVICE_NO%>.focus();
			</script>
<div class="clear"></div>

<label class="bodytextB_blue">Leave choice1</label> <select
	id="<%=LEAVE_CHOICE_1%>" name="<%=LEAVE_CHOICE_1%>"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();"
	tabindex=1>
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select> <label class="bodytextB_blue">Leave choice2</label> <select
	id="<%=LEAVE_CHOICE_2%>" name="<%=LEAVE_CHOICE_2%>"
	onchange=" LeaveChoiceFunction();" onblur=" LeaveChoiceFunction();"
	tabindex=1>
	<option value="0">Select</option>
	<option value="1">Jan-Feb</option>
	<option value="2">Feb-Mar</option>
	<option value="3">Mar-Apr</option>
	<option value="4">Apr-May</option>
	<option value="5">May-Jun</option>
	<option value="6">Jun-Jul</option>
	<option value="7">Jul-Aug</option>
	<option value="8">Aug-Sep</option>
	<option value="9">Sep-Oct</option>
	<option value="10">Oct-Nov</option>
	<option value="11">Nov-Dec</option>
</select>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="edited"></div>
<label>&nbsp;</label> <input type="button" name="add" id="addbutton"
	value="Add" class="button"
	onClick="submitForm('speciality','hrOrderly?method=addLeaveChoice');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('speciality','hrOrderly?method=editLeaveChoice')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('speciality','hrOrderly?method=deleteLeaveChoice&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= COMMON_ID%>" value="" /> <br />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

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
	
</div></form>
</div>

<script type="text/javascript">
data_header = new Array();
<%String monthName[]={"-","Jan-Feb","Feb-Mar","Mar-Apr","Apr-May","May-Jun","Jun-Jul","Jul-Aug","Aug-Sep","Sep-Oct","Oct-Nov","Nov-Dec"};%>
data_header[0] = new Array;
data_header[0][0] = "Employee Code"
data_header[0][1] = "data";
data_header[0][2] = "5%";
data_header[0][3] = "<%= CODE%>"

data_header[1] = new Array;
data_header[1][0] = "Service No."
data_header[1][1] = "data";
data_header[1][2] = "10%";
data_header[1][3] = "<%=SERVICE_NO%>";

data_header[2] = new Array;
data_header[2][0] = "Service Type"
data_header[2][1] = "data";
data_header[2][2] = "10%";
data_header[2][3] = "<%=SERVICE_TYPE_CODE%>";

data_header[3] = new Array;
data_header[3][0] = "Employee Name"
data_header[3][1] = "data";
data_header[3][2] = "20%";
data_header[3][3] = "<%=SEARCH_NAME%>";

data_header[4] = new Array;
data_header[4][0] = "Leave choice 1"
data_header[4][1] = "data";
data_header[4][2] = "5%";
data_header[4][3] = "<%=LEAVE_CHOICE_1%>";

data_header[5] = new Array;
data_header[5][0] = "Leave choice 2"
data_header[5][1] = "data";
data_header[5][2] = "5%";
data_header[5][3] = "<%=LEAVE_CHOICE_2%>";


data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = 0;
data_header[6][3] = "<%= CHANGED_BY %>"

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "<%= CHANGED_DATE %>"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = 0;
data_header[8][3] = "<%= CHANGED_TIME %>"

data_header[9] = new Array;
data_header[9][0] = "Year"
data_header[9][1] = "data";
data_header[9][2] = "10%";
data_header[9][3] = "<%=YEAR%>"


data_header[10] = new Array;
data_header[10][0] = "Status"
data_header[10][1] = "data";
data_header[10][2] = "10%";
data_header[10][3] = "<%=STATUS %>";



data_arr = new Array();

<%
if(hrorderlyLeaveChoiceList!=null){
Iterator itr=hrorderlyLeaveChoiceList.iterator();
          int  counter=0;
          while(itr.hasNext())
           {
            
        	  HrorderlyLeavechoice hrorderlyLeavechoice = (HrorderlyLeavechoice)itr.next(); 
%>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = "<%= hrorderlyLeavechoice.getId()%>"
data_arr[<%= counter%>][1] = "<%=hrorderlyLeavechoice.getEmployeeId().getEmployeeCode()%>"
data_arr[<%= counter%>][2] = "<%=hrorderlyLeavechoice.getEmployeeId().getServiceNo()%>"
data_arr[<%= counter%>][3] = "<%=hrorderlyLeavechoice.getEmployeeId().getServiceType().getServiceTypeName()%>"
data_arr[<%= counter%>][4] = "<%=hrorderlyLeavechoice.getEmployeeId().getFirstName()+"   "+hrorderlyLeavechoice.getEmployeeId().getLastName()%>"
data_arr[<%= counter%>][5] = "<%=monthName[Integer.parseInt(hrorderlyLeavechoice.getLeaveChoice1())]%>"
data_arr[<%= counter%>][6] = "<%=monthName[Integer.parseInt(hrorderlyLeavechoice.getLeaveChoice2())]%>"
data_arr[<%= counter%>][7] = "<%= hrorderlyLeavechoice.getLastChgBy()%>"
data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(hrorderlyLeavechoice.getLastChgDate()) %>"
data_arr[<%= counter%>][9] = "<%= hrorderlyLeavechoice.getLastChgTime() %>"
<% if (hrorderlyLeavechoice.getYear()!=null){ %>
data_arr[<%= counter%>][10] ="<%=hrorderlyLeavechoice.getYear()%>"
<%}else{ %>
data_arr[<%= counter%>][10] ="-"
<%}%>
<% if(hrorderlyLeavechoice.getStatus().equals("y")){ %>
data_arr[<%= counter%>][11] = "Active"
<%}else{%>
data_arr[<%= counter%>][11] = "InActive"
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
