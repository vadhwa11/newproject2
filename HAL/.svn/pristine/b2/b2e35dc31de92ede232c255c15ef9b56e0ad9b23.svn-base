
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.ShoFamilyWelfareActivities"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script type="text/javascript">
function ismaxlength(obj){
	var mlength=obj.getAttribute? parseInt(obj.getAttribute("maxlength")) : ""

	if (obj.getAttribute && obj.value.length>mlength)
	obj.value=obj.value.substring(0,mlength)
}
</script>
<script type="text/javascript" language="javascript">
<%
Calendar calendar=Calendar.getInstance();
String month=String.valueOf((calendar.get(Calendar.MONTH))+1);
String getDate=String.valueOf(calendar.get(Calendar.DATE));
int year=calendar.get(calendar.YEAR);
if(month.length()<2){
month="0"+month;
}
if(getDate.length()<2){
getDate="0"+getDate;
}

%>
serverdate = '<%=getDate+"/"+month+"/"+year%>'
</script>
 <%
Map<String, Object> utilMap = new HashMap<String, Object>();
utilMap = (Map) HMSUtil.getCurrentDateAndTime();
String currenDate = (String) utilMap.get("currentDate");
String time = (String) utilMap.get("currentTime");
   
String userName="";
if(session.getAttribute("userName")!=null)
userName=(String)session.getAttribute("userName");


String currentDate = (String) utilMap.get("currentDate");

%>

<%
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
	}
	

	List<ShoFamilyWelfareActivities> shoFamilyWelfareActivitiesList = new ArrayList<ShoFamilyWelfareActivities>();	
	if(map.get("shoFamilyWelfareActivitiesList") != null){
		shoFamilyWelfareActivitiesList=(List)map.get("shoFamilyWelfareActivitiesList");
	}
	Box box = HMSUtil.getBox(request);

	

%>
<!--main content placeholder starts here-->
<form name="shoFamilyWelfareActivities" action="" method="post">

<div class="titleBg">
<h2>Family Welfare Activities</h2>
</div>



 <script type="text/javascript">
	   var icdArray=new Array();
	   var unitArray = new Array();

	</script> 
<div class="clear"></div>
<div class="Block">
<label>Current Date</label>

<input type="text" name="welFareDate" id="welFareDate"  readonly="readonly"  value="<%=currentDate%>" class="date" class="auto" size="11" validate="Date,date,yes" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" onclick="javascript:setdate('welFareDate',document.shoFamilyWelfareActivities.welFareDate, event)"	validate="Pick a date"  />

<label>Last Updated Date</label>
<%if(shoFamilyWelfareActivitiesList.size()>0){ %>
<%Date lDate =new Date();
				for (ShoFamilyWelfareActivities shoFamilyWelfareActivities : shoFamilyWelfareActivitiesList) {
									
									 lDate = shoFamilyWelfareActivities.getWelFareDate();
			%>
<%}%>
<input type="text" name="lastDate" id="lastDate" readonly="readonly" class="date" class="auto" value="<%=HMSUtil.changeDateToddMMyyyy(lDate)%>" size="11" validate="Date,date,no" />
<%}else{ %>
<input type="text" name="lastDate" id="lastDate" readonly="readonly"  class="date" class="auto" size="11" validate="Date,date,no" />

<%} %>

<label>Total Population</label>
<input type="text" name="totalPopulation" validate="Total Population,int,no" MAXLENGTH="50"/>

</div>
<h4>Population Covered</h4>

<div class="cmntable">

<table border="0" align="center" cellpadding="0" cellspacing="0"  id="grid">

<tr>
<th></th>
<th>Sterilization</th>
<th>IUDs</th>
<th>CC</th>
<th>Oral Pills</th>
</tr>


<tr>
<th>TARGET</th>
<td><input type="text" name="tSterilzation" id="tSterilzation"  class="auto"  value="" maxlength="50" validate="Target Sterilization,int,no" /></td>
<td><input type="text" name="tIuds" id="tIuds"  class="auto"  value="" maxlength="50" validate="Target IUDs,int,no" /></td>
<td><input type="text" name="tCc" id="tCc"  class="auto"  value="" maxlength="50" validate="Target CC,int,no" /></td>
<td><input type="text" name="tOralPills" id="tOralPills"  class="auto"  value="" maxlength="50" validate="Target Oral Pills,int,no" /></td>
</tr>


<tr>
<th>ACHIEVEMENT</th>
<td><input type="text" name="aSterilzation" id="aSterilzation"  class="auto"  value="" maxlength="50" validate="ACHIEVEMENT Oral Pills,int,no" /></td>
<td><input type="text" name="aIuds" id="aIuds"  class="auto"  value="" maxlength="50" validate="ACHIEVEMENT Oral Pills,int,no" /></td>
<td><input type="text" name="aCc" id="aCc"  class="auto"  value="" maxlength="50" validate="ACHIEVEMENT Oral Pills,int,no" /></td>
<td><input type="text" name="aOralPills" id="aOralPills"  class="auto"  value="" maxlength="50" validate="ACHIEVEMENT Oral Pills,int,no" /></td>
</tr>
	
</table>

</div>

<h4>Details of Family Welfare Activities</h4>
<div class="Block">

<label>Annual Census tghrough door to door visits</label>
<input type="text" name="doorVisits" id="doorVisits"  class="auto"   tabindex="1"  value="" maxlength="50" validate="Annual Census tghrough door to door visits,int,no" />
<label>Remarks</label>
<textarea name="dVRemarks" cols="0" rows="0"  maxlength="100"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>

<label>Health Talks and Discussions</label>
<input type="text" name="healthTalks" id="healthTalks"  class="auto"  tabindex="1" value="" maxlength="50" validate="Health Talks and Discussions,int,no" />
<label>Remarks</label>
<textarea name="hTRemarks" cols="0" rows="0"  maxlength="100"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>

<label>Natinal Plus Polio Immunization</label>
<input type="text" name="nationalPulse" id="nationalPulse"  class="auto"  tabindex="1" value="" maxlength="50" validate="Natinal Plus Polio Immunization,int,no" />
<label>Remarks</label>
<textarea name="nPRemarks" cols="0" rows="0"  maxlength="100"	value=""  tabindex="1" onkeyup="return ismaxlength(this)"></textarea>

<div class="clear"></div>
</div>


<input type="button" name="Button" value="Submit" class="button" onclick="submitForm('shoFamilyWelfareActivities','/hms/hms/mis?method=submitFamilyWelfareActivities')"/>
<input type="reset" name="Reset" value="Reset" class="button" tabindex="1" onClick="submitFormForButton('shoFamilyWelfareActivities','/hms/hms/mis?method=showFamilyWelfareActivities');" accesskey="r" />


<div class="clear PaddingTop15"></div>

<div class="division"></div>

<div class="clear PaddingTop15"></div>

<div class="bottom">
<label>Changed By</label> 
<label class="value"><%=userName%></label>
<label>Changed Date</label> 
<label class="value"><%=currentDate%></label>
<label>Changed Time</label> 
<label class="value"><%=time%></label> 
<input	type="hidden" name="<%=CHANGED_BY%>" value="<%=userName%>" /> 
<input	type="hidden" name="<%=CHANGED_DATE %>" value="<%=currentDate%>" /> 
<input	type="hidden" name="<%=CHANGED_TIME %>" value="<%=time%>" />
</div>


<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
