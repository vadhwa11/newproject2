<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>

<%@page import="jkt.hms.util.HMSUtil"%>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/common.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/hms.js"></script>
<script type="text/javascript" language="javascript"
src="/hms/jsp/js/proto.js"></script>

<div id="contentHolder">
<script type="text/javascript"
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
</script> <%
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
Map<String, Object> map = new HashMap<String, Object>();
if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");
}
List officerAircrewList= new ArrayList();
List officerGDList= new ArrayList();
List airmenAircrewList= new ArrayList();
List airmenOthersList= new ArrayList();
List ncsList= new ArrayList();
List allFamiliesList= new ArrayList();
List servicePersList= new ArrayList();
List medicalExamList = new ArrayList();
List medicalBoardList = new ArrayList();
List<Object[]> unitList = new ArrayList();

if(map.get("officerAircrewList")!= null )
{
	officerAircrewList= (List)map.get("officerAircrewList"); 
	
	
	}
if(map.get("officerGDList")!= null )
{
	officerGDList = (List)map.get("officerGDList"); 
	
	}
if(map.get("airmenAircrewList")!= null )
{
	airmenAircrewList= (List)map.get("airmenAircrewList"); 
	
	}
if(map.get("airmenOthersList")!= null )
{
	airmenOthersList = (List)map.get("airmenOthersList"); 
	
	}
if(map.get("ncsList")!= null )
{
	ncsList= (List)map.get("ncsList"); 
	
	}
if(map.get("allFamiliesList")!= null )
{
	allFamiliesList= (List)map.get("allFamiliesList"); 
	
	}
if(map.get("servicePersList")!= null )
{
	servicePersList = (List)map.get("servicePersList"); 
	
	}
if(map.get("unitList")!= null)
{
	unitList= (List<Object[]>)map.get("unitList");
	}
if(map.get("medicalBoardList") != null)
{
	medicalBoardList =(List<Object[]>)map.get("medicalBoardList");
	}
if(map.get("medicalExamList") != null)
{
	medicalExamList =(List<Object[]>)map.get("medicalExamList");
	}

%>

<form name="monthlyWorkload" method="post" action="">


<h6>Workload Of Monthly </h6>
<div class="Clear"></div>
<div class="cmntable">
<table class="cmntable" name="workloadGrid" id="workloadGrid" width="100%" cellspacing="0" cellpadding="0">

<tr>
<th>Month<span>*</span></th>
<th>Unit<span>*</span></th>
<th>Total Population</th>
<th>OffrsAirCrew</th>
<th>OffrsGD</th>
<th>Airmen AirCrew</th>
<th>AirmenOthers</th>
<th>NCs(E)</th>
<th>DSC</th>
<th>All Families</th>
<th>Total Sick</th>
<th>Rate/1000 Population</th>
<th>ServicePers</th>
<th>All Families</th>
<th>Total</th>
<th>Rate/1000 Population</th>
<th>All</th>
<th>Rate/1000 Population</th>
<th>MedBoards</th>
<th>Med Exam</th>
</tr>


<tr>

<td>
<select name="month" class="smallest" tabindex="1" validate="Month,String,yes">
<option value="">Select</option>
<option value="January">January</option>
<option value="February">February</option>
<option value="March">March</option>
<option value="April">April</option>
<option value="May">May</option>
<option value="June">June</option>
<option value="July">July</option>
<option value="August">August</option>
<option value="September">September</option>
<option value="October">October</option>
<option value="November">November</option>
<option value="December">December</option>
</select>
</td>

<td>

<select id="unitId" name="unitId" tabindex="1" validate="Unit,String,yes">
<option value="0">select</option>
<% for(Object[] masUnit : unitList){ %>
<option value="<%=masUnit[0]%>"><%=masUnit[1]%></option>
<%} %>
</select>

</td>

<td><input type="text" validate="Total Population,int,no"  name="totalPopulation" id="totalPopulation" size="12" value="" tabindex="1"  /></td>

