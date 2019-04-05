<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.masters.business.MasServiceType"%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<div id="contentHolder"><script type="text/javascript"language="javascript">
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
		
	function datevalidation(){
	
	
	var fdate = document.getElementById('FromDateId');
	var tdate = document.getElementById('ToDateId');
	
	frdate  = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2));
	todate  = new Date(tdate.value.substring(6),(tdate.value.substring(3,5) - 1) ,tdate.value.substring(0,2));
	
	tempdate = new Date(fdate.value.substring(6),(fdate.value.substring(3,5) - 1) ,fdate.value.substring(0,2) -1 + 7);
	
	if(fdate.value != "" && todate.value != ""){
	 if(todate > tempdate){
	  alert("FromDate and ToDate difference should be one week");
	   return false;
	  }
	}else{
	 return false;
	}

	//alert("from date formate:::"+frdate.getMonth());
	//alert("year:::"+frdate.getFullYear());
	//alert("date::::::::"+frdate.getDate());
	//alert("tempdate::::::::"+tempdate);
	return true;	
		
		}
		
		
		function fillServiceType(){
			var obj = document.getElementById("serviceTypeId");
			var val = obj.value;
			for(i=0;i<obj.length;i++)
			{
				if(obj.options[i].value == val)
				{
					serviceName = obj.options[i].text
					break;
				}
			}
			if(serviceName !="Select"){
				document.getElementById("serviceTypeName").value =serviceName
			}else{
				document.getElementById("serviceTypeName").value =""
			}
			}
			
	</script>
	
	
	 <%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> map = new HashMap<String, Object>();
				if(request.getAttribute("map") != null){
					map=(Map<String, Object>)request.getAttribute("map");
				}
		
				Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	
			 	List<MasServiceType> serviceTypeList = new ArrayList<MasServiceType>();
				
				if(map.get("serviceTypeList") != null){
					serviceTypeList= (List<MasServiceType>)map.get("serviceTypeList");
				}
	%>
<h6>SIL/DIL In LIEU of Message Form</h6>

<div class="Clear"></div>

<form name="silDilReport" target="_blank" method="post" action="">
<div class="blockFrame">

<label class="medium"> From Date:</label>
<input type="text" id="FromDateId" name="<%=FROM_DATE %>"value="<%=currentDate %>" class="calDate" readonly="readonly"MAXLENGTH="30" /> 
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="Pick a date" class="calender"
	onClick="setdate('<%=currentDate%>',document.silDilReport.<%=FROM_DATE%>,event)" />

<label>To Date:</label>
 <input type="text" id="ToDateId"name="<%=TO_DATE %>" value="<%=currentDate %>" class="calDate"	readonly="readonly" MAXLENGTH="30" /> 
	<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
	validate="Pick a date" class="calender"	onClick="setdate('<%=currentDate%>',document.silDilReport.<%=TO_DATE%>,event)" />
	
	
<label > Service Type:</label>
<select id="serviceTypeId" name="<%=SERVICE_TYPE_ID %>" validate="Service Type,string,no" onchange="fillServiceType();" tabindex="1" >
		<option value="0">Select</option>
		<% 
			for(MasServiceType masServiceType : serviceTypeList){
		%>
		<option value="<%=masServiceType.getId() %>"><%=masServiceType.getServiceTypeName() %></option>
		<%} %>
</select>

 <input type="hidden" name="<%=SERVICE_TYPE_NAME %>" id="serviceTypeName" />
<div class="Clear"></div>
<label class="medium">Rank:</label> <input type="text" name="rank"	value="" class="" MAXLENGTH="30" />


<label class="medium">Name:</label> <input type="text" name="name"	value="" class="" MAXLENGTH="30" />
	
	
	 <label> Drafter Name:</label> <input
	type="text" name="drafterName" value="" class="" MAXLENGTH="30" /> 
	
<div class="Clear"></div>	
	<label class="medium"> To:</label> 
	<textarea name="to"	validate="Kin Address,string,Yes" id="nokAddr" cols="53" rows="3"
	onpaste="return checkOnPaste(this)"	oninput="return checkMaxLengthMoz(this)"
	onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"	tabindex="1" /></textarea>
</td>
<textarea name="to2" validate="Kin Address,string,Yes" id="nokAddr"	cols="53" rows="3" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)"onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
	tabindex="1" />
</textarea>
</td>
</div>
<div class="Clear"></div>
<label>In Pdf :</label> 
<input type="radio" name="<%=SELECTED_RADIO  %>"
	value="1" checked="checked" />
	
 <label>In Word:</label>
  <input	type="radio" name="<%=SELECTED_RADIO %>" value="2" />


<div class="Clear"></div>
<input type="button" name="OK" value="OK" class="button"
	onClick="if(datevalidation()){submitForm('silDilReport','/hms/hms/mis?method=showSilDilReport');}" />
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" />
<div class="Clear"></div>

</form>
</div>