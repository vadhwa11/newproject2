<%-- 
	 * Copyright 2008 JK Technosoft Ltd. All rights reserved.
	 * Use is subject to license terms.
	 * File Name           : wardRemarks.jsp 
	 * Tables Used         : 
	 * Description         : 
	 * @author  Create Date: 08.08.2008    Name: Vivek
	 * Revision Date:      Revision By: 
	 * @version 1.0  
	 
--%>


<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.Patient"%>
<%@page import="jkt.hms.masters.business.MasServiceType"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<div id="contentHolder"><script>
<%
	List<MasUnit> unitList = new ArrayList<MasUnit>();
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
	
	function getViewDetals() {
	remarksDate = document.getElementById("remarksDate").value
  var xmlHttp;
  try {
    // Firefox, Opera 8.0+, Safari
    xmlHttp=new XMLHttpRequest();
  }catch (e){
    // Internet Explorer
    try{
      xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
    }catch (e){
      try{
        xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
      }catch (e){
        alert("Your browser does not support AJAX!");
        return false;
      }
     }
   }
    xmlHttp.onreadystatechange=function()
    {
      if(xmlHttp.readyState==4){
         document.getElementById("viewDetails").innerHTML = xmlHttp.responseText;
      }
    }
    var url="/hms/hms/ipd?method=getWardRemarksDetails&remarksDate="+remarksDate
     
    xmlHttp.open("GET",url,true);
    
    xmlHttp.send(null);
  }
	
</script>

<form name="wardRemarks" action="" method="post">
<%
		Map<String, Object> map = new HashMap<String, Object>();
		String message ="";
		Map<String,Object> utilMap = new HashMap<String,Object>();
		utilMap = (Map)HMSUtil.getCurrentDateAndTime();
		String currentDate = (String)utilMap.get("currentDate");
		String currentTime = (String)utilMap.get("currentTime");
		if (request.getAttribute("map") != null) {
			map = (Map) request.getAttribute("map");
		}
		if(map.get("message") !=null){
			message =""+map.get("message");
		}
		
	%> <%if(!message.equals("")){ %> <label class="noWidth"><span><%=message %></span></label>
<% }%>
<div class="Clear"></div>
<div class="blockTitle">Daily Remarks</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Date: </label> <input
	type="text" name="<%=DATE%>" value="<%=currentDate %>" class="calDate"
	Adm validate="Adm. Date,dateOfAdmission,yes" MAXLENGTH="30" /> <img
	id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
	border="0" validate="Pick a date" class="calender"
	onClick="setdate('',document.wardRemarks.<%=DATE%>,event)" /> <label><span>*</span>
Time: </label> <input type="text" name="<%=TIME %>" value="<%=currentTime %>"
	readonly="readonly" class="calDate" style="width: 120px;"
	validate="Adm. Time,String,yes" id="admTime"
	onblur="checkTime('admissionByHin','<%=TIME_OF_ADMISSION%>');" />
<div class="Clear"></div>
<label><span>*</span> Remarks: </label> <textarea name="<%=REMARKS %>"
	rows="5" cols="100" validate="Remarks,string,Yes" id="nokAddr"
	class="large" onpaste="return checkOnPaste(this)"
	oninput="return checkMaxLengthMoz(this)" maxlength="475" tabindex="1" /></textarea>
</td>
<div class="Clear"></div>
</div>
<div class="Clear"></div>
<input type="button"
	onclick="submitForm('wardRemarks','/hms/hms/ipd?method=saveWardRemarks');"
	value="Submit" class="button" /> <input type="button" name="Back"
	class="button" value="Back"
	onclick="submitForm('wardRemarks','/hms/hms/ipd?method=showPatientListJsp');" />
<div class="Clear"></div>
<div class="blockTitle">View</div>
<div class="blockTitleCurve"></div>
<div class="Clear"></div>
<div class="blockFrame"><label><span>*</span> Date: </label> <input
	type="text" name="<%=DATE_OF_REMARKS%>" value="<%=currentDate %>"
	class="calDate" readonly="readonly"
	validate="Adm. Date,dateOfAdmission,yes" MAXLENGTH="30"
	id="remarksDate" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('',document.wardRemarks.<%=DATE_OF_REMARKS%>,event)" />
<input type="button" name="Back" class="button" value="View"
	onclick="getViewDetals();" />
<div class="Clear"></div>
<div
	style="overflow: auto; width: 99%; height: 180px; padding: 0px 4px 0px 4px; border: 1px solid #7E7E7E;"
	id="viewDetails"></div>
</div>
</form>
<div class="Clear"></div>
</div>

