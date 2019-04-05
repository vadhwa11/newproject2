<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
function checkAfmsfReceipt(){

var errMsg ="";

	if(document.getElementById("name").value==""){
		errMsg="First Name should not be Blank\n"
	}
	if(document.getElementById("rankId").value==0)
	{
		errMsg=errMsg+"Select Rank \n"
	}
	if(document.getElementById("presentUnit").value==0){
		errMsg=errMsg+"Select present unit \n"
	}
	if(document.getElementById("trade").value == 0){
	   errMsg=errMsg+"Select Trade \n"
	}
	if(document.getElementById("dispatchLetterNo").value==""){
		errMsg=errMsg+"Dispatch letterno should not be Blank\n"
	}
	if(document.getElementById("disLetterVal").value!="")
	{
		errMsg=errMsg+"Letter are All Ready Dispatch and You Can't update the data\n"
	}
	
  if(document.getElementById("receipt").value != ""){
   var recDate = document.getElementById("receipt").value;
	   var disDate=document.getElementById("disPatchDate").value;
   var formatInputDateRec=new Date(recDate.substring(6),(recDate.substring(3,5) - 1) ,recDate.substring(0,2));
   var formatInputDateDis=new Date(disDate.substring(6),(disDate.substring(3,5) -1) , disDate.substring(0,2));
     if(formatInputDateRec > formatInputDateDis)
     {
	   errMsg=errMsg+"Dispatch Date should be greater than equal to receipt date !  \n";
     }
  }	
	if(document.getElementById("disPatchDate").value == ""){
		errMsg=errMsg+"Dispatchdate should not be Blank\n"
	}
	/* if(document.getElementById("suffix").value == ""){
	  errMsg=errMsg+"Select suffix \n"
	}*/
	if(document.getElementById("lname").value==""){
		errMsg=errMsg+"Last Name should not be Blank \n"
	}

	<%--
if(document.getElementById("empAfmsId").value == 0)
{
 if( (document.getElementById("postInDate").value == "") || (document.getElementById("receipt").value == ""))
  {
   errMsg="First add the arrival Entry and Receipt Entry"
  }
}else {
 if((document.getElementById("postInDate").value == "") || (document.getElementById("receipt").value == ""))
  {
   errMsg="First add the arrival Entry and Receipt Entry"
  }
}--%>
		
	if(errMsg==""){
		return true
	}else{
		alert(errMsg)
		return false;
	}
}
</script>
<script type="text/javascript" language="javascript">
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
	List<MasTrade>tradeList=null;
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
	if (map.get("tradeList") != null) {
		tradeList = (List<MasTrade>) map.get("tradeList");
 	}
	List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
	if (map.get("empAfmsfList") != null) {
		empAfmsfList = (List<EmpAfmsfDet>) map.get("empAfmsfList");
 		
 	}				 
 	if(map.get("message") != null){
		String message = (String)map.get("message");
		%>
<h4><%=message %></h4>
<% } %>
<div class="Clear"></div>
<div class="titleBg">
<h2>AFMSF-1 Dispatch Details</h2>
</div>

