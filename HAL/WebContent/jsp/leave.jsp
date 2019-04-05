<%@ page import="static jkt.hms.util.RequestConstants.*" %>
<%@ page import="java.util.*" %>
<%@ page import="jkt.hms.util.HMSUtil" %>
<%@page import="jkt.hms.masters.business.HrMasLeave"%>
<%@page import="jkt.hms.masters.business.MasHospital"%>

<%
Map map = new HashMap();
if(request.getAttribute("map") != null){
map = (Map) request.getAttribute("map");
}
Map<String,Object> utilMap = new HashMap<String,Object>();
ArrayList masLeaveList = (ArrayList)map.get("masLeaveList");
List<MasHospital> hospitalList = new ArrayList<MasHospital>();
if(map.get("hospitalList") != null){
hospitalList = (ArrayList)map.get("hospitalList");
}
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTime");

String userName = "";
if(session.getAttribute("userName") != null){
userName = (String)session.getAttribute("userName");
}

int userId=0;
if(session.getAttribute("userId") != null){
	userId = (Integer)session.getAttribute("userId");
}

String message="";
if(map.get("message") != null){
 message = (String)map.get("message");
 out.println("<h4>" + message + "</h4>");
}
%>

<%@page import="jkt.hms.masters.business.MasCompany"%>
<div class="titleBg"><h2>Leave Master</h2></div>
<div class="clear"></div>
<div class="Block">
<div id="searcharea">
<div id="searchbar">
<form name="search" method="post" action="">
<label>Leave Description</label>
<input type="text" id="searchField" name="<%= DESCRIPTION%>" value=""  MAXLENGTH="32" validate="Leave Description,string,no"   MAXLENGTH="8" tabindex=1  onkeypress="return submitenter(this,event,'systemRelatedMaster?method=searchLeave')" />
<input type="button" name="search" value="Search" class="button" onclick="submitForm('search','systemRelatedMaster?method=searchLeave','checkSearch')" tabindex=1  />
<!-- <input type="reset" name ="Reset" id="reset" value ="Reset" class="button" onclick="resetCheck();" accesskey="r" /> -->
</form>

</div>
</div>
<div class="clear"></div>
</div>
<div class="clear"></div>


<jsp:include page="searchResultBlock.jsp" />
<form name="ancher" method="post">
</form>
<div class="clear"></div>
<div id="searchresults" tabindex=2 >
<div id="searchtable" tabindex=2 ></div>
<% 
if(masLeaveList.size()>0 && masLeaveList!= null)
{
String strForCodeDescription = (String)map.get("description");
if( strForCodeDescription!= null && strForCodeDescription!= "")
{
%> 


<!-- <a href="systemRelatedMaster?method=showLeaveJsp">Show All Records</a> -->
<a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showLeaveJsp');">Show All Records</a>

<%
}
}
if(masLeaveList.size()==0 && map.get("search") != null)
{
%>
<!-- <a href="systemRelatedMaster?method=showLeaveJsp">Show All Records</a> -->
<a href="javascript:void(0)" onclick="submitForm('ancher','systemRelatedMaster?method=showLeaveJsp');">Show All Records</a>

<%
}
%>
<script type="text/javascript">

formFields = [
[0, "<%= COMMON_ID%>", "id"], [1,"<%= DESCRIPTION%>"], [2,"<%= HOSPITAL_ID %>"],[3,"<%= CHANGED_BY%>"], [4,"<%= CHANGED_DATE %>"],[5,"<%= CHANGED_TIME %>"],[6,"<%=STATUS%>"] ];
statusTd = 6;
</script>
</div>
<div class="clear"></div>
<div class="division"></div>
<form name="leave" method="post" action="">
<div class="Block">

