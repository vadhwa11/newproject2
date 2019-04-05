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
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<script type="text/javascript">
	function checkAfmsfReceipt()
	{

	    var errMsg ="";
	
		if(document.getElementById("name").value==""){
			errMsg="Name should not be Blank\n"
		}
		if(document.getElementById("rankId").value==0)
		{
			errMsg=errMsg+"Select Rank \n"
		}
		
		if(document.getElementById("presentUnit").value==0){
			errMsg=errMsg+"Select present unit \n"
		}
		
		if(document.getElementById("postedTo").value==0){
			errMsg=errMsg+"Select postedTo \n"
		}
		
		if(document.getElementById("trade").value == 0){
		   errMsg=errMsg+"Select Trade \n"
		}
		
		if(document.getElementById("postOutDate").value == ""){
			errMsg=errMsg+"posted Out Date should not be Blank\n"
		}

		if(document.getElementById("lname").value==""){
			errMsg=errMsg+"Last Name should not be Blank\n"
		}
		
		if(document.getElementById("AuthorityPostIn").value == ""){
			errMsg=errMsg+"Authority Posted In should not be Blank\n"
		}
		<%--
		 if(document.getElementById("empAfmsId").value == 0)
		{
		 if( (document.getElementById("postedInDate").value == "") || (document.getElementById("recDate").value == ""))
		  {
		   errMsg="First add the arrival Entry and Receipt Entry"
		}}else {
		   if((document.getElementById("postedInDate").value == "") || (document.getElementById("recDate").value == ""))
		  {
		   errMsg="First add the arrival Entry and Receipt Entry"
		  }
		}--%>
		/*if(document.getElementById("suffix").value == "")
		{
		  errMsg=errMsg+"Select suffix \n"
		}
		if(document.getElementById("disLetterNo").value !== "")
		{
			  errMsg=errMsg+"Letter are AllReady Dispatch and You Can not be Perform Clearance \n"
		}
		if(document.getElementById("postedInDate").value != ""){
 	   var inDate = document.getElementById("postedInDate").value;
 	   var outDate=document.getElementById("postOutDate").value;
	  var formatInputDate=new Date(inDate.substring(6),(inDate.substring(3,5) - 1) ,inDate.substring(0,2));
	  var formatOutputDate=new Date(outDate.substring(6),(outDate.substring(3,5) -1), outDate.substring(0,2));
	 if(formatInputDate > formatOutputDate)
	 {
		errMsg=errMsg+"Date of postingout should be greater than equal to date of postingIn !";
	  }
	 }	*/
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
<script>
	function displayextrafields(){
	
	          var fromunit = document.getElementById("postedTo").value;
              if(fromunit == "Other"){
              document.getElementById('addUnitDiv').style.display = 'inline';
              }else{
              document.getElementById('addUnitDiv').style.display = 'none';
              }
    }	
    
   <%--  function openPopupWindowForUnit()
 {
  var url="/hms/hms/adt?method=showUnitSearchJsp";
  newwindow=window.open(url,'name',"left=100,top=100,height=700,width=850,status=1,scrollbars=1,resizable=0");
 }--%>
 
 function jsSetUnitData(unitId)
{
 for(var i=0;i<document.getElementById("postedTo").length;i++)
 {
	 if (document.getElementById("postedTo").options[i].value==unitId)
	 {
	 	document.getElementById("postedTo").selectedIndex = i;
	 }
 }
     var check = document.getElementById("postedTo").value;
     if(check != "Other"){
      document.getElementById('addUnitDiv').style.display = 'none';
     }
}
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
					 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<h4><%=message %></h4>
<% } %>

<div class="Clear"></div>
<div class="titleBg">
<h2>AFMSF-1 Clearance Form</h2>
</div>
<div class="Clear"></div>
<form name="deficientAfmsf1" method="post">
<script type="text/javascript">
function checkValidation(){
	var serviceNo = document.getElementById('serviceNo').value;
		var clearance = 'clearance';
	if( validateMetaCharacters(serviceNo) && validateMetaCharacters(clearance))
		submitProtoAjaxWithDivName('deficientAfmsf1','/hms/hms/mis?method=getHinNoForDeficient&respForm='+clearance+'&serviceNo='+serviceNo,'deficientId');
}
</script>
<div class="Block">
<label>Service No.</label> <input type="text"
	id="serviceNo" name="<%=SERVICE_NO%>" title="Fill Service No. first."
	value="" MAXLENGTH="30" validate="Service No.,metachar,no"
	onblur="checkValidation();" />
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<div id="deficientId">
<h4>Details</h4>
<div class="Block"><label>Service No</label> <input type="text"
	name="serviceNo" id="serviceNo1" value="" tabindex="1"  validate="Service No.,metachar,no" /> <% %> <%--<label ><span>*</span> Suffix:</label>
	  <select id="suffix" name="suffix" validate="Suffix,string,yes" tabindex="1" >
		<option value="">Select</option>
		<%
			for(char i='A'; i<='Z'; i++){
		%>
		<option value="<%=i%>"><%=i%></option>
		<%} %>
		<option value="-">-</option>
		</select> --%> <label> First Name<span>*</span></label> <input
	type="text" name="<%=EMPLOYEE_FIRST_NAME %>" tabindex="1" id="name"
	value="" MAXLENGTH="30" validate="First Name,metachar,yes" /> <label>Last
