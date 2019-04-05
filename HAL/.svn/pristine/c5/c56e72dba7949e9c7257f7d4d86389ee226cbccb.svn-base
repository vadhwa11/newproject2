<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<%@page import="jkt.hms.masters.business.MasTrade"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link href="/hms/jsp/css/hms_style.css" rel="stylesheet" type="text/css">

<br />
<div id="contentspace"><script type="text/javascript">
	function checkAfmsfReceipt(){
	var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		if(document.getElementById("lastUnit").value==0){
			errMsg=errMsg+"Select Last Unit \n"
		}
		
		if(errMsg==""){
			return true
		}else{
			alert(errMsg)
			return false;
		}
	}
	</script> <script type="text/javascript" language="javascript">
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


<h2 align="left" class="style1">Dispatch Pending Entry Form</h2>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	Box box = HMSUtil.getBox(request);
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;
			 	String serviceNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> employeeList = null;
			 	List<Object>empAfmsfDetList=null;
			 	List<MasRank>rankList=null;
				List<MasUnit>unitList=null;
				List<MasTrade> masTradeList = new ArrayList<MasTrade>();
				if (map.get("masTradeList") != null) {
			 		masTradeList = (List<MasTrade>) map.get("masTradeList");
			 	}
			 	System.out.println("masTradeList   "+masTradeList.size());
			 	if (map.get("employeeList") != null) {
			 		employeeList = (List<Object>) map.get("employeeList");
			 		
			 	}
			 	if (map.get("empAfmsfDetList") != null) {
			 		empAfmsfDetList = (List<Object>) map.get("empAfmsfDetList");
			 		
			 	}
			 	if (map.get("rankList") != null) {
			 		rankList = (List<MasRank>) map.get("rankList");
			 		
			 	}
			 	if (map.get("unitList") != null) {
			 		unitList = (List<MasUnit>) map.get("unitList");
			 		
			 	}
			 	if (map.get("serviceNo") != null) {
			 		serviceNo = (String) map.get("serviceNo");
			 		
			 	}
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>
<% } %>
<form name="deficientAfmsf1" method="post"><label
	class="bodytextB">Service No.:</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" title="Fill Service No. first."
	value="" class="textbox_date" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('deficientAfmsf1','/hms/hms/mis?method=getHinNoForSurplus&serviceNo='+this.value,'deficientId');" />
<br />
<br />
<div id="deficientId">
<div
	style="width: 15px; height: 20px; BORDER-bottom: #3c8ad7 1px solid; float: left;"></div>
<div
	style="background-color: #d3e8fd; BORDER-top: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; width: 187px; height: 20px; float: left;">
<font class="boxtitle">Details</font></div>

<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltbl.gif" /></div>
<br />

<div
	style="BORDER-top: #3c8ad7 1px solid; BORDER-RIGHT: #3c8ad7 1px solid; BORDER-LEFT: #3c8ad7 1px solid; BORDER-bottom: #3c8ad7 1px solid; width: 100%; height: 150px; background-color: #f4f9fe;">
<div style="height: auto; width: auto;"><br />
<label class="bodytextB"><font id="error">*</font>Name:</label> <input
	type="text" name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value=""
	class="textbox_size20" MAXLENGTH="30" validate="Name,String,Yes" /> <label
	class="bodytextB"><font id="error">*</font>Rank:</label> <select
	name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select</option>
	<%
							for (MasRank masRank : rankList) {
						%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
						}
					%>
</select> <label class="bodytextB"><font id="error">*</font>Posted From:</label>
<select name="<%=POSTED_FROM %>" id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>
</select> <label class="bodytextB"><font id="error">*</font>Posted To:</label> <select
	name="<%=POSTED_TO %>" id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>
</select> </br>
<label class="bodytextB">Receipt Date:</label> <input type="text"
	id="inputDate" name="<%=RECEIPT_DATE%>" value="<%=currentDate %>"
	class="textbox_date" MAXLENGTH="30" readonly="readonly" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPT_DATE%>,event)" />
<label class="bodytextB">P32 Sr No:</label> <input type="text"
	name="<%=LETTER_NO%>" value="" class="textbox_size20" MAXLENGTH="30" />
<label class="bodytextB">Trade:</label> <select name="<%=POSTED_TO %>"
	id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : masTradeList) {
					%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%} %>
</select> <label class="bodytextB">Description:</label> <input type="text"
	name="<%=DESCRIPTION%>" value="" class="textbox_date" MAXLENGTH="30" />
<br />
<label class="bodytextB">Surplus:</label> <input type="radio"
	name="<%= RADIO_FOR_TABLE%>" value="<%=userName%>" class="radiobutton"
	id="status" /> <br />
<label class="bodytextB">Deficiant:</label> <input type="radio"
	name="<%= RADIO_FOR_TABLE%>" value="<%=userName%>" class="radiobutton"
	id="status" /> <br />
<label class="bodytextB">Equal:</label> <input type="radio"
	name="<%= RADIO_FOR_TABLE%>" value="<%=userName%>" class="radiobutton"
	id="status" checked="checked" /></div>
</div>
</div>
<br />

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="button" name="edit" value="Submit" class="button"
	onClick="if(checkAfmsfReceipt()){submitForm('deficientAfmsf1','mis?method=editAfmsfSurplus','checkDateNotGreaterThanCurrentDate');}" />



<div id="edited"></div>
<label>&nbsp;</label></form>
</div>





