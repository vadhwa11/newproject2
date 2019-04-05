<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript">
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
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("receiptLetterNo").value==""){
			errMsg=errMsg+"Receipt letterNo should not be Blank\n"
		}
		
		/*if(document.getElementById("receiptDate").value==""){
			errMsg=errMsg+"Receiptdate should not be Blank\n"
		}*/
		
		/*if(document.getElementById("suffix").value == ""){
		  errMsg=errMsg+"Select suffix \n"
		}*/
		
		if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank"
		}
		
		if(document.getElementById("afmsType").value == "OUT"){
		   errMsg=errMsg+"service person cleared this place you can't update the data"
		}

		if(validateMetaCharacters(errMsg))
		{
		 if(errMsg=="")
			 {
			return true
		   }
		  else{
			alert(errMsg)
			return false;
		}
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
		
		
	</script> <script>
	
	function displayextrafields(){
	          var fromunit = document.getElementById("lastUnit").value;
              if(fromunit == "Other"){
              document.getElementById('addUnitDiv').style.display = 'inline';
              }else{
              document.getElementById('addUnitDiv').style.display = 'none';
              }
  }
	
 function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }
 
 function jsSetUnitData(unitId)
{
 for(var i=0;i<document.getElementById("lastUnit").length;i++)
 {
	 if (document.getElementById("lastUnit").options[i].value==unitId)
	 {
	 	document.getElementById("lastUnit").selectedIndex = i;
	 }
 }
  var check = document.getElementById("lastUnit").value;
     if(check != "Other"){
      document.getElementById('addUnitDiv').style.display = 'none';
     }
}		
</script>
<div class="titleBg">
<h2>AFMSF-1 ReceiptEntry</h2>
</div>
<div class="Clear"></div>

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
					%> <h4><%=message %></h4> <% } %>
<script type="text/javascript">
function checkValidation(){
	var serviceNo = document.getElementById('serviceNo').value;
		var receipt = 'receipt';
	if( validateMetaCharacters(serviceNo) && validateMetaCharacters(receipt)){
		submitProtoAjaxWithDivName('deficientAfmsf1','/hms/hms/mis?method=getHinNoForDeficient&respForm='+receipt+'&serviceNo='+serviceNo,'deficientId');
	}
}
</script><div class="Clear"></div>
<form name="deficientAfmsf1" method="post">
<%
if(empAfmsfList.size() > 0){
%>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<h4>Pending List For Receipt Entry</h4>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Posting Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
	
	</tr>
		<tbody id="tableData">
<%
	for(EmpAfmsfDet empAfmsfDet : empAfmsfList){
%>
<tr>
	<td><%=empAfmsfDet.getPostInDate()!=null?(HMSUtil.convertDateToStringWithoutTime(empAfmsfDet.getPostInDate())):"" %></td>
	<td><%=empAfmsfDet.getServiceNo()!=null?empAfmsfDet.getServiceNo():""%></td>
	
	<td>
	<%if(empAfmsfDet.getRank()!=null){%>
	<%=empAfmsfDet.getRank().getRankName() %>
	<%} %>
	</td>
	<%
		String name = empAfmsfDet.getEmpName();
		
		if(empAfmsfDet.getEmpLastName()!=null)
			name += " "+empAfmsfDet.getEmpLastName();
		
		
	%>
	<td><%=name%></td>
	
	<td>
	<%if(empAfmsfDet.getUnit()!=null){ %>
	<%=empAfmsfDet.getUnit().getUnitName() %>
	
	<%} %>
	</td>
</tr>

<%} %>
</tbody>
</table>
</div>
<script>
		var pager = new Pager('tableData',10);
		pager.init();
		pager.showPageNav('pager', 'pageNavPosition');
		pager.showPage(1);
	  </script>
<%} %>
<div class="Block">
<label>Service No.</label>
<input type="hidden" name="afmsType" value="" id="afmsType" />
 <input
	type="text" id="serviceNo" name="<%=SERVICE_NO%>"
	title="Fill Service No. first." value="" MAXLENGTH="30" validate="Service No.,metachar,no"
	onblur="checkValidation();" />
