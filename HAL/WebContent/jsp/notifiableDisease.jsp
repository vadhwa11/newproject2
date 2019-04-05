<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>
<%@page import="jkt.hms.masters.business.MasRank"%>
<%@page import="jkt.hms.masters.business.MasTrade"%>
<%@page import="jkt.hms.masters.business.MasUnit"%>
<%@page import="jkt.hms.masters.business.MasEmployee"%>
<%@page import="jkt.hms.masters.business.ExpiryDetails"%>

<%@page import="jkt.hms.masters.business.DischargeIcdCode"%>
<%@page import="jkt.hms.masters.business.Inpatient"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
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
<div id="contentspace"><script type="text/javascript"
	language="javascript">
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


<div class="titleBg"><h2>Notifiable Disease Entry</h2>
</div>
<div class="clear"></div>

<%
			 	String userName = "";
			 	if (session.getAttribute("userName") != null) {
			 		userName = (String) session.getAttribute("userName");
			 	}
			 	Map<String, Object> utilMap = new HashMap<String, Object>();
			 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
			 			
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");
			 	String hinNo=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
					 	
			 	List<Object> list = null;
			 	List<MasIcd> diagnosisList = null;
			 	Date dateOfDeath=null;
			 	
			 		
			 	
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if (map.get("diagnosisList") != null) {
			 		diagnosisList = (List<MasIcd>) map.get("diagnosisList");
			 		session.setAttribute("diagnosisList", diagnosisList);
			 			
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%>
<div style="width: 100%; padding-top: 4px; padding-bottom: 4px;">
<div class="mesg" style="width: 100%; height: 23px;"><%=message %>
</div>
</div>

<%    
					   
					  }
			 		 	
			 %>


<form name="notifiableDisease" method="post" action="">
<div class="Block">
<%if(session.getAttribute("hinNo")!=null)
		 {
		 		hinNo=(String)session.getAttribute("hinNo");
		 }
		 else
		 {	 hinNo="";
		 }%> <label class="bodytextB">Notifiable Date:</label> <input
	type="text" id="inputDate" name="<%=NOTIFIABLE_DATE%>"
	value="<%=currentDate %>" class="textbox_date" readonly="readonly"
	MAXLENGTH="30" /> <img id="calendar" src="/hms/jsp/images/cal.gif"
	width="16" height="16" border="0" validate="Pick a date"
	class="calender"
	onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=NOTIFIABLE_DATE%>,event)" />
	
<label class="bodytextB">Service No.</label> <input type="text"
	id="serviceNo." name="<%=SERVICE_NO%>" value="" class="textbox_date"
	MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('notifiableDisease','mis?method=getHinAdNoForND&flag=hin','hinDiv')" />
<div id="hinDiv">
<label class="bodytextB"> Hin:</label> <input
	type="text" name="<%=HIN_NO%>" value="" class="textbox_date"
	MAXLENGTH="30" /></div>
<div id="testDiv"><label class="bodytextB"><font
	id="error">*</font>Ad No:</label> <input type="text" id="frwSlno"
	name="<%=AD_NO%>" value="" validate="AD No.,,yes" class="textbox_date"
	MAXLENGTH="30" /></div>

<div class="clear"></div>

<!--
<div style="width: 15px; height: 20px; float: left;"></div>

<div
	style="background-color: #ffffff; BORDER-top: #9A9A9A 1px solid; BORDER-LEFT: #9A9A9A 1px solid; width: 187px; height: 20px; float: left;">
 
<font class="boxtitle">Notifiable Disease Details</font></div>
<div style="width: 15px; float: left;"><img
	src="/hms/jsp/images/tab_edge_ltgr.gif" /></div>
<br />
 -->
 <div class="clear"></div>
 <div class="Block">
