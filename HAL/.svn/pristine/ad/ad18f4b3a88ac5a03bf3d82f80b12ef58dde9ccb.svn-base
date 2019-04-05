
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.AppBlock"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<!--main content placeholder starts here-->


<div id="contentHolder"><script type="text/javascript"
	language="javascript">
var deptSelected=false;
	<%
	
		Calendar calendar=Calendar.getInstance();
		String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year=calendar.get(calendar.YEAR);
		if(month.length()<2){
			month="0"+month;
		}
		if(date.length()<2){
			date="0"+date;
		}
			
	%>
		serverdate = '<%=date+"/"+month+"/"+year%>'
	



	</script>
<div class="Clear"></div>
<h6>Appointment Block</h6>
<div class="Clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	Box box=HMSUtil.getBox(request);
			 	
			 	String currenDate = (String) utilMap.get("currentDate");
			 	String currentTime = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
				if (map.get("departmentList") != null) {
					departmentList = (List<MasDepartment>) map.get("departmentList");
			 		
			 	}
				List<AppBlock> searchAppBlockList = new ArrayList<AppBlock>();
				if(map.get("searchAppBlockList") != null){
					searchAppBlockList= (List<AppBlock>)map.get("searchAppBlockList");
				}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div class="Clear"></div>
<label class="noWidth"> <span> <%=message %></span> </label>
<div class="Clear"></div>

<%			   
					  }		 	
			 
if(map.get("confirmMessage") != null){
String message = (String)map.get("confirmMessage");
%>
<label class="noWidth"> <span>
<%=message.toUpperCase() %></span></label>
<%    
		     }%> <!--Block One Starts-->
<div class="Clear"></div>
<%if(request.getAttribute("confirmMessage")!=null){%>
<label class="noWidth"> <span>${confirmMessage}</span></label>
<%}%> 
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<script type="text/javascript">
	
	formFields = [
			[0, "<%= APP_BLOCK_ID%>", "id"], [1,"<%= DEPARTMENT_ID%>"], [2,"<%= BLOCK_FROM_DATE %>"],[3,"<%= BLOCK_TO_DATE%>"], [4,"<%= REASON %>"],[5,"<%= CHANGED_BY %>"], [6,"<%= CHANGED_DATE %>"], [7,"<%= CHANGED_TIME %>"]];
	 statusTd = 7;
	</script>
<div class="Clear"></div>
</div>
<script type="text/javascript">
data_header = new Array();;
data_header[0] = new Array;
data_header[0][0] = "Department"
data_header[0][1] = "data";
data_header[0][2] = "25%";
data_header[0][3] = "<%= DEPARTMENT_ID%>"

data_header[1] = new Array;
data_header[1][0] = "Block From"
data_header[1][1] = "data";
data_header[1][2] = "40%";
data_header[1][3] = "<%= BLOCK_FROM_DATE %>";

data_header[2] = new Array;
data_header[2][0] = "Block To"
data_header[2][1] = "data";
data_header[2][2] = "40%";
data_header[2][3] = "<%= BLOCK_TO_DATE %>";

data_header[3] = new Array;
data_header[3][0] = "Reason"
data_header[3][1] = "hide";
data_header[3][2] = "40%";
data_header[3][3] = "<%= REASON %>";

data_header[4] = new Array;
data_header[4][0] = ""
data_header[4][1] = "hide";
data_header[4][2] = 0;
data_header[4][3] = "<%= CHANGED_BY%>"

data_header[5] = new Array;
data_header[5][0] = "Admin"
data_header[5][1] = "hide";
data_header[5][2] = 0;
data_header[5][3] = "<%= CHANGED_DATE%>"

data_header[6] = new Array;
data_header[6][0] = "Status"
data_header[6][1] = "hide";
data_header[6][2] = "15%";
data_header[6][3] = "<%=CHANGED_TIME %>";

data_arr = new Array();

<%
Iterator itr=searchAppBlockList.iterator();
          int  counter=0;
while(itr.hasNext())
 {
   AppBlock  appBlock = (AppBlock)itr.next(); 
 %>

data_arr[<%= counter%>] = new Array();
data_arr[<%= counter%>][0] = <%= appBlock.getId()%>
<%if(appBlock.getDepartment() != null){%>
data_arr[<%= counter%>][1] = "<%=appBlock.getDepartment().getDepartmentName()%>"
<%}else{%>
	data_arr[<%= counter%>][1] = "-"
<%}%>
data_arr[<%= counter%>][2] = "<%= HMSUtil.convertDateToStringWithoutTime(appBlock.getBlockFromDate()) %>"
data_arr[<%= counter%>][3] = "<%= HMSUtil.convertDateToStringWithoutTime(appBlock.getBlockToDate()) %>"
data_arr[<%= counter%>][4] = "<%= appBlock.getReason()%>"
data_arr[<%= counter%>][5] = "<%= appBlock.getLastChgBy() %>"
data_arr[<%= counter%>][6] = "<%= HMSUtil.convertDateToStringWithoutTime(appBlock.getLastChgDate()) %>"
data_arr[<%= counter%>][7] = "<%= appBlock.getLastChgTime() %>"

<%
		     counter++;
}
%>
 
formName = "appBlock"

start = 0
if(data_arr.length < rowsPerPage)
	end = data_arr.length;
else
	end = rowsPerPage;
makeTable(start,end);