Name<span>*</span></label> <input type="text" name="<%=EMPLOYEE_LAST_NAME %>"
	tabindex="1" id="lname" value="" MAXLENGTH="30" validate="Last Name,metachar,yes"
	validate="Name,String,Yes" /> <label> Rank<span>*</span></label> <select
	name="<%=RANK_ID %>" id="rankId" tabindex="1" validate="Rank,metachar,yes" >
	<option value="0">Select</option>
	<%
							for (MasRank masRank : rankList) {
						%>
	<option value="<%=masRank.getId() %>"><%=masRank.getRankName()%></option>
	<%
						}
					%>
</select> <label> Trade<span>*</span></label> <!--  <input type="text"  name="<%="Trade" %>" id="Trade" value=""  MAXLENGTH="30" validate="Name,String,Yes" />
        --> <select name="<%=TRADE%>" id="trade" tabindex="1" validate="Trade,metachar,yes" >
	<option value="0">Select</option>
	<%
						for (MasTrade masTrade : tradeList) {
					%>
	<option value="<%=masTrade.getId()%>"><%=masTrade.getTradeName()%></option>
	<%	}	%>
</select> <label> Present Unit<span>*</span></label> <%-- <select name="<%=PRESENT_UNIT %>" id="presentUnit" tabindex="1" >
					<option value="0">Select</option>
					<option value="31">CHAFB</option>
					<option value="184">AFIDS</option>
					<option value="160">1 RAMT</option>
					<option value="59">MTC, AF</option>
	       </select> --%> <select name="<%=PRESENT_UNIT %>"
	id="presentUnit" tabindex="1" validate="Present Unit,metachar,yes" >
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%}		%>
	<option value="Other">Other</option>
</select>
<div class="Clear"></div>

<label> Posted To<span>*</span></label> <select name="<%=POSTED_TO %>"
	id="postedTo" tabindex="1" onchange="displayextrafields();"validate="Posted To,metachar,yes"  >
	<option value="0">Select</option>
	<%
						for (MasUnit masUnit : unitList) {
					%>
	<option value="<%=masUnit.getId()%>"><%=masUnit.getUnitName()%></option>
	<%	}	%>
	<option value="Other">Other</option>
</select> <%--	<IMG SRC="/hms/jsp/images/s_search.gif" WIDTH="26" HEIGHT="26" style="cursor:pointer;float:left;" onClick="javascript:openPopupWindowForUnit();" title="Click here to Search Unit">	
			
			
			 <div id="addUnitDiv" style="display: none;">
		
			<label > Unit Name</label>
			<input id="newUnitId" type="text" name="<%=UNIT_NAME%>" value=""   validate="Unit Address,string,no" maxlength="30" tabindex="1"/>
			
			<label > Unit 
			Address</label>
			<input id="newUnitAddressId" type="text" name="<%=UNIT_ADDRESS %>" value=""   validate="Unit Address,string,no" maxlength="50" tabindex="1"/>
           
          	<label >Is Local Unit</label>	
        	<input type="checkbox" id="localUnit" name="<%=LOCAL_UNIT %>" value="y"  tabindex="1" />
         </div>	 --%> <label>Date of posting Out</label> <input
	type="text" id="postOutDate" tabindex="1" name="<%=POST_OUT_DATE%>"
	value="" class="calDate" MAXLENGTH="30" readonly="readonly" validate="Date of posting Out,frdate,no"/> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" tabindex="1"
	height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate %>',document.deficientAfmsf1.<%=POST_OUT_DATE%>,event)" />

<label>Auth of Posting Out</label> <input type="text" validate="Auth of Posting Out,metachar,no"
	name="<%=AUTHORITY_POSTED_OUT%>" tabindex="1" id="AuthorityPostIn"
	value="" MAXLENGTH="30" />
<div class="clear"></div>
<label>AMA</label> 
 <textarea name="amaArrival" id="amaArrival"
	class="" tabindex="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" validate="AMA,metachar,no"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	maxlength="500" tabindex="1" ></textarea>
<div class="clear"></div>
</div>
</div>
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="edit" value="Submit" class="button"
	onClick="if(checkAfmsfReceipt() && (validateMetaCharacters(status))){submitForm('deficientAfmsf1','mis?method=editAfmsfDef&status=clearance');}" />
<div class="Clear"></div>
<div class="division"></div>
<div class="clear"></div>
<jsp:include page="currentUserDetails.jsp"></jsp:include>

<div class="Clear"></div>
<div id="edited"></div>
</form>







