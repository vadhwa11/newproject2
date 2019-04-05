<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="jkt.hms.masters.business.MasEmployee"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.util.HMSUtil"%>
<%@ page import="jkt.hms.util.Box"%>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
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
			 	
			 	String currentDate = (String) utilMap.get("currentDate");
			 	String time = (String) utilMap.get("currentTime");

			 	Map<String, Object> map = new HashMap<String, Object>();
			 	if (request.getAttribute("map") != null) {
			 		map = (Map<String, Object>) request.getAttribute("map");
			 	}
			 	List<MasEmployee> doctorList = null;

				if(map.get("doctorList") != null){
					doctorList=(List)map.get("doctorList");
					}
	 	
			 				 
			 	if(map.get("message") != null){
					String message = (String)map.get("message");
					%> 
					<div class="Clear"></div>	
					<label class="noWidth"> <span> <%=message %> </span> </label>
					<div class="Clear"></div>	
					 <% } %>
<%
String screenName="Feedback on Performance of Counselor";
%>
<div class="titleBg">
<h2><%=screenName%></h2>
</div>

<form name="feedbackCounselor" method="post">

<div class="Block">
<label class="large"> Name of Counselor</label> 
<input type="text" id="name" name="<%=NAME%>"  title="Name of counselor" value="" maxlength="49" tabindex="1" onchange="" />

<div class="Clear"></div>

<label class="large"> Qualification</label>
<input type="text" name="qualification" id="qualification" tabindex="1" />

<!--<select name="" >
	<option >Select</option>
	<option value="MBBS" > MBBS</option>
	<option value="MD(Psychiatry)">MD(Psychiatry)</option>
</select>

--><div class="Clear"></div>

<label class="large">Date of Employed and Honoranum per Month</label>
<input	tabindex="1" name="honorariumPerMonth" id="date" class="date" value="<%=currentDate %>" readonly="readonly"	 maxlength="50"	 />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onClick="setdate('',document.feedbackCounselor.honorariumPerMonth,event)" validate="Pick a date" class="calender" />

<div class="Clear"></div>

<label class="large"> No. of Visits (per week)</label>
<input type="text" name="<%=VISIT_NUMBER%>" id="visitNumber" value="" 	maxlength="15"  tabindex="1" validate="Number of Visit,int,no" /> 

<div class="Clear"></div>

<label class="large"> Place of Counseling </label>
<input type="text"	name="<%=ADDRESS %>" id="address" value="" maxlength="49"     validate=" Place of conducting the counseling sessions,string,no" tabindex="1"/>

<div class="Clear"></div>

<label class="large">Average No. of persons counseled per week</label>
<input type="text" name="avgNoPersonCounseled" maxlength="50" validate="Average No. of persons,int,no" />

<div class="Clear"></div>
</div>

<h4>Percentage Wise Breakdown of Cases</h4>
<table class="cmntable">

<tr>
<th>Sl No.</th>
<th>Type of Cases</th>
<th>Percentage</th>
</tr>

<tr>
<th>(a)</th>
<td>Alcohol Dependence</td>
<td><input type="text" name="alcoholDependence" maxlength="50" validate="Alcohol Dependence,int,no" /></td>
</tr>

<tr>
<th>(b)</th>
<td>Domestic Problems</td>
<td><input type="text" name="domesticProblems" maxlength="50" validate="Domestic Problems,int,no" /></td>
</tr>

<tr>
<th>(c)</th>
<td>Educational Issue of Children</td>
<td><input type="text" name="educationalIssue" maxlength="50" validate="Educational Issue of Children,int,no" /></td>
</tr>

<tr>
<th>(d)</th>
<td>Financial Issue</td>
<td><input type="text" name="financialIssue" maxlength="50" validate="Financial Issue,int,no" /></td>
</tr>

<tr>
<th>(e)</th>
<td>Inter - Personal Problems</td>
<td><input type="text" name="interPersonalProblem" maxlength="50" validate="Inter Personal Problems,int,no" /></td>
</tr>

<tr>
<th>(f)</th>
<td>Service Related Issue</td>
<td><input type="text" name="serviceRelatedIssue" maxlength="50" validate="Service Related Issue,int,no" /></td>
</tr>

