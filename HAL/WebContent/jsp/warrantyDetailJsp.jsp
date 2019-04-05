<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="java.util.*"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/style.css"	id="vbulletin_css" />
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js"></script>
<script language="javascript"  type="text/javascript" src="/hms/jsp/js/calendar.js"></script>

<script>
<%
	Calendar calendar=Calendar.getInstance();
	String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
	String date=String.valueOf(calendar.get(Calendar.DATE));
	int year1=calendar.get(calendar.YEAR);
	if(month1.length()<2){
		month1="0"+month1;
	}
	if(date.length()<2){
		date="0"+date;
	}
%>
serverdate = '<%=date+"/"+month1+"/"+year1%>'
</script>
<%
	Map map= new HashMap();
	Map<String, Object> utilMap = new HashMap<String, Object>();
	if (request.getAttribute("map") != null) {
		map = (Map) request.getAttribute("map");
	}
	utilMap = (Map<String, Object>)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");
	String currentTime = (String)utilMap.get("currentTime");
	String message="";
	if(map.get("message") != null){
		message = (String)map.get("message");
	}

	int requestId=0;
	int warrantyType=0;
	if(request.getParameter("requestId")!=null){
		String[] requestValue=request.getParameter("requestId").toString().trim().split(",");
		requestId=Integer.parseInt(requestValue[0]);
		warrantyType=Integer.parseInt(requestValue[1]);
	}
	String warrantyValue="";
	if(1==warrantyType){
		warrantyValue="Warranty";
	}else if(2==warrantyType){
		warrantyValue="CAMC";
	}else if(3==warrantyType){
		warrantyValue="CMC";
	}else if(4==warrantyType){
		warrantyValue="AMC";
	}
	
	if(requestId>0){
%>
<div class="titleBg">
<h2><%=warrantyValue%> Detail</h2>
</div>
<form name="warrantyForm" method="post">
<div class="Block">
	<label><%=warrantyValue%> Start Date</label>
	<input type="text" name="warrantyStartDate<%=requestId %>" id="warrantyStartDate<%=requestId %>" readonly="readonly"	value="<%=currentDate%>" class="date" maxlength="30"  />
	<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.warrantyForm.warrantyStartDate<%=requestId %>,event);" />
	<label><%=warrantyValue%> End Date</label>
	<input type="text" name="warrantyEndDate<%=requestId %>" readonly="readonly" id="warrantyEndDate<%=requestId %>"	value="<%=currentDate%>" class="date" maxlength="30"  />
	<img	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" onclick="setdate('<%=currentDate%>',document.warrantyForm.warrantyEndDate<%=requestId %>,event);" />
	<div class="clear"></div>
	<label><%=warrantyValue%> Details</label>
	<textarea rows="5" cols="50" name="warrantyDetails<%=requestId %>" id="warrantyDetails<%=requestId %>" maxlength="200"></textarea>
	<div class="clear"></div>
	<label>Preventive</label>
	<input type="checkbox" class="radioCheck"   onclick="preventiveFun(this)"  id="preventiveN<%=requestId %>"   name="preventive<%=requestId %>" value="<%=requestId %>" />
<!-- 	No<input type="radio" class="radioCheck"  title="No" onclick="preventiveFun(this.value)" checked="checked" id="preventiveN"   name="preventive" value="No" /> -->
<!-- 	Yes<input type="radio" class="radioCheck" title="Yes" onclick="preventiveFun(this.value)" id="preventiveY"  name="preventive" value="Yes" /> -->
	<div class="clear"></div>
   <div id="preventiveId" style="display: none">
	<label>Total Preventive</label>
	<select name="totalPreventive" id="totalPreventive">
		<option value="">--Select--</option>
		<%for(int i=1;i<=12;i++){ %>
		<option value="<%=i%>"><%=i%></option>
		<%} %>
	</select>
	<div style="display: none;">
	<label >Check List</label>
	<input type="checkbox" class="radioCheck"  title="No" onclick="checkListFun(this)"  id="chekListN<%=requestId %>"   name="chekList<%=requestId %>" value="<%=requestId %>" />
	</div>