<% if (officerAircrewList.get(0)!= null){%>
<td><input type="text" validate="Offrs AirCrew,int,no" name="OffAirCrew" id="OffAirCrew" readonly="readonly" class="auto" tabindex="1"  size="9" value="<%=officerAircrewList.get(0)%>" onblur="totalSickPopulation(this.value);" /></td>
<% }%>

<%if(officerGDList.get(0)!= null){%>
<td><input type="text" validate="Offrs GD,int,no" name="OffGD" id="OffGD" tabindex="1" readonly="readonly" class="auto" size="3" value="<%=officerGDList.get(0)%>" onblur="totalSickPopulation(this.value);" /></td>
<%}%>

<%if(airmenAircrewList.get(0)!= null){ %>
<td><input type="text" validate="Airmen AirCrew,int,no" name="airmenAirCrew" tabindex="1"  id="airmenAirCrew" readonly="readonly" class="auto" size="12" value="<%=airmenAircrewList.get(0)%>"  onblur="totalSickPopulation(this.value);" /></td>
<%}%>

<%if(airmenOthersList.get(0)!= null){ %>
<td><input type="text"  validate="Airmen Others,int,no"  name="airmenOthers" id="airmenOthers"  readonly="readonly"  tabindex="1"  class="auto" size="10" value="<%=airmenOthersList.get(0) %>" onblur="totalSickPopulation(this.value);" /></td>
<%} %>

<%if(ncsList.get(0)!= null) {%>
<td><input type="text" name="ncs" id="ncs"  validate="NCS,int,no" tabindex="1" readonly="readonly"  class="auto" size="5" value="<%=ncsList.get(0)%>" onblur="totalSickPopulation(this.value);" /></td>
<%}%>

<td><input type="text" name="dsc" id="dsc"  validate="DSC,int,no" tabindex="1"  class="auto" size="5" value="" onblur="totalSickPopulation(this.value);" /></td>

<%if(allFamiliesList.get(0)!= null){ %>
<td><input type="text" name="allFamilies" validate="All Families,int,no"  tabindex="1"  id="allFamilies"  readonly="readonly"  class="auto" size="7" value="<%=allFamiliesList.get(0) %>"  onblur="totalSickPopulation(this.value);" /></td>
<%}%>

<td><input type="text" name="totalSick"  validate="Total Sick,int,no" id="totalSick" tabindex="1"  class="auto" size="14" value="" onblur="populationSickRate(this.value);" /></td>

<td><input type="text" name="populationSick" tabindex="1"  validate="Rate per 1000 Population Sick,float,no" id="populationSick" class="auto" size="18" value=""  /></td>

<%if(servicePersList.get(0)!= null){ %>
<td><input type="text" name="servicePerson" tabindex="1"  validate="Service Person,int,no" id="servicePerson"  readonly="readonly"  class="auto" size="8" value="<%=servicePersList.get(0)%>" onblur="totalServicePersonPopulation(this.value);" /></td>
<%}%>

<td><input type="text" name="families" id="families"  validate="All Families,int,no"  tabindex="1"  class="auto" size="6" value="" onblur="totalServicePersonPopulation(this.value);" /></td>

<td><input type="text" name="total" id="total"  validate="Total,int,no" tabindex="1"  class="auto" size="5" value="" onblur="populationServicePersonRate(this.value);" /></td>

<td><input type="text" name="populationServicePerson"  validate="Rate per 1000 Population Service Person,float,no"  tabindex="1"  id="populationServicePerson" class="auto" size="18" value="" onblur="totalAllPopulation(this.value);" /></td>

<td><input type="text" name="allPerson" id="allPerson"  validate="All,int,no" tabindex="1"  class="auto" size="2" value="" onblur="populationAllRate(this.value);"  /></td>

<td><input type="text" name="populationAll" tabindex="1"  validate="Rate per 1000 Population All,float,no"  id="populationAll" class="auto" size="18" value=""  /></td>