<div class="titleBg"><h2>Notifiable Disease Details</h2></div>
<div class="clear"></div>
<table width="100%" border="0" cellpadding="2" cellspacing="2"
	class="grid_header" style="margin-left: 15px; left: 25px;">

	<thead>
		<tr class="gridheaderlabel">

			<td width="53">Sr. No.</td>
			<td width="240"><strong>Details of Notifiable Disease</strong></td>
			<td width="645"></td>



		</tr>

	</thead>


	<tbody>
		
		<tr>
			<td height="22">1)</td>
			<td>Designation of Quarters</td>
			<td><input type="text" name="<%=DESIGNATION%>" value=""
				class="textboxB" validate="No. of days , number,no" MAXLENGTH="30" /></td>
		</tr>

		<tr>
			<td height="22">2)</td>
			<td>Date of Onset</td>
			<td><input type="text" id="dateOfExpiryId"
				name="<%=DATE_OF_ONSET%>" value="<%=currentDate %>"
				class="textbox_date" readonly="readonly" MAXLENGTH="30" /> <img
				id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"
				border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=DATE_OF_ONSET%>,event)" />
			</td>
		</tr>
		<tr>
			<td height="22">3)</td>
			<td>Date of Reporting Sick</td>
			<td><input type="text" name="<%=DATE_OF_REPORTING_SICK %>"
				value="<%=currentDate %>" class="textboxB" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=DATE_OF_REPORTING_SICK%>,event)" />
		</tr>
		<tr>
			<td height="22">4)</td>
			<td>Basis of Diagnosis</td>
			<td><select id="diagnosisId" name="<%=BASIS_OF_DIAGNOSIS %>"
				validate="Basis of Diagnosis,,yes">
				<option value="0">Select</option>
				<%
				if(diagnosisList!= null){
				for (MasIcd masIcd : diagnosisList) {
			%>
				<option value="<%=masIcd.getId()%>"><%=masIcd.getIcdName()%></option>
				<%}
				}
			%>
			</select></td>
		</tr>
		<tr>
			<td height="22">5)</td>
			<td>Clinical</td>
			<td><input type="text" name="<%=CLINICAL%>"
				value="" class="textboxB" validate="Clinical , string,no"
				MAXLENGTH="30" /></td>
		</tr>
		<tr>
			<td height="22">6)</td>
			<td>Bacteriological</td>
			<td><input type="text" name="<%=BACTERIOLOGICAL%>"
				value="" class="textboxB" validate="Bacteriological , string,no"
				MAXLENGTH="50" /></td>
		</tr>
		<tr>
			<td height="22">7)</td>
			<td>Suspected source of infection (including movement)</td>
			<td><input type="text" name="<%=SUSPECTED_SOURCE_OF_INFECTION%>"
				value="" class="textboxB" validate="Suspected source of infection (including movement) , string,no"
				MAXLENGTH="30" /></td>
		</tr>
		<tr>
			<td height="22">8)</td>
			<td>Measures of Control</td>
			<td><input type="text" name="<%=MEASURES_OF_CONTROL%>" value=""
				class="textboxB" validate="Measures of Control , string,no" MAXLENGTH="30" /></td>
		</tr>
		<tr>
			<td height="22">9)</td>
			<td>Disinfection</td>
			<td><input type="text" name="<%=DISINFECTION%>" value=""
				class="textboxB" validate="Disinfection , string,no" MAXLENGTH="50" /></td>
		</tr>
		<tr>
			<td height="22">10)</td>
			<td>Contact</td>
			<td><input type="text" name="<%=CONTACT%>" value=""
				class="textboxB" validate="No. of days , number,no" MAXLENGTH="30" /></td>
		</tr>
		<tr>
			<td height="22">11)</td>
			<td>Date of preventive inoculation of vaccination</td>
			<td><input type="text" name="<%=DATE_OF_PREVENTIVE %>"
				value="<%=currentDate %>" class="textboxB" tabindex=3
				readonly="readonly" /> <img id="calendar"
				src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"
				validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.notifiableDisease.<%=DATE_OF_PREVENTIVE%>,event)" />
			</td>

		</tr>
		<tr>
			<td height="22">12)</td>
			<td>General Remarks</td>
			<td><input type="text" name="<%=GENERAL_REMARKS%>" value="" 
			    
				class="textboxB" validate="No. of days , number,no" MAXLENGTH="30" /></td>
		</tr>
		<tr>
			<td height="22">13)</td>
			<td>Station</td>
			<td><input type="text" name="<%=STATION%>" value=""
				class="textboxB" validate="No. of days , number,no" MAXLENGTH="30" /></td>
		</tr>

	</tbody>
</table>


<input type="hidden" name="<%=EXPIRY_ID%>" value="" class="textbox_date"
	MAXLENGTH="10" /> <br />

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textboxB" readonly="readonly" MAXLENGTH="30" / tabindex=3 /> <input
	type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textboxB" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textboxB" readonly="readonly" tabindex=3 />
</div>
<div style="padding-left: 15px;"><input type="button" name="edit"
	value="Submit" class="button"
	onClick="submitForm('notifiableDisease','mis?method=editNotifiableDisease','checkDateNotGreaterThanCurrentDate');" />
<!-- 
<input type="image" name="print"
	value="Print" class="button"
	onClick="submitForm('notifiableDisease','sHO?method=printNotifiableDisease');" />
-->
<a class="button"  href="sHO?method=printNotifiableDisease">Print</a>


</div>

<div id="edited"></div>
<label>&nbsp;</label>
<!-- </div> -->


</div>
</form>
</div>





