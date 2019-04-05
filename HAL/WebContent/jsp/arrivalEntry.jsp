<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.EmpAfmsfDet"%>

<%@page import="jkt.hms.masters.business.MasMedicalCategory"%>

<%@page import="jkt.hms.masters.business.MasBloodGroup"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
	function checkAfmsfReceipt()
	{  

	 var errMsg ="";
	
		/*if(document.getElementById("name").value==""){
			errMsg="First Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("lastUnit").value==0){
			errMsg=errMsg+"Select posted from Unit \n"
		}
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("medicalCategory").value == 0){
		   errMsg=errMsg+"Select medicalCategory \n"
		}
		
		if(document.getElementById("Authority").value == ""){
		   errMsg=errMsg+"Authority of posting In should not be Blank \n"
		}*/
		
		/*if(document.getElementById("suffix").value == ""){
		  errMsg=errMsg+"Select suffix \n"
		}*/
		
	/*	if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank\n"
		}
		
		if(document.getElementById("docStatusVal").value != "" && document.getElementById("docStatusVal").value !='d')
		{
			  errMsg=errMsg+"Receipt Entry All Ready Filled and You Can't update the data \n"
		}*/
		
		if(document.getElementById("receiptLatterNo").value == "")
		{
		document.getElementById("docStatus").value = 'd';  
		}else{
		 document.getElementById("docStatus").value = 'e';
		}
		
	/*	if(document.getElementById("afmsType").value == "OUT")
		{
		   errMsg=errMsg+"service person cleared this place you can't update the data \n"
		}*/
	//	alert("errMsg----"+errMsg);
	
		
		  if(errMsg == "")
		 {
			return true
		 }
		 else
			 {
			alert(errMsg)
			return false;
		    }
		
	 }
	
	function displayextrafields(){
				var medicalcatId = document.getElementById('medicalCategory').value;
				if(medicalcatId == 1){
				      document.getElementById('medDiv').style.display = 'none';
				}else if(medicalcatId != 1){
					  document.getElementById('medDiv').style.display = 'inline';
				}
  }
  
  function displayotherfields(){
              var fromunit = document.getElementById("lastUnit").value;
              if(fromunit == "Other"){
              document.getElementById('addUnitDiv').style.display = 'inline';
             // document.getElementById('newline').style.display = 'inline';
              }else{
              //document.getElementById('addUnitDiv').style.display = 'none';
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
				List<MasMedicalCategory>masMedicalList=null;
				List<MasBloodGroup> bloodGroupList=null;
			 	
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
				if (map.get("masMedicalList") != null) {
					masMedicalList = (List<MasMedicalCategory>) map.get("masMedicalList");
			 		
			 	}
				if (map.get("bloodGroupList") != null) {
					bloodGroupList = (List<MasBloodGroup>) map.get("bloodGroupList");
			 		
			 	}	
				List<EmpAfmsfDet> empAfmsfList = new ArrayList<EmpAfmsfDet>();
				if (map.get("empAfmsfList") != null) {
					empAfmsfList = (List<EmpAfmsfDet>) map.get("empAfmsfList");
			 		
			 	}	
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> 
<h4> <%=message %> </h4> <% } %>

<div class="Clear"></div>
<div class="titleBg">
<h2>AFMSF-1 Arrival Entry</h2>
</div>
<form name="deficientAfmsf1" method="post">
<%
if(empAfmsfList.size() > 0){
%>
<h4>Pending List For Arrival Entry</h4>
<div id="pageNavPosition"></div>
<div class="Clear"></div>
<div id="reg">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<th scope="col">Receipt Date</th>
		<th scope="col">Service No.</th>
		<th scope="col">Rank</th>
		<th scope="col">Name</th>
		<th scope="col">Unit</th>
	
	</tr>
	<tbody id="tableData">
<%
	for(EmpAfmsfDet empAfmsfDet : empAfmsfList){
%>

<tr onclick="checkValidation();">
	<td><%=empAfmsfDet.getRecDate()!=null?(HMSUtil.convertDateToStringWithoutTime(empAfmsfDet.getRecDate())):"" %></td>
	<td><%=empAfmsfDet.getServiceNo()!=null?empAfmsfDet.getServiceNo():""%></td>
	<td><%=empAfmsfDet.getRank().getRankName() %></td>
	<%
		String name = empAfmsfDet.getEmpName();
		
		if(empAfmsfDet.getEmpLastName()!=null)
			name += " "+empAfmsfDet.getEmpLastName();
		
		
	%>
	<td><%=name%></td>
	
	
	<%
	String unitNmae="";
	if(empAfmsfDet.getUnit() !=null){
		unitNmae=empAfmsfDet.getUnit().getUnitName();
		}%>
	<td><%=unitNmae %></td>
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
<div class="paddingTop15"></div>
<%} %>
<script type="text/javascript">
function checkValidation()
	{
		var serviceNo = document.getElementById('serviceNo').value;
		var arrival = 'arrival';
	if( validateMetaCharacters(serviceNo) && validateMetaCharacters(arrival))
	{
		submitProtoAjaxWithDivName('deficientAfmsf1','/hms/hms/mis?method=getHinNoForDeficient&respForm='+arrival+'&serviceNo='+serviceNo,'deficientId');
	}
</script>

<div class="Clear"></div>

<div class="Block">
<label>Service No.</label> 
<input type="hidden" name="docStatus" value="" id="docStatus" validate="docStatus,metachar,yes" />
<input type="hidden" name="docStatusVal" value="" id="docStatusVal" validate="docStatusVal,metachar,yes" />

<input type="hidden" name="afmsType" value="" id="afmsType" validate="afmsType,metachar,yes" />

<input 	type="text" id="serviceNo" name="<%=SERVICE_NO%>" 	title="Fill Service No. first." value="" MAXLENGTH="30" validate="Service No.,metachar,no"
	onblur="checkValidation();" />
	</div>
<div class="Clear"></div>

<div class="Clear"></div>

<div id="deficientId">
<h4>Details</h4>
<div class="Block">
<label>Service No.</label> 
<input 	type="text" name="serviceNo" id="serviceNo1" value="" validate="Service No.,metachar,no"/> 
	
	<%--<label><span>*</span>
Suffix:</label> <select id="suffix" name="suffix" validate="Suffix,string,yes"
	tabindex="1">
	<option value="">Select</option>
	<%
			for(char i='A'; i<='Z'; i++){
		%>
	<option value="<%=i%>"><%=i%></option>
	<%} %>
	<option value="-">-</option>
</select> --%>

<label> First Name <span>*</span></label>
 <input type="text"	name="<%=EMPLOYEE_FIRST_NAME %>" id="name" value="" MAXLENGTH="30"	validate="Name,metachar,Yes" /> 
	

<label> Last Name <span>*</span></label> 
<input type="text" name="<%=EMPLOYEE_LAST_NAME %>" id="lname" validate=" Last Name,metachar,yes"	value="" MAXLENGTH="30" /> 
	 <label> Rank <span>*</span></label>
	  <select	name="<%=RANK_ID %>" id="rankId" validate="Rank,metachar,yes">
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

<label>Medical Category </label> <select
	name="<%=MEDICAL_CATEGORY %>" id="medicalCategory" validate="Medical Category,metachar,yes"
	onchange="displayextrafields();">
	<option value="0">Select</option>
	<%
						for (MasMedicalCategory masMedical : masMedicalList) {
					%>
	<option value="<%=masMedical.getId()%>"><%=masMedical.getMedicalCategoryName()%></option>
	<%
						}
					%>
</select>
<div class="Clear"></div>

<div id="medDiv" style="display: none;"><label>
Diagnosis <span>*</span></label> <input id="sickLeave" type="text" name="<%=DIAGNOSIS%>"
	value="" validate="Unit Address,metachar,no" maxlength="30" tabindex="1" />

<label> Next review Date <span>*</span></label> <input type="text"
	id="nextreviewDate" name="<%=NEXT_REVIEW_DATE%>" value="" validate="Next review Date,frdate,no" 
	class="calDate" MAXLENGTH="30" readonly="readonly" /> 
	
	<img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=NEXT_REVIEW_DATE%>,event)" />
		
	</div>
	
	<label>Blood Group</label> 
<select name="bloodGroupId"	id="srBldGrp" validate="Blood Group,metachar,no" tabindex="1">	
<option value="0">Select</option>
	<%
	 for(MasBloodGroup  masBloodGroup : bloodGroupList){
	%>
	<option value="<%=masBloodGroup.getId()%>"><%=masBloodGroup.getBloodGroupName()%></option>
	<%}%>
</select>	
	
	
<label> Present Unit <span>*</span></label> 
 
<select name="<%=PRESENT_UNIT %>" class="large2" id="presentUnit" validate="Present Unit,metachar,no" >
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%
						}
					%>

</select> 

<%--<select
	name="<%=PRESENT_UNIT %>" id="presentUnit">
	<option value="0">Select</option>
	<option value="31">CHAFB</option>
	<option value="184">AFIDS</option>
	<option value="160">1 RAMT</option>
	<option value="59">MTC, AF</option>
</select> --%> 

<label> Posted From <span>*</span></label> <select
	name="<%=POSTED_FROM %>" class="large2" id="lastUnit" validate="Posted From,metachar,no"
	onchange="displayotherfields();">
	<option value="0">Select</option>
	<%	for (MasUnit masUnit : unitList) {	%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%		}		%>
	<%--<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26"
	style="cursor: pointer; float: left;"
	onClick="javascript:openPopupWindowForUnit();"
	title="Click here to Search Unit">
					
	<option value="Other">Other</option> --%>
</select> 


<%--<div id="addUnitDiv" style="display: none;"><label> Unit
Name</label> <input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""
	validate="Unit Address,string,no" maxlength="30" tabindex="1" />  


	<label>
Unit Address</label> <input id="newUnitAddressId" type="text"
	name="<%=UNIT_ADDRESS %>" value="" validate="Unit Address,string,no"
	maxlength="50" tabindex="1" /> <label>Is Local Unit:</label> <input
	type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y"
	class="radio" tabindex="1" />
	</div> --%>

<div class="clear"></div>
<label> Posting Date <span>*</span></label> <input type="text"
	id="dateOfPosting" name="<%=POST_IN_DATE%>" value="" validate="Posting Date,frdate,no"
	class="calDate" MAXLENGTH="30" readonly="readonly"  /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_IN_DATE%>,event)" />