<%if(medicalBoardList.get(0)!= null){ %>
<td><input type="text" name="medicalBoard"  readonly="readonly"  validate="Medical Board,int,no"  tabindex="1"  id="medicalBoard" class="auto" size="8" value="<%=medicalBoardList.get(0)%>"  /></td>
<%}%>
<%if(medicalExamList.get(0)!= null){ %>
<td><input type="text" name="medicalExam"  readonly="readonly"  validate="Medical Exam,int,no" tabindex="1"  id="medicalExam" class="auto" size="8" value="<%=medicalExamList.get(0) %>"  /></td>
<%}%>
</tr>
</table>
</div>

<div class="clear paddingTop15"></div>

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
<div class="Clear"></div>
<input type="button" name="Submit" value="Submit" tabindex="1" class="button" onClick="submitForm('monthlyWorkload','/hms/hms/mis?method=submitMonthlyWorkload');" />

</form>

</div> 

<script type="text/javascript">

function totalSickPopulation(val){
	
	var totalSick=0;

	if(document.getElementById('OffAirCrew').value != null && document.getElementById('OffAirCrew').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('OffAirCrew').value);
	}

	if(document.getElementById('OffGD').value != null && document.getElementById('OffGD').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('OffGD').value);
	}

	if(document.getElementById('airmenAirCrew').value != null && document.getElementById('airmenAirCrew').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('airmenAirCrew').value);
	}

	if(document.getElementById('airmenOthers').value != null && document.getElementById('airmenOthers').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('airmenOthers').value);
	}

	if(document.getElementById('ncs').value != null && document.getElementById('ncs').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('ncs').value);
	}

	if(document.getElementById('dsc').value != null && document.getElementById('dsc').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('dsc').value);
	}

	if(document.getElementById('allFamilies').value != null && document.getElementById('allFamilies').value != 0)
	{
		totalSick = Number(totalSick) + Number(document.getElementById('allFamilies').value);
	}
	
	document.getElementById('totalSick').value = totalSick;
}

function populationSickRate(val){
	
	var rateSickPopulation=0;

	if(document.getElementById('totalSick').value != null && document.getElementById('totalSick').value != 0)
	{ 
		rateSickPopulation = (Number(Number(document.getElementById('totalSick').value)/1000)*100);
		rateSickPopulation = parseFloat(rateSickPopulation).toFixed(2);
	}
	document.getElementById('populationSick').value = rateSickPopulation;
}

function totalServicePersonPopulation(val){
	
	var totalServicePerson=0;

	if(document.getElementById('servicePerson').value != null && document.getElementById('servicePerson').value != 0)
	{
		totalServicePerson = Number(totalServicePerson) + Number(document.getElementById('servicePerson').value);
	}

	if(document.getElementById('families').value != null && document.getElementById('families').value != 0)
	{
		totalServicePerson = Number(totalServicePerson) + Number(document.getElementById('families').value);
	}
	document.getElementById('total').value = totalServicePerson;
}

function populationServicePersonRate(val){
	
	var rateServicePersonPopulation=0;

	if(document.getElementById('total').value != null && document.getElementById('total').value != 0)
	{
	
		rateServicePersonPopulation = (Number(Number(document.getElementById('total').value)/1000)*100);
		rateServicePersonPopulation = parseFloat(rateServicePersonPopulation).toFixed(2);
	}
	
	document.getElementById('populationServicePerson').value = rateServicePersonPopulation;
}

function totalAllPopulation(val){
	
	var totalAll=0;

	if(document.getElementById('totalSick').value != null && document.getElementById('totalSick').value != 0)
	{
		totalAll = Number(totalAll) + Number(document.getElementById('totalSick').value);
	}

	if(document.getElementById('total').value != null && document.getElementById('total').value != 0)
	{
		totalAll = Number(totalAll) + Number(document.getElementById('total').value);
	}
	document.getElementById('allPerson').value = totalAll;
}

function populationAllRate(val)
{
	var rateAllPopulation=0;

	if(document.getElementById('allPerson').value != null && document.getElementById('allPerson').value != 0)
	{
		
		rateAllPopulation = (Number(Number(document.getElementById('allPerson').value)/1000)*100);
		rateAllPopulation = parseFloat(rateAllPopulation).toFixed(2);
	}
	
	document.getElementById('populationAll').value = rateAllPopulation;

}
</script>