<label> Leave Description <span>*</span></label>
<input id="codeId" type="text" name="<%= DESCRIPTION%>" value=""  onkeypress="return event.keyCode!=13" validate="Leave Description,string,yes"  MAXLENGTH="32" tabindex=1 />
<%--
<label ><span>*</span>Centre:</label>
			<select name="<%= HOSPITAL_ID %>" validate="Centre,string,yes" tabindex=1>
			<option value="">Select</option>
			<%if(hospitalList != null){ %>
			  <% 
				for (MasHospital  masHospital : hospitalList){
				%>
			  <option value="<%=masHospital.getId ()%>"><%=masHospital.getHospitalName()%></option>
			  <%} }%>
			</select> --%>
<div class="clear"></div>
</div>
<div class="clear"></div>

<div class="division"></div>

<div id="edited"></div>


<input type="button" name="add" id="addbutton" value="Add" class="button" onClick="submitForm('leave','systemRelatedMaster?method=addLeave');" accesskey="a" tabindex=1/>
<input type="button" name="edit" id="editbutton" value="Update" style="display: none;" class="button" onClick="submitForm('leave','systemRelatedMaster?method=editLeave')" accesskey="u" tabindex=1 />
<input type="button" name="Delete" id="deletebutton" value="Activate" style="display: none;" class="button" onClick="submitForm('leave','systemRelatedMaster?method=deleteLeave&flag='+this.value)" accesskey="d" tabindex=1/>		
<input type="button" name ="Reset" id="reset" value ="Reset" class="button" onclick="submitForm('search','systemRelatedMaster?method=showLeaveJsp')" accesskey="r" />

<input type="hidden" name="<%=STATUS %>" value="" />
<input type="hidden" name="<%= COMMON_ID%>" value="" />
<div class="clear"></div>
<input type="hidden" name="CHANGED_BY" value="<%=userId%>" />
<div class="division"></div>
<div class="bottom">
<label>Changed By</label>   
<label class="value"><%=userName%></label>

<label>Changed Date</label>   
<label class="value"><%=date%></label>

<label>Changed Time</label>   
<label class="value"><%=time%></label>


<input type="hidden" name="<%=CHANGED_DATE %>" value="<%=date%>"  />
<input type="hidden" name="<%=CHANGED_TIME %>"  value="<%=time%>" />  
</div>	

</form>

<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Description"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= DESCRIPTION%>"

data_header[1] = new Array;
data_header[1][0] = "Company"
data_header[1][1] = "hide";
data_header[1][2] = "40%";
data_header[1][3] = "<%= HOSPITAL_ID %>";

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
Iterator itr=masLeaveList.iterator();
int  counter=0;
while(itr.hasNext())
 {            
HrMasLeave  hrMasLeave = (HrMasLeave)itr.next();     
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= hrMasLeave.getId()%>
data_arr[<%= counter%>][1] = "<%=hrMasLeave.getDescription()%>"
<%if(hrMasLeave.getCompany() != null){%>
<%
	//for(MasHospital masHospital :hospitalList){
		//if(hrMasLeave.getCompany().getId().equals(masHospital.getId())){
%>

data_arr[<%= counter%>][2] = "<%=hrMasLeave.getCompany()%>"


		
<%		}//}} 
else {%>
data_arr[<%= counter%>][2] = ""
<%}%>
            
data_arr[<%= counter%>][3] = "<%= hrMasLeave.getLastChgBy() %>"

<%if(hrMasLeave.getLastChgDate() !=null){%>
data_arr[<%= counter%>][4] = "<%= HMSUtil.convertDateToStringWithoutTime(hrMasLeave.getLastChgDate()) %>"
<%}else{%>
data_arr[<%= counter%>][4] = ""
<%}%>

data_arr[<%= counter%>][5] = "<%= hrMasLeave.getLastChgTime() %>"

<% //System.out.println("hrMasLeave.getStatus()"+hrMasLeave.getStatus());
if(hrMasLeave.getStatus().equalsIgnoreCase("y")){ %>
data_arr[<%= counter%>][6] = "Active"
<%}else if(hrMasLeave.getStatus().equalsIgnoreCase("n")){%>
data_arr[<%= counter%>][6] = "InActive"
<%
   }	counter++;
	}
%>

formName = "leave"

start = 0
if(data_arr.length < rowsPerPage)
end = data_arr.length;
else
end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script>	