<div class="Clear"></div>
<form name="deficientAfmsf1" method="post">
<%
if(empAfmsfList.size() > 0){
%>
<h4>Pending List For Dispatch Entry</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Posting Out Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>

	</tr>
	<%
	for(EmpAfmsfDet empAfmsfDet : empAfmsfList){
%>
	<tr
		onclick="checkValidation();">
		<td><%=empAfmsfDet.getPostOutDate()!=null?(HMSUtil.convertDateToStringWithoutTime(empAfmsfDet.getPostOutDate())):"" %></td>
		<td><%=empAfmsfDet.getServiceNo()!=null?empAfmsfDet.getServiceNo():""%></td>
		<td><%=empAfmsfDet.getRank().getRankName() %></td>
		<%
		String name = empAfmsfDet.getEmpName();
		
		if(empAfmsfDet.getEmpLastName()!=null)
			name += " "+empAfmsfDet.getEmpLastName();
				
	%>
		<td><%=name%></td>

		<td><%=empAfmsfDet.getUnit().getUnitName() %></td>
	</tr>

	<%} %>
</table>
</div>
<div class="paddingTop15"></div>
<%} %>
<script type="text/javascript">
function checkValidation(){
	var serviceNo = document.getElementById('serviceNo').value;
		var respForm = 'respForm';
		var dispatch='dispatch';
	if( validateMetaCharacters(serviceNo) && validateMetaCharacters(respForm)){
		submitProtoAjaxWithDivName('deficientAfmsf1','/hms/hms/mis?method=getHinNoForDeficient&respForm='+dispatch+'&serviceNo='+serviceNo,'deficientId');
	}
}
</script>
<div class="Block"><label>Service No</label> <input type="text"
	id="serviceNo" name="<%=SERVICE_NO%>" title="Fill Service No. first."
	value="" MAXLENGTH="30" validate="Service No.,metachar,yes"
	onblur="checkValidation();" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="deficientId">
<h4>Details</h4>
<div class="Block"><label>Service No</label> <input type="text"
	name="serviceNo" id="serviceNo1" value="" validate="Service No.,metachar,yes"  /> <%--<label><span>*</span> Suffix:</label>
 <select id="suffix" name="suffix" validate="Suffix,string,yes" tabindex="1" >
<option value="">Select</option>
<%
	for(char i='A'; i<='Z'; i++){
%>
<option value="<%=i%>"><%=i%></option>
<%} %>
<option value="-">-</option>
</select> --%> 
<label> First Name<span>*</span></label> 
<input type="text" name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="" MAXLENGTH="30" validate="First Name,metachar,yes" /> 
<label> Last Name <span>*</span></label> 
<input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" value="" MAXLENGTH="30" validate="Last Name,metachar,yes"/> 
<label> Rank <span>*</span></label>
<select name="<%=RANK_ID %>" id="rankId" validate="Rank,metachar,yes">
	<option value="0">Select</option>
	<%
				for (MasRank masRank : rankList) {
			%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
			}
		%>
</select> 
<label> Trade <span>*</span></label> 
<select name="<%=TRADE%>" id="trade"  validate="Trade,metachar,yes">
	<option value="0">Select</option>
	<%
			for (MasTrade masTrade : tradeList) {
		%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
			}
		%>
</select> 
<label> Present Unit <span>*</span></label> <%--   <select name="<%=PRESENT_UNIT %>" id="presentUnit">
			<option value="0">Select</option>
			<option value="31">CHAFB</option>
			<option value="184">AFIDS</option>
			<option value="160">1 RAMT</option>
			<option value="59">MTC, AF</option>
</select>	 --%> 
<select name="<%=PRESENT_UNIT %>" id="presentUnit"
	tabindex="1"   validate="Present Unit,metachar,yes">
	<option value="0">Select</option>
	<%
			for (MasUnit masUnit : unitList) {
		%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
			}
		%>
	<option value="Other">Other</option>
</select>
<div class="Clear"></div>
<label>Dispatch Letter No</label> 
<input type="text" name="<%=DISPATCH_LETTER_NO%>" id="dispatchLetterNo" value="" validate="Dispatch Letter No,metachar,yes" MAXLENGTH="30" /> 
<label>Dispatch with Date</label> 
<input type="text" id="disPatchDate" name="<%=DISPATCHDATE%>" value="" class="calDate" MAXLENGTH="30" readonly="readonly" validate="Dispatch with Date,frdate,no" /> 
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" tabindex="1" height="16" border="0" validate="Pick a date" class="calender" onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=DISPATCHDATE%>,event)" />
<div class="Clear"></div>
<label>Remarks</label> 
<textarea name="<%=DIS_REMARKS%>" value="" id="<%=DIS_REMARKS%>" class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,yes"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="" style="width:478px;" /></textarea>
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<div id="edited"></div>
</form>
