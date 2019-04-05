
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.BloodMasComponent"%>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/security/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script>
function checkSpecialChar(){
var code;
var name ;
var qty;
var lifeSpan ;
var temp;
	 code = document.getElementById('codeId').value;
	 name= document.getElementById('search_name').value;
	  qty = document.getElementById('qty').value;
	 temp= document.getElementById('temp').value;
	  lifeSpan = document.getElementById('lifeSpan').value;
	 if(code.match("\"")|| name.match("\"")|| temp.match("\"")|| qty.match("\"")|| lifeSpan.match("\"")){
	 alert('Please Do not enter " as Entry field')
	 document.getElementById('search_name').value=""
	 document.getElementById('codeId').value=""
	  document.getElementById('lifeSpan').value=""
	 document.getElementById('temp').value=""
	  document.getElementById('qty').value=""
	 return false;
	 }else if(code.match("\<")|| name.match("\<")|| qty.match("\<")|| lifeSpan.match("\<")|| temp.match("\<")){
	 alert('Please Do not enter < as Entry field')
	document.getElementById('search_name').value=""
	 document.getElementById('codeId').value=""
	  document.getElementById('lifeSpan').value=""
	 document.getElementById('temp').value=""
	  document.getElementById('qty').value=""
	 return false;
	 }
	 else{
	 return true;
	 }
}

</script>
<script>
<%
  	Calendar calendar=Calendar.getInstance();
	String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String dateCal=String.valueOf(calendar.get(Calendar.DATE));
	int year=calendar.get(calendar.YEAR);
	if(month.length()<2){
		month="0"+month;
	}
	if(dateCal.length()<2){
		dateCal="0"+dateCal;
	}
%>
	serverdate = '<%=dateCal+"/"+month+"/"+year%>'
</script>
<%

		Map<String,Object> map = new HashMap<String,Object>();
		if(request.getAttribute("map") != null){
			map = (Map) request.getAttribute("map");
		}
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String date = (String)utilMap.get("currentDate");	 
		String time = (String)utilMap.get("currentTime");
		ArrayList searchBloodComponentList = (ArrayList)map.get("searchBloodComponentList");
		String userName = "";
		if(session.getAttribute("userName") != null){
			userName = (String)session.getAttribute("userName");
		}
		String message ="";
		if (map.get("message") != null) {
		             message = (String) map.get("message");
		      }
		if(!message.equalsIgnoreCase("")){
		%>
<h2><%=message %></h2>
<%} %>

<div id="contentHolder">
<div class="Clear"></div>
<h6>Blood Component Master</h6>
<div class="Clear"></div>
<div class="header">

<form name="search" method="post" action=""><label>Component
Code</label> <input type="radio" name="<%=SELECTED_RADIO  %>" class="radio"
	value="1" checked="checked" tabindex=1 /> <label>Component
Name</label> <input type="radio" name="<%=SELECTED_RADIO %>" class="radio"
	value="2" /> <input type="text" id="searchField"
	name="<%= SEARCH_FIELD%>" value="" validate="Component Code,string,no"
	MAXLENGTH="30" tabindex=1
	onkeypress="return submitenter(this,event,'bloodBank?method=searchBloodComponent')" />
<input type="button" name="search" value="Search" class="button"
	onclick="submitForm('search','bloodBank?method=searchBloodComponent','checkSearch')"
	tabindex=1 /></form>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<jsp:include page="searchResultBlock.jsp" />
<div class="Clear"></div>
<div id="searchresults" tabindex=2>
<div id="searchtable" tabindex=2></div>
<% 
		if(searchBloodComponentList.size()>0 )
		 {
			String strForCode = (String)map.get("bloodComponentCode");
			String strForCodeDescription = (String)map.get("bloodComponentName");
			if(strForCode!= null && strForCode!= "" || strForCodeDescription!= null && strForCodeDescription!= "")
			{
	%> <a href="bloodBank?method=showBloodComponentJsp">Show All
Records</a> <%
			}
		 }
	 if(searchBloodComponentList.size()==0 && map.get("search") != null)
	  {
	 %> <a href="bloodBank?method=showBloodComponentJsp">Show All
Records</a> <%
     }
	%> <script type="text/javascript">
	
	formFields = [
			[0, "<%= BLOOD_COMPONENT_ID%>", "id"], [1,"<%= CODE%>"], [2,"<%= SEARCH_NAME %>"],[3,"<%= LIFE_SPAN%>"],[4,"<%= TEMPERATURE%>"],[5,"<%= QTY_PER_UNIT%>"], [6,"<%= WHOLE_BLOOD %>"],[7,"<%=CHANGED_BY %>"],[8,"<%=CHANGED_DATE %>"],[9,"<%=CHANGED_TIME %>"],[10,"<%=DAYS %>"],[11,"<%=STATUS %>"]];
	 statusTd = 11;
	</script></div>