<tr>
<th>(g)</th>
<td>Others (Specify)</td>
<td><input type="text" name="othersSpecify" maxlength="50" validate="Others,int,no" /></td>
</tr>

</table>


<!--<label> Types of Cases </label> 
<select name="toc" id="toc" multiple="multiple" class="list" tabindex="1">
	<option value="Financial including outstanding loan">Financial including outstanding loan</option>
	<option value="Alcohol profile">Alcohol profile</option>
	<option value="Marital problem">Marital problem</option>
	<option value="Sexual problem">Sexual problem</option>
	<option value="Past history of psychiatric illness">Past history of psychiatric illness</option>
	<option value="Any other">Any other</option>
	</select>
-->
<div class="Block">

<label class="large">Records of cases counseled put up for perusal of SMC</label> 	
<input type="text" name="casesCounseled" maxlength="50" />	
	
<div class="Clear"></div>

<label class="large">Whether any counseling was done after working hour for any person</label>
<select name="counselingAfterWorkingHour" id="counseling" onchange="showCounseling();" tabindex="1">
<option value="" >Select</option>
<option value="Yes">Yes</option>
<option value="No">No</option>
</select>

<div class="clear"></div>

<div id="counselingDiv" style="display:none" >

<label class="large">No. of cases per month</label>
<input type="text" name="noOfCasesPerMonth" maxlength="50" validate="Number of cases per month,int,no" />

<div class="Clear"></div>

<label class="large">Phone No. utilized for contact by clientele after working hour</label>
<input type="text" name="phNoAfterWorkingHour" maxlength="50" validate="Phone No,int,no" maxlength="15" />
</div>

<div class="Clear"></div>

<label class="large">Remarks</label> 
<textarea name="remarks" id="remarks"   maxlength="199"  rows="" cols=""  onkeyup="chkLength(this,199);" onpaste="return checkOnPaste(this)"	
oninput="return checkMaxLengthMoz(this)"	onKeyDown="return checkMaxLength(this)"></textarea>
<div class="Clear"></div>

<label>Date of Counseling<span>*</span></label> 
<input type="text" name="employedDate" id="date" class="date" value="" readonly="readonly" maxlength="10" tabindex="1" validate="Date of Counseling,date,yes"  />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date" class="calender"  
onClick="setdate('',document.feedbackCounselor.employedDate,event)" />


<label>Forwarded To<span>*</span></label> 
	<select name="forwardedTo" id="forwardedTo" tabindex="1" validate="Forwarded To,string,yes">
	<option value="0">Select</option>
	<%for(MasEmployee masEmployee:doctorList) {%>
	<option value="<%=masEmployee.getId() %>"><%=masEmployee.getRank().getRankName().concat(" ").concat(masEmployee.getFirstName().concat(" ").concat(masEmployee.getLastName()))%></option>
	<%} %>
	</select>




<!--<label>Signature</label>
<input type="text" name="signature" id="signature" maxlength="50" />

--><div id="edited"></div>
</div>

</form>


<div class="Clear"></div>
	<div class="division"></div>
		<input type="button" name="Submit" value="Forward" class="button" 
	onClick="submitForm('feedbackCounselor','mis?method=submitFeedbackCounselorJsp');" tabindex="1"/>
	
	<!--<input type="button" name="Reset" onclick="submitForm('feedbackCounselor','sHO?method=showFeedbackCounselor');" value="Reset" class="button" tabindex="21"/>
	--><!--<input type="button" name="edit" value="Print" class="button" />
	-->
	<!--<input type="button" name="Back" value="Back" onClick="history.back();" class="button" />
	
-->
<div class="Clear"></div>
<div class="division"></div>

<script>
function chkLength(field,maxLimit)
{
if(field.value.length > maxLimit)
{
 alert('Maximum Limit is '+maxLimit+' characters.');
 var val=field.value.substring(0,maxLimit);
 field.value=val;
}
}

function showCounseling(){
	if(document.getElementById('counseling').value == 'Yes'){
	  	document.getElementById('counselingDiv').style.display='inline';
	}else{
		document.getElementById('counselingDiv').style.display='none';
	}
}

function signatureOfCounselor(val){
	
	var signature="";

	if(document.getElementById('name').value != null && document.getElementById('name').value != 0)
	{
		signature = (document.getElementById('name').value);
	}
	document.getElementById('signature').value = signature;
}
	
 </script>


