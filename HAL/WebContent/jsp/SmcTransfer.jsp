<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.masters.business.MasCommand" %>
<%@ page import="jkt.hms.masters.business.MasHospital" %>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.util.Box"%>
<%
Map<String,Object> map = new HashMap<String,Object>();
if(request.getAttribute("map") != null){
	map = (Map) request.getAttribute("map");
}

Map<String,Object> utilMap = new HashMap<String,Object>();
utilMap = (Map)HMSUtil.getCurrentDateAndTime();
String date = (String)utilMap.get("currentDate");	 
String time = (String)utilMap.get("currentTimeWithoutSc");

List<MasCommand>  commandList = new ArrayList<MasCommand>();
commandList = (List)map.get("commandList");

List<MasHospital>  hospitalList= new ArrayList<MasHospital>();
hospitalList = (List)map.get("hospitalList");

String userName = "";
if(session.getAttribute("userName") != null){
 userName = (String)session.getAttribute("userName");
}
List<Object[]> employeeList = new ArrayList<Object[]>();
if(map.get("employeeList")!=null){
	employeeList = (List<Object[]>)map.get("employeeList");
}
Box box = HMSUtil.getBox(request);
String message = "";
if(map.get("message")!=null){
	message = (String)map.get("message");
}
if(!message.equals("")){
	%>


<h4><%=message %></h4>
<%}
%>

<%@page import="jkt.hms.masters.business.MasEmployee"%><div class="titleBg"><h2>SMC Transfer</h2></div>
<div class="clear"></div>
<form name="search" method="post" action="">
<div class="Block">
<label>Service No.</label>
<input type="text" name="serviceNo" value="" maxlength="30" validate="Service No.,metachar,no"/>
<label>Command</label>
<select name="scommand"  id="scommandId" validate="Command,string, no" onchange="populateSMC(this.value,'search')">
<option value="0">Select</option>
<% 
   if(commandList != null)
   {
	   for(MasCommand masCommand : commandList)
	    {%>
	    <option value="<%=masCommand.getId()%>" ><%=masCommand.getCommandName()%></option>
	   <%		   
	    }
   }
    
%>
</select>
<script>
<%
	if(box.getInt("scommand")!=0){
%>
document.getElementById('scommandId').value = '<%=box.getInt("scommand")%>';
<%}else{ %>

document.getElementById('scommandId').value = '<%=session.getAttribute("commandId")%>';
<%} %>
</script>
<label>SMC</label>
<select name="sHospital"  id="sHospitalId" validate="SMC,string, no">
<option value="0">Select</option>
<% 
   if(hospitalList != null)
   {
	   for(MasHospital hospital : hospitalList)
	    {%>
	    <option value="<%=hospital.getId()%>" ><%=hospital.getHospitalName()%></option>
	   <%		   
	    }
   }
    
%>
</select>
<script>
<%
	if(box.getInt("sHospital")!=0){
%>
document.getElementById('sHospitalId').value = '<%=box.getInt("sHospital")%>';
<%}else{ %>

document.getElementById('sHospitalId').value = '<%=session.getAttribute("hospitalId")%>';
<%} %>
</script>
<script type="text/javascript">
		var stnArr = new Array();
		<%
		int k=0;
		for (MasCommand masCommand : commandList) 
		{
			for (MasHospital hospital : hospitalList) 
			{
				if(hospital.getCommand() != null){
					if(masCommand.getId().equals(hospital.getCommand().getId())){
							%>
							stnArr[<%=k%>] = new Array();
							stnArr[<%=k%>][0] = <%=masCommand.getId()%>;
							stnArr[<%=k%>][1] = <%=hospital.getId()%>;									
							stnArr[<%=k%>][2] = "<%=hospital.getHospitalName()%>";
							<%
							k++;
					}
				}
			}
		}
		%>
</script>

<input type="button" name="search" value="Search" class="button"	onclick="submitForm('search','/hms/hms/personnel?method=searchEmployeeForSMCTransfer')"	tabindex=1 />

</div>
</form>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>