<div class="Clear"></div>

<form name="bloodComponent" method="post" action=""><input
	type="hidden" name="<%= POJO_NAME %>" value="BloodMasComponent">
<input type="hidden" name="<%=POJO_PROPERTY_NAME %>"
	value="ComponentName"> <input type="hidden" name="title"
	value="bloodComponent"> <input type="hidden"
	name="<%=JSP_NAME %>" value="bloodComponent"> <input
	type="hidden" name="pojoPropertyCode" value="ComponentCode">
<div class="division"></div>
<div class="blockFrame"><label class="common"><span>*</span>
Component Code </label> <input id="codeId" type="text" name="<%= CODE%>"
	value="" validate="Component Code,string,yes" MAXLENGTH="8" tabindex=1 />

<label class="common"><span>*</span> Component Name</label> <input
	id="search_name" type="text" class="large" name="<%= SEARCH_NAME %>"
	value="" validate="Component Name,string,yes" MAXLENGTH="32" tabindex=1 />
<script>
				document.bloodComponent.<%=CODE%>.focus();
				</script> <label class="common">Life span </label> <input id="lifeSpan"
	type="text" class="small" name="<%= LIFE_SPAN%>" value=""
	validate="Life Span,int,no" MAXLENGTH="4" tabindex=1 /> <select
	class="small" name="<%=DAYS%>" tabindex=1>
	<option value="d">Days</option>
	<option value="m">Months</option>
</select>
<div class="Clear"></div>
<div class="division"></div>
<label class="common"> Kept at Temp</label> <input id="temp"
	class="calDate" type="text" name="<%= TEMPERATURE%>" value=""
	validate="Kept at Temp,num,no" MAXLENGTH="6" tabindex=1 /> <label
	class="unit"> &deg;C </label> <label class="common"><span>*</span>
Default qty. per unit</label> <input id="qty" class="calDate" type="text"
	name="<%= QTY_PER_UNIT%>" value=""
	validate="Default qty. per unit,num,yes" MAXLENGTH="3" tabindex=1 /> <label
	class="unit"> ml </label> <label>Whole Blood</label> <select
	class="small" name="<%=WHOLE_BLOOD%>"
	onkeypress="return submitenter(this,event,'bloodBank?method=addBloodComponnet')"
	tabindex=1>
	<option value="y">Yes</option>
	<option value="n">No</option>
</select>
<div class="Clear"></div>
</div>
<div class="division"></div>

<div class="bottom">
<div class="Clear"></div>
<input type="button" name="add" id="addbutton" value="Add"
	class="button"
	onClick="if(checkSpecialChar())submitForm('bloodComponent','bloodBank?method=addBloodComponent');"
	accesskey="a" tabindex=1 /> <input type="button" name="edit"
	id="editbutton" value="Update" class="button"
	onClick="submitForm('bloodComponent','bloodBank?method=editBloodComponent')"
	accesskey="u" tabindex=1 /> <input type="button" name="Delete"
	id="deletebutton" value="Activate" class="button"
	onClick="submitForm('bloodComponent','bloodBank?method=deleteBloodComponent&flag='+this.value)"
	accesskey="d" tabindex=1 /> <input type="reset" name="Reset" id="reset"
	value="Reset" class="button" onclick="resetCheck();" accesskey="r"
	tabindex=1 /> <input type="hidden" name="<%=STATUS %>" value="" /> <input
	type="hidden" name="<%= BLOOD_COMPONENT_ID%>" value="" />
<div class="division"></div>
<div id="edited"></div>
<label>Changed By</label> <label class="value"><%=userName%></label> <label>Changed
Date</label> <label class="value"><%=date%></label> <label>Changed Time</label>
<label class="value"><%=time%></label> <input type="hidden"
	name="<%=CHANGED_BY%>" value="<%=userName%>" /> <input type="hidden"
	name="<%=CHANGED_DATE %>" value="<%=date%>" /> <input type="hidden"
	name="<%=CHANGED_TIME %>" value="<%=time%>" />