intializeHover('searchresulttable', 'TR', ' tableover');		
</script> <%if(request.getAttribute("confirmMessage")!=null){%>
<form name="appBlock" method="post" action="">
<input	type="hidden" name="cancelAppointment" value="yes"> 
<%if(request.getAttribute("confirmMessageUpdate")!=null){%>
	<input	name="" type="button" class="button" value="Cancel All"	onClick="submitForm('appBlock','appointment?method=updateAppointmentBlock');" accesskey="a" tabindex=1 /> 
<%}else{ %>
	<input	name="" type="button" class="button" value="Cancel All"	onClick="submitForm('appBlock','appointment?method=submitAppointmentBlock');" accesskey="a" tabindex=1 /> 
<%}%> 
<input name="" type="button" class="button"	value="Dont Cancel"	onClick="submitForm('appBlock','appointment?method=showAppBlockJsp&appId=A854');" accesskey="a" tabindex=1 />

</form>
<%}else{ %>

<form name="appBlock" method="post" action="">
<div class="Clear"></div>
<div class="BlockFrame">
<input type="hidden" name="<%= APP_BLOCK_ID%>" />
<label><span>*</span> Department</label> 
<select	id="departmentId" name=<%=DEPARTMENT_ID %>	validate="Department,string,yes">
	<option value="0">Select</option>

	<%
  		if(departmentList != null){ 	
  			for (Iterator iter = departmentList.iterator(); iter.hasNext();) {
  				MasDepartment masDepartment = (MasDepartment) iter.next();
    %>
	<option value="<%=masDepartment.getId() %>"><%=masDepartment.getDepartmentName() %></option>
	<%		
			          			}
			          		 } 
			          %>
</select>
<div class="Clear"></div>
<label><span>*</span> Block From </label> 
<input type="text"	class="calDate" id="blockFromId" name="<%=BLOCK_FROM_DATE %>" value=""	readonly="readonly" validate="Block From,date,yes" MAXLENGTH="30" onblur="validateBlockFromDate();" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date"	onClick="setdate('<%=currentDate %>',document.appBlock.<%=BLOCK_FROM_DATE%>,event)" />
<label><span>*</span> Block To</label> 
<input type="text"	class="calDate" id="blockToId" name="<%=BLOCK_TO_DATE %>" value=""	readonly="readonly" MAXLENGTH="30" validate="Block To,date,yes"	onblur="validateBlockToDate();" /> 
<img src="/hms/jsp/images/cal.gif"	width="16" height="16" border="0" validate="Pick a date" onClick="setdate('<%=currentDate %>',document.appBlock.<%=BLOCK_TO_DATE%>,event)" />
<div class="Clear"></div>
<label><span>*</span> Reason </label> 
<input type="text" id="reasonId" name="<%= REASON%>" value="" validate="Reason,string,yes" class="large2" MAXLENGTH="100" validate="REason,string,yes" />
</div>	
<input type="hidden" name="Delete" id="Delete"/>
<!--Block one Ends-->
<div class="Clear"></div>
<!--Block Three Starts-->
<div class="bottom">
<div class="Clear"></div>
<div id="edited"></div>
<input name="add" id="addbutton" type="button" class="button" value="Submit" onClick="submitForm('appBlock','appointment?method=submitAppointmentBlock');" accesskey="a" tabindex=1 />
<input type="button" name="edit" id="editbutton" value="Update" class="button" onClick="submitForm('appBlock','appointment?method=updateAppointmentBlock')" accesskey="u" tabindex=1 /> 
<input type="button" name="Unblock"	id="deletebutton" value="Unblock" class="button" onClick="submitForm('appBlock','appointment?method=deleteAppointmentBlock')" accesskey="d" tabindex=1 />
<input name="" type="reset" class="button" value="Reset" /> <%}%> 
<!--Bottom labels starts-->
<div class="Clear"></div>
<div class="bottom"><label>Changed By </label> 
<label class="value"><%=userName %></label> 
<label>Changed Date </label> 
<label class="value"><%=currenDate %></label> 
<label>Changed Time </label> 
<label	class="value"><%=currentTime%></label>
</div>
</form>
<!--Bottom labels ends--></div>
<!--main content placeholder ends here-->



<script type="text/javascript" language="javascript">
	
	function validateBlockFromDate(){
		
		var nowDate=new Date();
		var currentDate=new Date(nowDate.getFullYear(),nowDate.getMonth(),nowDate.getDate());
		obj1 = eval(document.appBlock.blockFromId)
			
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
			if(validFromDate < currentDate)
			{
					alert("Block From should be greater than or equal to today's Date\n");
					document.getElementById('blockFromId').value="";
					document.getElementById('blockFromId').focus();
					return false;
			}
				
					
		}
		return true;
	}
		
	function validateBlockToDate(){
		
		var nowDate=new Date();
		var currentDate=new Date(nowDate.getFullYear(),nowDate.getMonth(),nowDate.getDate());
		obj1 = eval(document.appBlock.blockFromId)
		obj2 = eval(document.appBlock.blockToId)	
		if(obj1.value != "" )
		{
		
		 validFromDate=new Date(obj1.value.substring(6),(obj1.value.substring(3,5) - 1) ,obj1.value.substring(0,2));
		 validToDate=new Date(obj2.value.substring(6),(obj2.value.substring(3,5) - 1) ,obj2.value.substring(0,2));
				
			if(validToDate < currentDate || validToDate  < validFromDate)
			{
					alert("Block To cannot be less than Today and Block From\n");
					document.getElementById('blockToId').value="";
					document.getElementById('blockToId').focus();
					return false;
			}
				
					
		}
		return true;
	}
</script>