<!-- 	No<input type="radio" class="radioCheck"  title="No" onclick="checkListFun(this.value)" checked="checked" id="chekListN"   name="chekList" value="No" /> -->
<!-- 	Yes<input type="radio" class="radioCheck" title="Yes" onclick="checkListFun(this.value)"  name="chekList" id="chekListY" value="Yes" /> -->
	<div class="clear"></div>
	<div id="checkListId" style="display: none">
	<input type="button" class="button" onclick="addRow()" value="Add" />
	<input type="button" class="button" onclick="removeRow()" value="Remove" />
	<div class="clear"></div>
	<table id="chListTable">
		<tr><th>S.No.</th><th>Check List Name</th></tr>
		<tr><td><input type="checkbox" class="radioCheck" name="checkList" id="counter" value="1" /></td><td><input type="text" name="checkListName" maxlength="30" /></td></tr>
	</table>
	
	</div>
	</div>
</div>
<div class="clear"></div>
<input type="button" class="button" onclick="getWarrantyData()" value="Submit" />	
<input type="button" class="button" onclick="funClose()" value="Close" />

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<%} %>
<script>
	function funClose(){
		window.opener.document.getElementById("warranty<%=requestId%>").checked=false;
		window.close();
	}
	function preventiveFun(id){
		document.getElementById("preventiveId").style.display="none";
		if(id.checked){
		document.getElementById("preventiveId").style.display="";
		}
	}
	function checkListFun(id){
		document.getElementById("checkListId").style.display="none";
		if(id.checked){
			document.getElementById("checkListId").style.display="";
		}
	}
	
	function addRow()
	{
		var tbl = document.getElementById("chListTable");
		var lastRow = tbl.rows.length;
		var row = tbl.insertRow(lastRow);
		var hdb = document.getElementById('counter');
		var iteration = parseInt(hdb.value)+1;
		hdb.value = iteration;
		
		var cell0 = row.insertCell(0);
		var e0 = document.createElement('input');
		e0.type = 'checkbox';
		e0.name='checkList';
		e0.id='checkList'+(iteration);
		e0.className = 'radioCheck';
		e0.value=(iteration);
		cell0.appendChild(e0);
		
		var cell1 = row.insertCell(1);
		var e1 = document.createElement('input');
		e1.type="text";
		e1.name = 'checkListName';
		e1.id = 'checkListName'+iteration;
		e1.size="25";
		e1.maxlength="30";
		cell1.appendChild(e1);
       
	}
	
	function removeRow()
	{
		var tbl = document.getElementById('chListTable');
		 var tblRows  = tbl.getElementsByTagName("tr");
		
	  	if(tblRows.length-2==0){
	         	alert("Can not delete all rows")
	         	return false;
	     }
	  	alert(document.getElementsByName('checkList').length);      
	  	for(abc=0;abc<document.getElementsByName('checkList').length;abc++)
		{
			if (document.getElementsByName('checkList')[abc].checked == true)
			{
			  	tbl.deleteRow(abc+1);
			}
		}
	}
	function getWarrantyData(){
		window.opener.document.getElementById("warrantyStartDate<%=requestId%>").value=document.getElementById("warrantyStartDate<%=requestId%>").value;
		window.opener.document.getElementById("warrantyEndDate<%=requestId%>").value=document.getElementById("warrantyEndDate<%=requestId%>").value;
		window.opener.document.getElementById("warrantyDetails<%=requestId%>").value=document.getElementById("warrantyDetails<%=requestId%>").value;
		var preventive="";
		if(document.getElementById("preventiveN<%=requestId%>").checked){
			preventive=document.getElementById("preventiveN<%=requestId%>").value;
		}
// 		if(document.getElementById("preventiveY").checked){
// 			preventive=document.getElementById("preventiveY").value;
// 		}
		window.opener.document.getElementById("preventive<%=requestId%>").value=preventive;
		window.opener.document.getElementById("totalPreventive<%=requestId%>").value=document.getElementById("totalPreventive").value;
		var chekList="";;
			if(document.getElementById("chekListN<%=requestId%>").checked){
				chekList=document.getElementById("chekListN<%=requestId%>").value;
			}
<%-- 			if(document.getElementById("chekListY<%=requestId%>").checked){ --%>
<%-- 				chekList=document.getElementById("chekListY<%=requestId%>").value; --%>
// 			}
			window.opener.document.getElementById("checkList<%=requestId%>").value=chekList;
		if(chekList=="<%=requestId%>"){
			var checkName="";
			if(document.getElementsByName("checkListName").length>0){
			for(var i=0;i<document.getElementsByName("checkListName").length;i++){
				checkName+=document.getElementsByName("checkListName")[i].value+"@#";
			}
			}
			window.opener.document.getElementById("checkListName<%=requestId%>").value=checkName;
		}
		window.close();
	}
	
	
	
</script>