<div class="Clear"></div>
</div>

<div id="deficientId">

<h4>Details</h4>
<div class="Clear"></div>
<div class="Block">

<label>Service No</label> <input
	type="text" name="serviceNo" id="serviceNo1" value="" validate="Service No.,metachar,no" /> 
	<%--
	<label><span>*</span>
Suffix:</label> <select id="suffix" name="suffix" validate="Suffix,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select>
 --%>

<label> First Name <span>*</span></label> <input type="text"
	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="" MAXLENGTH="30"
	validate="First Name,metachar,Yes" /> <label>Last
Name <span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" validate="Last Name,metachar,Yes"
	value="" MAXLENGTH="30" /> <label> Rank<span>*</span></label> <select validate="Rank,metachar,yes"
	name="<%=RANK_ID %>" id="rankId">
	<option value="0">Select</option>
	<%
							for (MasRank masRank : rankList) {
						%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
						}
					%>
</select>

<label> Trade <span>*</span></label> <!--  <input type="text"  name="<%="Trade" %>" id="Trade" value="" class="textbox_date" MAXLENGTH="30" validate="Name,String,Yes" />
        --> <select name="<%=TRADE%>" id="trade" validate="Trade,metachar,yes">
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
					%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%
						}
					%>
</select> 
<label> Last Unit <span>*</span></label> <select validate="Last unit,metachar,yes"
	name="<%=POSTED_FROM %>" id="lastUnit" onchange="displayextrafields();">
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
<%-- <IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit">
<div class="Clear"></div>
<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" tabindex="1" /> <label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit</label> <input
	type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" class="radio"
	value="y" tabindex="" /></div>--%>

<label> Present Unit<span>*</span></label>
<%-- <select
	name="<%=PRESENT_UNIT %>" id="presentUnit">
	<option value="0">Select</option>
	<option value="31">CHAFB</option>
	<option value="184">AFIDS</option>
	<option value="160">1 RAMT</option>
	<option value="59">MTC, AF</option>
</select> --%>
<select
	name="<%=PRESENT_UNIT %>" id="presentUnit" validate="Present Unit,metachar,yes">
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

 <label>Receipt Letter No</label> <input type="text" name="<%=RECEIPT_LETTER_NO%>" id="receiptLetterNo" value="" validate="Present Unit,metachar,yes" 	MAXLENGTH="30" /> 
 <label>Receipt with Date:</label> 
 <input
	type="text" id="receiptDate" name="<%=RECEIPTDATE%>" value=""
	class="calDate" MAXLENGTH="30" readonly="readonly" validate="Receipt with Date,frdate,no" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />

<div class="Clear"></div>
<label>Remarks</label> <!--  <input type="textarea"  name="<%=REMARKS%>" id="<%=REMARKS%>" value="" class="txtarea" MAXLENGTH="50" />-->
<textarea name="<%=REMARKS%>" value="" id="<%=REMARKS%>" 
	onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Remarks,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="45" tabindex="" /></textarea>
		<label>Docs Received</label> 
 <textarea name="docReceived" id="docReceived"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="Docs Received,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
	
<div class="Clear"></div>
</div>
</div>

<div class="Clear"></div>
<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	readonly="readonly" MAXLENGTH="8" tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	readonly="readonly" tabindex=3 />
<input type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	readonly="readonly" tabindex=3 />
<!--   <input type="button" name="edit" value="Submit" class="button" onClick="if(checkAfmsfReceipt()){submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=receipt');}" />  
	     -->
	<%-- --%>
	<input type="button" name="edit" value="Submit" class="button" onClick="if(checkAfmsfReceipt() && (validateMetaCharacters(status))){submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=receipt');}" />  
 
<div id="edited"></div>
<div class="Clear"></div>
</form>