<label> Posting Auth <span>*</span></label> 
<input type="text"	name="<%=AUTHORITY%>" id="Authority" value="" validate="Posting Auth,metachar,yes"
	MAXLENGTH="30" tabindex="1" />
<label>Receipt Latter No </label>
 <input	id="receiptLatterNo"  type="text"
	name="<%=RECEIPT_LETTER_NO%>" value="" maxlength="30" validate="Receipt Latter No,metachar,no"	tabindex="1" />
<div class="Clear"></div>

 <label>Receipt With Date</label> 
 <input type="text"	id="receiptDate" name="<%=RECEIPTDATE %>" value="" validate="Receipt With Date,frdate,no"
	class="calDate" readonly="readonly"	 /> 
	<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=RECEIPTDATE%>,event)" />
<label>Remarks </label>
 <textarea name="<%=REMARKS%>" id="<%=REMARKS%>"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" validate="remarks,metachar,no"
	maxlength="45" tabindex="1" />
 </textarea>
	
	<label>Docs Received</label> 
 <textarea name="docReceived" id="docReceived"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)" validate="Docs Received,metachar,no"
	maxlength="500" tabindex="1" ></textarea>
	<div class="clear"></div>
	<label>AMA</label> 
 <textarea name="amaArrival" id="amaArrival"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="AMA,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
	
	</div>
<div class="Clear"></div>
</div>
<!--<label>Date of posting In</label> <input type="text"
	id="dateOfPosting" name="<%=DATE_OF_POSTING%>" value="" class="calDate"
	MAXLENGTH="30" readonly="readonly" /> <img id="calendar"
	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=DATE_OF_POSTING%>,event)" />

<div id="nxtspace1" style="display: none;">
</div>

<label>Auth of Posting In</label> <input type="text"
	name="<%=AUTHORITY%>" id="Authority" value="" MAXLENGTH="30" /></div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>--> 

<input type="hidden" name="status" id="statusId" value="arrival" />
	  <input
	type="button" name="edit" value="Submit" class="button"
	
	onclick="saveData();"/>
	
	<%--
	<input
	type="button" name="edit" value="Submit" class="button"
	onClick="submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=arrival');" /> --%>
	


<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>
	

<div class="Clear"></div>
<script>
function saveData(){
var status=document.getElementById('statusId').value;
//alert("status-------->"+status);
if(checkAfmsfReceipt() && (validateMetaCharacters(status))){
	submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status='+status);
}
}
</script>

<div id="edited"></div>
</form>


<script>
  //  document.getElementById('nxtspace').style.display = 'inline';
 </script>