<script type="text/javascript">
	
	formFields = [
			[0, "employeeId", "id"], [1,"serviceNo"], [2,"rank"], [3,"name"], [4,"status"],[5,"<%= CHANGED_BY%>"], [6,"<%= CHANGED_DATE %>"],[7,"<%= CHANGED_TIME %>"],[8,"command"],[9,"oldSmc"],[10,"oldSmcId"]];
	 statusTd = 4;
	</script></div>
	<form name="smcTransfer" method="post" action="">
		<div class="Clear"></div>
	
	<div class="Block">
	<label>Service No.</label>
	<input type="text" name="serviceNo" value="" readonly="readonly"/>
	<label>Rank</label>
	<input type="text" name="rank" value="" readonly="readonly"/>
	
	<label>Name</label>
	<input type="text" name="name" value="" readonly="readonly"/>
	<div class="Clear"></div>
	
	<label>Current Command</label>
	<input type="text" name="command" value="" readonly="readonly"/>
	
	<label>New Command</label>
	<select name="newcommand"  id="commandId" validate="Command,string, no" onchange="populateSMC(this.value,'smcTransfer')">
	<option value="0">Select</option>
	<% 
	   if(commandList != null)
	   {
		   for(MasCommand masCommand : commandList)
		    {%>
		    <option value="<%=masCommand.getId()%>" ><%=masCommand.getCommandName()%></option>
		   <%		   
		    }
	   }
	    
	%>
	</select>
	
	<div class="Clear"></div>
	<label>Current SMC</label>
	<input type="text" name="oldSmc" value="" readonly="readonly"/>
	<input type="hidden" name="oldSmcId" value="" readonly="readonly"/>
	
	
	<label>New SMC</label>
	<select name="hospital"  id="hospital" validate="SMC,string, no">
	<option value="0">Select</option>
	<% 
	   if(hospitalList != null)
	   {
		   for(MasHospital hospital : hospitalList)
		    {%>
		    <option value="<%=hospital.getId()%>" ><%=hospital.getHospitalName()%></option>
		   <%		   
		    }
	   }
	    
	%>
	</select>
		<div class="Clear"></div>
	<input type="hidden" name="employeeId" value="" />
			
	</div>
	<div id="edited"></div>
	<input type="button" name="edit" id="edit" value="Update" class="button" onClick="submitForm('smcTransfer','personnel?method=updateEmployeeSMC')" accesskey="u"  />
	<input type="hidden" name="Delete" id="deletebutton" value="Activate" class="button"  accesskey="d" />		
			
	<div class="Clear"></div>
	<div class="division"></div>
	<div class="bottom">
<label>Changed By:</label> <label
	class="value"><%=userName %></label> <label>Changed Date:</label> <label
	class="value"><%=date%></label> <label>Changed Time:</label> <label
	class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName %>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />
<div class="Clear"></div>
</div>
	
	</form>
	
	
<script type="text/javascript">
data_header = new Array();

data_header[0] = new Array;
data_header[0][0] = "Service No."
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "serviceNo"

data_header[1] = new Array;
data_header[1][0] = "Rank"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "rank";



data_header[2] = new Array;
data_header[2][0] = "Name"
data_header[2][1] = "data";
data_header[2][2] = "25%";
data_header[2][3] = "name"

data_header[3] = new Array;
data_header[3][0] = "Status"
data_header[3][1] = "data";
data_header[3][2] = "40%";
data_header[3][3] = "status";



data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = ""
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = ""
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_header[7] = new Array;
data_header[7][0] = ""
data_header[7][1] = "hide";
data_header[7][2] = 0;
data_header[7][3] = "command"

data_header[8] = new Array;
data_header[8][0] = ""
data_header[8][1] = "hide";
data_header[8][2] = "15%";
data_header[8][3] = "oldSmc";

data_header[9] = new Array;
data_header[9][0] = ""
data_header[9][1] = "hide";
data_header[9][2] = "15%";
data_header[9][3] = "oldSmcId";

data_arr = new Array();

<%
int counter = 0;
if(employeeList.size() > 0){
for (Object[] obj : employeeList) {
%>
data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%=(Integer)obj[0]%>
data_arr[<%= counter%>][1] = "<%=(String)obj[1]%>";
data_arr[<%= counter%>][2] = "<%=(String)obj[5]%>"
data_arr[<%= counter%>][3] = "<%=(String)obj[2]+" "+(obj[3]!=null?obj[3]:"")+" "+(obj[4]!=null?obj[4]:"")%>"
<%
if(obj[6].equals("y")){
%>
data_arr[<%= counter%>][4] = "Active"
<%}else{%>
data_arr[<%= counter%>][4] = "Inactive"
<%}%>
data_arr[<%= counter%>][8] = "<%=(String)obj[7]%>"
data_arr[<%= counter%>][9] = "<%=(String)obj[8]%>"
data_arr[<%= counter%>][10] = "<%=(Integer)obj[9]%>"
<% counter++;}}%>

formName = "smcTransfer"
	
	 
	start = 0
	if(data_arr.length < rowsPerPage)
		end = data_arr.length;
	else
		end = rowsPerPage;
		
		
	makeTable(start,end);
	
	intializeHover('searchresulttable', 'TR', ' tableover');
</script>