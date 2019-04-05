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
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"language="javascript">
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

<div class="titleBg">
<h2>Fatal Documents Tracking</h2>
</div>

<div class="Clear"></div>
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
			 	//String dateOfDeath=null;

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<Object> list = null;
			 	Date dateOfDeath=null;
			 	if (map.get("showList") != null) {
			 		list = (List<Object>) map.get("showList");
			 		session.setAttribute("list", list);
			 	}
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> <label class="noWidth"> <span> <%=message %> </span> </label>
<div class="Clear"></div>
<%    }%>

<form name="fatalCase" method="post" action="">
<%if(session.getAttribute("hinNo")!=null)
				 {
				 		hinNo=(String)session.getAttribute("hinNo");
				 }
				 else
				 {	 hinNo="";
				 }%>

<div class="Block">

<label>Service No.</label> <input
	type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""
	MAXLENGTH="30" onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=showFatalCase','show');"/>
	<%---
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=getHinAdNoDetailsFatalCase&flag=hin','hinDiv')" />
<div id="hinDiv"><label> HIN</label> <input type="text"	name="<%=HIN_NO%>" value="" MAXLENGTH="30" />
	onchange="submitProtoAjaxWithDivName('fatalCase','mis?method=getAdmissionNoList&flag=admission&fatalCase=yes','testDiv')" /> 
</div>

<div id="testDiv"><label>A&D No.<span>*</span></label> <input
	type="text" id="frwSlno" name="<%=AD_NO%>" value=""
	validate="AD No.,,yes" MAXLENGTH="30"
	onblur="submitProtoAjaxWithDivName('fatalCase','mis?method=showFatalCase','show');" />
</div> --%>
</div>
<div class="Clear"></div>
<div id="show">
<h4>Dispatch Details</h4>

<div class="Clear"></div>

