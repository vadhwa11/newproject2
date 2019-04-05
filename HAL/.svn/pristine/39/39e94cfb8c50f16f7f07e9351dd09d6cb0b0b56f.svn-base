

<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%String userName = "";
	if (session.getAttribute("userName") != null) {
 		userName = (String) session.getAttribute("userName");
 	}
 	Map<String, Object> utilMap = new HashMap<String, Object>();
 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
 	Box box = HMSUtil.getBox(request);
 	Map<String, Object> map = new HashMap<String, Object>();
 	String currentDate = (String) utilMap.get("currentDate");
 	String time = (String) utilMap.get("currentTime");
	List<MasRank>rankList=new ArrayList<MasRank>();
	List<MasUnit>unitList=new ArrayList<MasUnit>();
	List<EmpAfmsfDet> empAfmsfDetList=new ArrayList<EmpAfmsfDet>();
	List<MasTrade> masTradeList = new ArrayList<MasTrade>();
	if (request.getAttribute("map") != null) {
 		map = (Map<String, Object>) request.getAttribute("map");
 	}
 	if (map.get("empAfmsfDetList") != null) {
 		empAfmsfDetList = (List<EmpAfmsfDet>) map.get("empAfmsfDetList");
 	}
 	System.out.println("empAfmsfDetList  "+empAfmsfDetList.size());
 	if (map.get("rankList") != null) {
 		rankList = (List<MasRank>) map.get("rankList");
 	}
 	if (map.get("unitList") != null) {
 		unitList = (List<MasUnit>) map.get("unitList");
 	}
 	if (map.get("masTradeList") != null) {
 		masTradeList = (List<MasTrade>) map.get("masTradeList");
 	}
 	System.out.println("masTradeList   "+masTradeList.size());
 	int tradeId =0;
 	int empAfmsId =0;
 	String name  = "";
 	int rankId =0;
 	int postedFromId =0;
 	int postedToId =0;
 	String respDate ="";
 	String letterNo="";
 	String authOfPosting ="";
 	String medicalCat ="";
 	String status ="";
 	for(EmpAfmsfDet empAfmsfDet :empAfmsfDetList){
 		empAfmsId = empAfmsfDet.getId();
 		name = empAfmsfDet.getEmpName();
 		if(empAfmsfDet.getRank() !=null)
 		rankId = empAfmsfDet.getRank().getId();
 		if( empAfmsfDet.getUnit() !=null)
 		postedFromId = empAfmsfDet.getUnit().getId();
 		if(empAfmsfDet.getPostedTo() !=null)
 		postedToId = empAfmsfDet.getPostedTo().getId();
 		if(empAfmsfDet.getFmsfDate() !=null){
 		respDate = ""+empAfmsfDet.getFmsfDate();
 		SimpleDateFormat formatterIn = new SimpleDateFormat("yyyy-MM-dd");
		 SimpleDateFormat formatterOut = new  SimpleDateFormat("dd/MM/yyyy");
		  respDate=formatterOut.format(formatterIn.parse(respDate));
 		}
 		if(empAfmsfDet.getLetterNo() !=null)
 		letterNo = empAfmsfDet.getLetterNo();
 		if(empAfmsfDet.getAuthPosting() !=null)
 		authOfPosting = empAfmsfDet.getAuthPosting();
 		if(empAfmsfDet.getStatus() !=null)
 		status = empAfmsfDet.getStatus();
 		if(empAfmsfDet.getMedCat() !=null)
 	 		medicalCat = empAfmsfDet.getMedCat();
 		if(empAfmsfDet.getTrade() !=null)
 	 		tradeId = empAfmsfDet.getTrade().getId();
 	}
 		
%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
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
<input type="hidden" name="<%=EMP_AFMS_ID%>" value="<%=empAfmsId %>" />
<label class="bodytextB"><font id="error">*</font>Name:</label> <input
	type="text" name="<%=EMPLOYEE_FIRST_NAME %>" id="name"
	value="<%=name%>" class="textbox_size20" MAXLENGTH="30"
	validate="Name,String,Yes" /> <label class="bodytextB"><font
	id="error">*</font>Rank:</label> <select name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select</option>
	<%for (MasRank masRank : rankList) {
						if(rankId ==masRank.getId()){%>
	<option value="<%=masRank.getId() %>" selected="selected"><%=masRank.getRankName()%></option>
	<%}else{%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%}} %>
</select> <label class="bodytextB"><font id="error">*</font>Posted From:</label>
<select name="<%=POSTED_FROM %>" id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(postedFromId ==masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}}%>
</select> <label class="bodytextB"><font id="error">*</font>Posted To:</label> <select
	name="<%=POSTED_TO %>" id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
							if(postedToId == masUnit.getId()){
					%>
	<option value="<%=masUnit.getId()%>" selected="selected"><%=masUnit.getUnitName()%></option>
	<%}else{%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}} %>
</select> </br>
<label class="bodytextB">Receipt Date:</label> <input type="text"
	id="inputDate" name="<%=RECEIPT_DATE%>" value="<%=respDate%>"
	class="textbox_date" MAXLENGTH="30" readonly="readonly" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPT_DATE%>,event)" />

<label class="bodytextB">P32 Sr No:</label> <input type="text"
	name="<%=LETTER_NO%>" value="<%=letterNo %>" class="textbox_size20"
	MAXLENGTH="30" /> <label class="bodytextB">Trade:</label> <select
	name="<%=TRADE_ID %>" id="lastUnit">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : masTradeList) {
							if(tradeId == masTrade.getId()){
					%>
	<option value="<%=masTrade.getId()%>" selected="selected"><%=masTrade.getTradeName()%></option>
	<%}else{%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%}} %>
</select> <label class="bodytextB">Description:</label> <input type="text"
	name="<%=DESCRIPTION%>" value="<%=authOfPosting %>"
	class="textbox_date" MAXLENGTH="30" /> <br />
<label class="bodytextB">Surplus:</label> <%if(status.equals("s")){ %> <input
	type="radio" name="<%= RADIO_FOR_TABLE%>" value="s" class="radiobutton"
	checked="checked" validate="Select status,String,Ye" id="status" /> <%}else{ %>
<input type="radio" name="<%= RADIO_FOR_TABLE%>" value="s"
	class="radiobutton" validate="Select status,String,Ye" id="status" /> <%} %>
<br />
<label class="bodytextB">Deficiant:</label> <%if(status.equals("d")){ %> <input
	type="radio" name="<%= RADIO_FOR_TABLE%>" value="d" class="radiobutton"
	checked="checked" validate="Select status,String,Ye" id="status" /> <%}else{ %>
<input type="radio" name="<%= RADIO_FOR_TABLE%>" value="d"
	class="radiobutton" validate="Select status,String,Ye" id="status" /> <%} %>
<br />
<label class="bodytextB">Equal:</label> <%if(status.equals("e")){ %> <input
	type="radio" name="<%= RADIO_FOR_TABLE%>" value="e" class="radiobutton"
	checked="checked" validate="Select status,String,Ye" id="status" /> <%}else{ %>
<input type="radio" name="<%= RADIO_FOR_TABLE%>" value="e"
	class="radiobutton" validate="Select status,String,Ye" id="status"
	checked="checked" /> <%} %>
</div>
</div>