<div class="Clear"></div>
</form>
</div>
<script type="text/javascript">
		
		data_header = new Array();
		
		data_header[0] = new Array;
		data_header[0][0] = "Component Code"
		data_header[0][1] = "data";
		data_header[0][2] = "25%";
		data_header[0][3] = "<%= CODE%>"
		
		data_header[1] = new Array;
		data_header[1][0] = "Component Name"
		data_header[1][1] = "data";
		data_header[1][2] = "40%";
		data_header[1][3] = "<%= SEARCH_NAME %>";
		
		data_header[2] = new Array;
		data_header[2][0] = "Life Span"
		data_header[2][1] = "hide";
		data_header[2][2] = "35%";
		data_header[2][3] = "<%= LIFE_SPAN %>";
		
		data_header[3] = new Array;
		data_header[3][0] = ""
		data_header[3][1] = "hide";
		data_header[3][2] = 0;
		data_header[3][3] = "<%= TEMPERATURE%>"
		
		data_header[4] = new Array;
		data_header[4][0] = ""
		data_header[4][1] = "hide";
		data_header[4][2] = 0;
		data_header[4][3] = "<%= QTY_PER_UNIT%>"
		
		data_header[5] = new Array;
		data_header[5][0] = "Status"
		data_header[5][1] = "hide";
		data_header[5][2] = "15%";
		data_header[5][3] = "<%=WHOLE_BLOOD %>";
		
		data_header[6] = new Array;
		data_header[6][0] = ""
		data_header[6][1] = "hide";
		data_header[6][2] = "35%";
		data_header[6][3] = "<%= CHANGED_BY %>";
		
		data_header[7] = new Array;
		data_header[7][0] = ""
		data_header[7][1] = "hide";
		data_header[7][2] = 0;
		data_header[7][3] = "<%= CHANGED_DATE%>"
		
		data_header[8] = new Array;
		data_header[8][0] = ""
		data_header[8][1] = "hide";
		data_header[8][2] = 0;
		data_header[8][3] = "<%= CHANGED_TIME%>"
		
		data_header[9] = new Array;
		data_header[9][0] = "Days"
		data_header[9][1] = "hide";
		data_header[9][2] = "15%";
		data_header[9][3] = "<%=DAYS %>";
		
		data_header[10] = new Array;
		data_header[10][0] = "Status"
		data_header[10][1] = "data";
		data_header[10][2] = "15%";
		data_header[10][3] = "<%=STATUS %>";
		
		data_arr = new Array();

	<%
		Iterator itr = searchBloodComponentList.iterator();
	          int  counter=0;
	          while(itr.hasNext()){
	             BloodMasComponent  bloodComponent = (BloodMasComponent)itr.next(); 
	%>

		data_arr[<%= counter%>] = new Array();
		data_arr[<%= counter%>][0] =  <%= bloodComponent.getId()%>
		data_arr[<%= counter%>][1] = "<%= bloodComponent.getComponentCode()%>"
		data_arr[<%= counter%>][2] = "<%= bloodComponent.getComponentName()%>"
		<%if(bloodComponent.getLifeSpan() != null && bloodComponent.getLifeSpan()!=0){%>
		data_arr[<%= counter%>][3] = "<%= bloodComponent.getLifeSpan()%>"
		<%}else{%>
		data_arr[<%= counter%>][3] = ""
		<%}%>
		<%if(bloodComponent.getTemperature() != null && bloodComponent.getTemperature()!=0){%>
		data_arr[<%= counter%>][4] = "<%= bloodComponent.getTemperature()%>"
		<%}else{%>
		data_arr[<%= counter%>][4] = ""
		<%}%>
		<%if(bloodComponent.getQtyUnit() != null && bloodComponent.getQtyUnit()!=0){%>
		data_arr[<%= counter%>][5] = "<%= bloodComponent.getQtyUnit()%>"
		<%}else{%>
		data_arr[<%= counter%>][5] = ""
		<%}%>
		data_arr[<%= counter%>][6] = "<%= bloodComponent.getWholeBlood()%>"
		data_arr[<%= counter%>][7] = "<%= bloodComponent.getLastChgBy() %>"
		data_arr[<%= counter%>][8] = "<%= HMSUtil.convertDateToStringWithoutTime(bloodComponent.getLastChgDate())%>"
		data_arr[<%= counter%>][9] = "<%= bloodComponent.getLastChgTime() %>"
		data_arr[<%= counter%>][10] = "<%= bloodComponent.getPeriod() %>"
		<% if(bloodComponent.getStatus().equals("y")){ %>
		data_arr[<%= counter%>][11] = "Active"
		<%}else{%>
		data_arr[<%= counter%>][11] = "InActive"
		<%}%>
		<%
				     counter++;
		}
		%>
 
		formName = "bloodComponent"
    	 nonEditable = ['<%= CODE%>'];

		start = 0
		if(data_arr.length < rowsPerPage)
			end = data_arr.length;
		else
			end = rowsPerPage;
		makeTable(start,end);
		
		intializeHover('searchresulttable', 'TR', ' tableover');		
</script>