<table class="cmntable">
	<thead>
		<tr>
			<th width="28">Sl No.</th>
			<th width="272">Details of Dispatch</th>
			<th colspan="2">Date</th>
			<th width="335">Remarks</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td height="22">1.</td>
			<td>Date of Death</td>
			<td width="171">
			<%if(session.getAttribute("dateOfDeath")!=null){ %> <input type="text"
				id="dateOfExpiryId" size="8" name="<%=DATE_OF_DEATH%>"
				value="<%=session.getAttribute("dateOfDeath")%>" readonly="readonly"
				MAXLENGTH="30" /> <%}
			else{%> <input type="text" id="dateOfExpiryId"
				size="8" name="<%=DATE_OF_DEATH%>" value="" readonly="readonly"
				MAXLENGTH="30" /> <%} %>
			</td>
			<td width="335">&nbsp;</td>
			<td><input name="<%=DEATH_REMARK %>" type="text" size="55" maxlength="200"></td>
		</tr>
		<tr>
			<td height="22">2.</td>
			<td>Postmortem</td>
			<td><select id="postmortem" class="auto" name="<%=POSTMORTEM %>">
				<option value="y">Held</option>
				<option value="n">Not Held</option>
			</select></td>
			<td>&nbsp;</td>
			<td><input name="<%=POSTMORTEM_REMARK %>" type="text" size="55" maxlength="200"></td>
		</tr>
		<tr>
			<td height="22">3.</td>
			<td>Date of Postmortem Received</td>
			<td><input type="text" name="<%=DATE_OF_POSTMORTEM %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_POSTMORTEM%>,event)" /></td>
			<td><input name="<%=POSTMORTEM_DATE_REMARK %>" type="text" maxlength="200"
				size="55"></td>
		</tr>
		<tr>
			<td height="22">4.</td>
			<td>Documents H/O spl concerned Date</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED%>,event)" />
			</td>
			<td><input name="<%=CONCERNED_DATE_REMARK %>" type="text" maxlength="200"
				size="55"></td>
		</tr>
		<tr>
			<td height="22">5.</td>
			<td>Received from spl with opinion and Date</td>
			<td><input type="text" name="<%=DATE_OF_OPINION %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_OPINION%>,event)" />
			</td>
			<td><input name="<%=OPINION_DATE_REMARK %>" type="text" maxlength="200"
				size="55"></td>
		</tr>
		<tr>
			<td height="22">6.</td>
			<td>Completion of documents by Ward and Date</td>
			<td><input type="text" name="<%=DATE_OF_WARD_MASTER %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_WARD_MASTER%>,event)" />
			</td>
			<td><input name="<%=WARD_MASTER_DATE_REMARK %>" type="text" maxlength="200"
				size="55"></td>
		</tr>
		<tr>
			<td height="22">7.</td>
			<td>Signature of MO i/c Ward</td>
			<td><input type="text" name="<%=DATE_OF_MO_WARD %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_MO_WARD%>,event)" />
			</td>
			<td><input name="<%=WARD_REMARK %>" type="text" size="55" maxlength="200"></td>
		</tr>
		<tr>
			<td height="22">8.</td>
			<td>HOD persual on (Date)</td>
			<td><input type="text" name="<%=DATE_OF_HOD %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_HOD%>,event)" />
			</td>
			<td><input name="<%=HOD_DATE_REMARK %>" size="55" maxlength="200"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1" />
			</td>
		</tr>
		<tr>
			<td height="22">9.</td>
			<td>Date of submission of Stats by Ward</td>
			<td><input type="text" name="<%=DATE_OF_STATS %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_STATS%>,event)" /></td>
			<td><input name="<%=STATS_DATE_REMARK %>" type="text" size="55" maxlength="200"></td>
		</tr>
		<tr>
			<td height="22">10.</td>
			<td>Date of submission for remarks of SMO</td>
			<td><input type="text" name="<%=DATE_OF_COMMANDANT %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_COMMANDANT%>,event)" /></td>
			<td><input name="<%=COMMANDANT_DATE_REMARK %>"
				validate="Kin Address,string,Yes" id="nokAddr" size="55"
				onpaste="return checkOnPaste(this)"
				oninput="return checkMaxLengthMoz(this)"
				onKeyDown="return checkMaxLength(this)" onKeyUp="finalCheck(this)"
				maxlength="50" tabindex="1"maxlength="200" /></td>
			</td>
		</tr>
		<tr>
			<td height="22">11.</td>
			<td>Date of Dispatch to Senior Advisor Pathology for Persual</td>
			<td><input type="text" name="<%=DATE_OF_PATHOLOGY %>" value=""
				size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_PATHOLOGY%>,event)" /></td>
			<td><input name="<%=PATHOLOGY_DATE_REMARK %>" type="text" maxlength="200"
				size="55"></td>
		</tr>
		<tr>
			<td height="22">12.</td>
			<td>Date of Dispatch to Senior Advisor for Persual</td>
			<td><input type="text" name="<%=DATE_OF_SENIOR_ADVISOR_1 %>"
				value="" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_SENIOR_ADVISOR_1%>,event)" /></td>
			<td><input name="<%=SA1_DATE_REMARK %>" type="text" size="55" maxlength="200"></td>
		</tr>
		<tr>
			<td height="22">13.</td>
			<td>Date of Dispatch to Concerned Command for Persual</td>
			<td><input type="text" name="<%=DATE_OF_CONCERNED_COMMAND %>"
				value="" size="8" tabindex=3 readonly="readonly" /></td>
			<td><img  src="/hms/jsp/images/cal.gif" width="16"
				height="16" border="0" validate="Pick a date" class="calender"
				onClick="setdate('<%=currentDate %>',document.fatalCase.<%=DATE_OF_CONCERNED_COMMAND%>,event)" /></td>
			<td><input name="<%=CONCERNED_COMMAND_DATE_REMARK %>"
				type="text" size="55"></td>
		</tr>
	</tbody>
</table>
<input type="hidden" name="<%=EXPIRY_ID%>" value="" MAXLENGTH="10" />
<div class="Clear"></div>

<input type="hidden" name="<%= CHANGED_BY%>" value="<%=userName%>"
	class="textbox_size20" readonly="readonly" MAXLENGTH="8" / tabindex=3 />
<input type="hidden" name="<%= CHANGED_DATE %>" value="<%=currentDate%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>"
	class="textbox_size20" readonly="readonly" tabindex=3 /> <input
	type="button" name="edit" value="Submit" class="button"
	onClick="submitForm('fatalCase','mis?method=editFatalCase');" /></div>
<div id="edited"></div>
</div>


</form>
<div class="Clear"></div>
</div>
