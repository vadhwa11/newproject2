<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>

<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.masters.business.PatientLifeStyleFactor"%>
<%@page import="jkt.hms.masters.business.PatientGyneDetails"%>
<%@page import="jkt.hms.masters.business.ContraceptiveDetails"%>
<%@page import="jkt.hms.masters.business.HrtDetails"%>
<link href="/hms/jsp/css/style.css" rel="stylesheet" type="text/css" />
<script src="/hms/jsp/js/hms.js" type="text/javascript"></script>
<script src="/hms/jsp/js/common.js" type="text/javascript"></script>
<script src="/hms/jsp/js/calendar.js" type="text/javascript"></script>
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
//Box box = HMSUtil.getBox(request);

Map<String, Object> map = new HashMap<String, Object>();
if(request.getAttribute("map") != null){
	map=(Map<String, Object>)request.getAttribute("map");
}
String message = "";
if(map.get("message")!=null){
	message = (String)map.get("message");
}
List<PatientLifeStyleFactor> lifeStList = new ArrayList<PatientLifeStyleFactor>();
List<PatientGyneDetails> gyneList = new ArrayList<PatientGyneDetails>();
List<ContraceptiveDetails> contList = new ArrayList<ContraceptiveDetails>();
List<HrtDetails> hrtList = new ArrayList<HrtDetails>();
if(map.get("lifeStList")!=null){
	lifeStList = (List<PatientLifeStyleFactor>)map.get("lifeStList");
}
if(map.get("gyneList")!=null){
	gyneList = (List<PatientGyneDetails>)map.get("gyneList");
}
if(map.get("contList")!=null){
	contList = (List<ContraceptiveDetails>)map.get("contList");
}
if(map.get("hrtList")!=null){
	hrtList = (List<HrtDetails>)map.get("hrtList");
}
int hinId=0;
if(map.get("hinId") != null){
	hinId = (Integer)map.get("hinId");
}
String hinNo = "";
if(map.get("hinNo") != null){
	hinNo = (String)map.get("hinNo");
}
int gender=0;
if(map.get("gender") != null){
	gender = (Integer)map.get("gender");
}
%>
<style>
<!--
html {height:auto;}
-->
</style>
<!--main content placeholder starts here-->
<form name="lifeStyle" action="" method="post">
<h4><%=message %></h4>
<div class="clear"></div>

<input type="hidden" name="hinId" value="<%= hinId%>" />
<input type="hidden" name="hinNo" value="<%= hinNo%>" />
<input type="hidden" name="gender" value="<%= gender%>" />

<h4>Lifestyle Habits <input type="checkbox" class="radioAuto" name="" />Nil</h4>

<table class="cmntable">

<tr>
<th></th>
<th>Habit</th>
<th>Quantity (With Unit)</th>
<th colspan="2">Duration</th>
<th>Age When Started</th>
<th>Quit (Y/ N)</th>
<th>Age When Quit</th>
</tr>
<%
	if(lifeStList.size() > 0){
		for(PatientLifeStyleFactor lifeStyleFactor : lifeStList){
			if(lifeStyleFactor.getHabit().equals("Alcohol")){
%>

<tr>

<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Alcohol" readonly="readonly" validate="habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>" validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit1" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit1').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" id="quit1" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit1').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>" validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>

<%
	
			if(lifeStyleFactor.getHabit().equals("Beedi")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Beedi" readonly="readonly" validate="habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>" validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit2" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit2').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit2" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit2').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>


<%

			if(lifeStyleFactor.getHabit().equals("Betel Leaves")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="BetelLeaves" readonly="readonly" validate="habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit3" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit3').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit3" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit3').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>




<%
	
			if(lifeStyleFactor.getHabit().equals("Betel Nuts")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Betel Nuts" readonly="readonly" validate="habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit4" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit4').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit4" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit4').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>


<%
	
			if(lifeStyleFactor.getHabit().equals("Cigarette")){
%>



<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Cigarette" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>" validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit5" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit5').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit5" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit5').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>



<%
	
			if(lifeStyleFactor.getHabit().equals("Gutka")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Gutka" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>"  validate="Duration,metachar,no"/>
</td>

<td> 
<select name="durationUnit" class="smaller" id="durationUnit6" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit6').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit6" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit6').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>



<%

			if(lifeStyleFactor.getHabit().equals("Pan Masala")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Pan Masala" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit7" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit7').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit7" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit7').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>



<%
	
			if(lifeStyleFactor.getHabit().equals("Snuff")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Snuff" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit8" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit8').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit8" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit8').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>" validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>



<%

			if(lifeStyleFactor.getHabit().equals("Tobacco Chewing")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Tobacco Chewing" readonly="readonly" validate="Habit,metachar,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit9" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit9').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit9" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit9').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>" validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>



<%
	
			if(lifeStyleFactor.getHabit().equals("Food Habits (Veg/ Non Veg)")){
%>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Food Habits (Veg/ Non Veg)" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" value="<%=lifeStyleFactor.getQuantity()!=null?lifeStyleFactor.getQuantity():"" %>" validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" value="<%=lifeStyleFactor.getDuration()!=null?lifeStyleFactor.getDuration():"" %>" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" id="durationUnit10" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>
<script>
document.getElementById('durationUnit10').value = '<%=lifeStyleFactor.getDurationUnit()!=null?lifeStyleFactor.getDurationUnit():""%>'
</script>
<td>
<input type="text" name="startAge" size="2" maxlength="3" value="<%= lifeStyleFactor.getStartAge()!=null?lifeStyleFactor.getStartAge():""%>" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" id="quit10" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>
<script>
document.getElementById('quit10').value = '<%=lifeStyleFactor.getQuit()!=null?lifeStyleFactor.getQuit():""%>'
</script>
<td>
<input type="text" name="quitAge" size="2" maxlength="3" value="<%=lifeStyleFactor.getQuitAge()!=null?lifeStyleFactor.getQuitAge():"" %>"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="<%=lifeStyleFactor.getId() %>" validate="Life Style Id,int,no"/>
</td>

</tr>
<%} %>

<%}
		}else{ %>

<tr>

<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Alcohol" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>


<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>
</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0"  validate="Life Style id,int,no"/>
</td>

</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Beedi" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10"  maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0"/>
</td>
</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Betel Leaves" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10"  maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0"/>
</td>

</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Betel Nuts" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>

</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate="  ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Cigarette" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Gutka" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Quantity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3" validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>


<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Pan Masala" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20" validate="Qunatity,metachar,no" />
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Snuff" readonly="readonly" validate=" Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit" class="" value="Tobacco Chewing" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no">
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3"  validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3" validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>

<tr>
<td>
<input type="checkbox" class="radioAuto" name="" validate=" ,metachar,no"/>
</td>

<td>
<input type="text" name="habit"  value="Food Habits (Veg/ Non Veg)" readonly="readonly" validate="Habit,LifeStyle,no"/>
</td>

<td>
<input type="text" name="quantity" size="10" maxlength="20"  validate="Qunatity,metachar,no"/>
</td>

<td>
<input type="text" name="duration" size="3" maxlength="3"  validate="Duration,metachar,no"/>
</td>

<td>
<select name="durationUnit" class="smaller" validate="Duration,metachar,no" >
<option value="">Select</option>
<option value="days">Days</option>
<option value="weeks">Weeks</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>
</td>

<td>
<input type="text" name="startAge" size="2" maxlength="3" validate="Start Age,metachar,no"/>
</td>

<td>
<select name="quit" class="small" validate="Quit,metachar,no">
<option value="">Select</option>
<option value="yes">Yes</option>
<option value="no">No</option>
</select>

</td>

<td>
<input type="text" name="quitAge" size="2" maxlength="3"  validate="Quit Age,metachar,no"/>
<input type="hidden" name="lifeStyleFactorId" value="0" validate="Life Style Id,int,no"/>
</td>
</tr>
<%} %>
</table>

<div class="clear paddingTop15"></div>
<%
	PatientGyneDetails gyneDetails = new PatientGyneDetails();
	int gynDetailsId = 0; 
	if(gyneList.size()>0){
		gyneDetails = gyneList.get(0);
		gynDetailsId = gyneDetails.getId();
	}


	if(gender==2){
%>
<input type="hidden" name="gynDetailsId" value="<%=gynDetailsId %>" />
<h4>Menstrual/ Obstetric/ Contraceptive History <input type="checkbox" class="radioAuto" />Not Applicable</h4>

<div class="Block">

<label>Menstrual History</label>
<%
if(gyneDetails.getMenstrualHistoryUnknown()!=null && !gyneDetails.getMenstrualHistoryUnknown().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="menstrualHistory" value="y" checked="checked"/>
<%}else{ %>
<input type="checkbox" class="radioAuto" name="menstrualHistory" value="y" />
<%} %>
<label class="medium5">Unknown</label>

<div class="clear"></div>

<label>Status</label>
<%
String menstrualStatus= "";
if(gyneDetails.getMenstrualStatus()!=null){
	menstrualStatus=gyneDetails.getMenstrualStatus();
}
if(menstrualStatus.equals("preMenarchal")){
%>
<input type="radio" name="menstrualStatus" class="radioAuto" value="preMenarchal" checked="checked"/>
<%}else{ %>
<input type="radio" name="menstrualStatus" class="radioAuto" value="preMenarchal"/>
<%} %>
<label class="auto">Pre-Menarchal</label>

<%
if(menstrualStatus.equals("preMenupausal")){
%>
<input type="radio" name="menstrualStatus" class="radioAuto" value="preMenupausal" checked="checked"/>
<%}else{ %>
<input type="radio" name="menstrualStatus" class="radioAuto" value="preMenupausal"/>
<%} %>
<label class="medium7">Pre-Menopausal</label>

<%
if(menstrualStatus.equals("preMenupausal")){
%>
<input type="radio" name="menstrualStatus" class="radioAuto" value="periMenopausal" checked="checked"/>
<%}else{ %>
<input type="radio" name="menstrualStatus" class="radioAuto" value="periMenopausal"/>
<%} %>

<label class="auto">Peri-Menopausal</label>

<%
if(menstrualStatus.equals("preMenupausal")){
%>
<input type="radio" name="menstrualStatus" class="radioAuto" value="postMenopausal" checked="checked"/>
<%}else{ %>
<input type="radio" name="menstrualStatus" class="radioAuto" value="postMenopausal"/>
<%} %>
<label class="auto">Post-Menopausal</label>

<div class="clear"></div>

<label>LMP</label>
<input type="text" class="autoArial" size="9" name="lmp"  validate="lmp,metachar,no" readonly="readonly" value="<%=(gyneDetails.getLmp()!=null && !gyneDetails.getLmp().equals(""))?HMSUtil.convertDateToStringWithoutTime(gyneDetails.getLmp()):"" %>" />
<img id="calendar" src="/hms/jsp/images/cal.gif"  validate="Pick a date" class="calender" 	onClick="setdate('',document.lifeStyle.lmp,event)" /> 

<%
if(gyneDetails.getLmpUnknown()!=null && !gyneDetails.getLmpUnknown().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="lmpUnknown" checked="checked"/>
<%}else{ %>
<input type="checkbox" class="radioAuto" name="lmpUnknown"/>
<%} %>
<label class="medium7">Unknown</label>

<div class="clear"></div>

<label>Age of Menarche</label>
<input type="text" class="autoArial" size="19" name="menarcheAge"  validate="Age of Menarche,metachar,no" maxlength="10" value="<%=gyneDetails.getMenarcheAge()!=null?gyneDetails.getMenarcheAge():"" %>"/>

<label class="medium7">Age of Menopause</label>
<input type="text" name="menopauseAge"  maxlength="10" class="autoArial" size="18"  validate="Age of Menopause,metachar,no" value="<%=gyneDetails.getMenopauseAge()!=null?gyneDetails.getMenopauseAge():"" %>" />

<label>Menstrual Cycle</label>
<select name="menstrualCycle" id="menstrualCycle" validate="Menstrual Cycle,metachar,no">
<option value="">Select</option>
<option value="Regular">Regular</option>
<option value="Irregular">Irregular</option>
</select>
<script>
document.getElementById('menstrualCycle').value='<%=gyneDetails.getMenstrualCycle()!=null?gyneDetails.getMenstrualCycle():""%>'
</script>
<div class="clear"></div>

<label>Menstrual Flow</label>
<select name="menstrualFlow" id="menstrualFlow" class="small" validate="Menstrual Flow,metachar,no">
<option value="">Select</option>
<option value="Normal">Normal</option>
<option value="Light">Light</option>
<option value="Heavy">Heavy</option>
</select>
<script>
document.getElementById('menstrualFlow').value='<%=gyneDetails.getMenstrualFlow()!=null?gyneDetails.getMenstrualFlow():""%>'
</script>
<input class="transparent" size="2" />
<label class="medium7">Dysmenorrhoea</label>
<input type="text" class="autoArial" size="18" name="dysmenonhoea"   validate="Dysmenorrhoea,metachar,no" maxlength="50"  value="<%=gyneDetails.getDysmenorrhea()!=null?gyneDetails.getDysmenorrhea():"" %>" />

<label>Menstrual Abnormalities</label>
<input type="text" name="menstrualAbnormalities"  validate="Menstrual Abnormalities,metachar,no"  maxlength="100" value="<%=gyneDetails.getMenstrualAbnormalities()!=null?gyneDetails.getMenstrualAbnormalities():"" %>" />


</div>

<div class="clear paddingTop15"></div>

<h4>Obstetric History
<%
if(gyneDetails.getObstetricHistoryUnknown()!=null && !gyneDetails.getObstetricHistoryUnknown().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="obstetricHistoryUnknown" value="y" checked="checked"/>Unknown
<%}else{ %>
<input type="checkbox" class="radioAuto" name="obstetricHistoryUnknown" value="y"/>Unknown
<%} %>
<%
if(gyneDetails.getObstetricHistoryUnknown()!=null && !gyneDetails.getObstetricHistoryUnknown().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="obstetricHistoryNotApplicable" value="y" checked="checked"/>Not Applicable
<%}else{ %>
<input type="checkbox" class="radioAuto" name="obstetricHistoryNotApplicable" value="y"/>Not Applicable
<%} %>
</h4>
<div class="Block">

<label class="medium">Gravida</label>
<input type="text" class="small" name="gravida" maxlength="2" validate="Gravida,int,no" value="<%=gyneDetails.getGravida()!=null?gyneDetails.getGravida():"" %>" />

<label class="medium">Para</label>
<input class="small" type="text" name="para" maxlength="2"  validate="Para,int,no" value="<%=gyneDetails.getPara()!=null?gyneDetails.getPara():"" %>" />

<label class="medium7">Abortions</label>
<input class="small" type="text" name="abortions" maxlength="2"  validate="Abortions,int,no" value="<%=gyneDetails.getAbortions()!=null?gyneDetails.getAbortions():"" %>" />


<label class="medium6">Children</label>
<input type="text" class="small" name="children" maxlength="2"  validate="Children,int,no" value="<%=gyneDetails.getChildren()!=null?gyneDetails.getChildren():"" %>" />


<%
if(gyneDetails.getPregnent()!=null && !gyneDetails.getPregnent().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="pregnent" value="y" checked="checked"/>
<%}else{ %>
<input type="checkbox" class="radioAuto" name="pregnent" value="y"/>
<%} %>
<label class="medium">Pregnant</label>
<%
if(gyneDetails.getLactating()!=null && !gyneDetails.getLactating().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="lactating" value="y" checked="checked"/>
<%}else{ %>
<input type="checkbox" class="radioAuto" name="lactating" value="y"/>
<%} %>
<label class="medium">Lactating</label>

<div class="clear"></div>

<label>Age at First Delivery</label>
<input type="text" class="autoArial" size="21" name="firstDeliveryAge" validate="Age at First Delivery,metachar,no" maxlength="10" value="<%=gyneDetails.getFirstDeliveryAge()!=null?gyneDetails.getFirstDeliveryAge():"" %>" />

<label class="medium7">Age at Last Delivery</label>
<input type="text" name="lastDeliveryAge" class="small" validate="Age at Last Delivery,metachar,no"  maxlength="10" value="<%=gyneDetails.getLastDeliveryAge()!=null?gyneDetails.getLastDeliveryAge():"" %>" />

<label class="medium6">Breast Feeding</label>
<input type="text" name="breastFeeding" class="small" validate="Breast Feeding,metachar,no" maxlength="30" vlaue="<%=gyneDetails.getBreastFeeding()!=null?gyneDetails.getBreastFeeding():"" %>" />

<div class="clear"></div>

<label>Duration</label>
<input type="text" name="feedingDuration" class="autoArial" size="21"  validate="Duration,metachar,no" maxlength="20" value="<%=gyneDetails.getBreastFeedingDuration()!=null?gyneDetails.getBreastFeedingDuration():"" %>" />

<label class="medium7">Molar Pregnancy</label>
<input type="text" name="molarPregnency" class="autoArial" size="27"  validate="Molar Pregnancy,metachar,no" maxlength="50" value="<%=gyneDetails.getMolarPregnency()!=null?gyneDetails.getMolarPregnency():"" %>" />

</div>
<div class="clear paddingTop15"></div>


<h4>Contraceptive History <input type="checkbox" class="radioAuto" />Unknown</h4>

<table class="cmntable" id="contraceptiveDt">

<tr>
<th>Contraceptive</th>
<th colspan="2">Duration</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
if(contList.size() > 0){
	int j=1;
	for(ContraceptiveDetails contraceptiveDetails : contList){
%>
<tr>
<td>
<input type="text" name="contraceptive" maxlength="50" validate="Contraceptive,metachar,no" value="<%=contraceptiveDetails.getContraceptive()!=null?contraceptiveDetails.getContraceptive():"" %>"/>
</td>

<td>
<input type="text" name="contraDuration" maxlength="10" validate="Duration,metachar,no" value="<%=contraceptiveDetails.getDuration()!=null?contraceptiveDetails.getDuration():"" %>"/>
</td>

<td>
<select name="contraDurationUnit" id="contraDurationUnit<%=j %>" validate="Contra Duration,metachar,no">
<option value="">Select</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>

</td>
<script>
document.getElementById('contraDurationUnit<%=j%>').value='<%=contraceptiveDetails.getDurationUnit()!=null?contraceptiveDetails.getDurationUnit():""%>'
</script>
<td><input name="Button" type="button" class="buttonAdd" value=""	onclick="generateRowWithoutSrNo('contraceptiveDt');" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('contraceptiveDt',this);" tabindex="1" />
<input type="hidden" name="contraDetailsId" value="<%=contraceptiveDetails.getId() %>"/>
</td>
</tr>

<%
	j++;}
}else{ %>
<tr>
<td>
<input type="text" name="contraceptive" maxlength="50" validate="Contraceptive,metachar,no"/>
</td>

<td>
<input type="text" name="contraDuration" maxlength="10" validate="ContraDuration,metachar,no"/>
</td>

<td>
<select name="contraDurationUnit" validate="ContraDuration,metachar,no">
<option value="">Select</option>
<option value="months">Months</option>
<option value="years">Years</option>
</select>

</td>
<td><input name="Button" type="button" class="buttonAdd" value=""	onclick="generateRowWithoutSrNo('contraceptiveDt');" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('contraceptiveDt',this);" tabindex="1" />
<input type="hidden" name="contraDetailsId" value="0"/>
</td>
</tr>
<%} %>
</table>

<div class="clear paddingTop15"></div>

<h4>Harmone Replacement Therapy <input type="checkbox" class="radioAuto" value="y"/>Unknown</h4>


<table class="cmntable" id="hrtDt">

<tr>
<th>Hormones</th>
<th>From</th>
<th>To</th>
<th>Route of Admin</th>
<th>For Index Cancer</th>
<th>Add</th>
<th>Delete</th>
</tr>
<%
int i=1;
	if(hrtList.size() > 0){
		for(HrtDetails hrtDetails : hrtList){
%>
<tr>
<td>
<input type="text" name="hormons"  maxlength="50" value="<%=hrtDetails.getHormone()!=null?hrtDetails.getHormone():"" %>" validate="Hormons,metachar,no"/>
</td>

<td>
<input type="text" name="fromDate" id="fromDate<%=i %>" readonly="readonly" value="<%=(hrtDetails.getFromDate()!=null && !hrtDetails.getFromDate().equals("")?HMSUtil.convertDateToStringWithoutTime(hrtDetails.getFromDate()):"") %>" validate="From Date,frdate,no"/>
<img id="calendar" src="/hms/jsp/images/cal.gif"  validate="Pick a date" class="calender"
	onClick="setdate('',document.getElementById('fromDate<%=i %>'),event)" /> 
</td>

<td>
<input type="text" name="toDate" id="toDate<%=i %>" readonly="readonly" value="<%=(hrtDetails.getFromDate()!=null && !hrtDetails.getToDate().equals("")?HMSUtil.convertDateToStringWithoutTime(hrtDetails.getToDate()):"") %>" validate="To Date,frdate,no"/>
<img id="calendar" src="/hms/jsp/images/cal.gif"  validate="Pick a date" class="calender"
	onClick="setdate('',document.getElementById('toDate<%=i %>'),event)" /> 
</td>

<td>
<input type="text" name="route" maxlength="50" value="<%=hrtDetails.getRoute()!=null?hrtDetails.getRoute():"" %>" validate="Route,metachar,no"/>
</td>

<td>
<%
if(hrtDetails.getIndexCancer()!=null && !hrtDetails.getIndexCancer().equals("n")){
%>
<input type="checkbox" class="radioAuto" name="indexCancer" value="y" checked="checked"/>
<%}else{ %>
<input type="checkbox" class="radioAuto" name="indexCancer" value="y"/>
<%} %>

</td>
<td><input name="Button" type="button" class="buttonAdd" value=""	onclick="addRowHormone();" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('hrtDt',this);" tabindex="1" />
<input type="hidden" name="hrtDetailsId" value="<%=hrtDetails.getId() %>"/>
</td>
</tr>

<%
		i++;}
		%>
		<input type="hidden" name="hdb" id="hdb" value="<%=i-1 %>"/>
	<%}else{ %>
<tr>
<td>
<input type="text" name="hormons"  maxlength="50" validate="Hormons,metachar,no"/>
</td>

<td>
<input type="text" name="fromDate" id="fromDate<%=i %>" readonly="readonly" validate="From Date,frdate,no"/>
<img  src="/hms/jsp/images/cal.gif"  validate="Pick a date" 
	onClick="setdate('',document.getElementById('fromDate<%=i %>'),event)" /> 
</td>

<td>
<input type="text" name="toDate" id="toDate<%=i %>" readonly="readonly" validate="To Date,frdate,no"/>
<img  src="/hms/jsp/images/cal.gif"  validate="Pick a date" 	onClick="setdate('',document.getElementById('toDate<%=i %>'),event)" /> 
</td>

<td>
<input type="text" name="route" maxlength="50" validate="Route,metachar,no"/>
<input type="hidden" name="hrtDetailsId" value="0"/>
</td>

<td>
<input type="checkbox" class="radioAuto" name="indexCancer" value="y"/>
</td>
<td><input name="Button" type="button" class="buttonAdd" value=""	onclick="addRowHormone();" tabindex="1" /></td>
<td><input type="button" name="delete" value="" class="buttonDel" onclick="removeRow('hrtDt',this);" tabindex="1" />
</td>
</tr>
<%} %>
</table>
<input type="hidden" name="hdb" id="hdb" value="<%=i %>"/>
<%} %>
<div class="clear"></div>
<input type="button" class="button" value="Submit" name="Submit11" onclick="submitForm('lifeStyle','/hms/hms/registration?method=saveLifeStyleFactors');"/>
<input type="button" name="Close" value="Close" onclick="window.close();"/>
<div class="clear"></div>
</form>
<script>

function addRowHormone(){
	 var tbl = document.getElementById('hrtDt');
	  var lastRow = tbl.rows.length;

	  var iteration = lastRow;
	  var row = tbl.insertRow(lastRow);
	  var hdb = document.getElementById('hdb');
	  var iteration = parseInt(hdb.value)+1;
	  hdb.value = iteration;

	  
	  var cell1 = row.insertCell(0);
	  var e1 = document.createElement('input');
	  e1.type = 'text';
	  e1.tabIndex="1";
	  e1.name='hormons';
	  e1.id='hormons'+iteration
	  e1.maxLength= '30';
	  cell1.appendChild(e1);

	  var cell2 = row.insertCell(1);
	  var e2 = document.createElement('input');
	  e2.type = 'text';
	  e2.tabIndex="1";
	  e2.name='fromDate';
	  e2.id='fromDate'+iteration
	  e2.readOnly=true;
	  cell2.appendChild(e2);
	  var e21 = document.createElement('img');
	  e21.src="/hms/jsp/images/cal.gif"
	  e21.onclick = function(){setdate('',document.getElementById('fromDate'+iteration),event)}
	  cell2.appendChild(e21);
	  

	  var cell3 = row.insertCell(2);
	  var e3 = document.createElement('input');
	  e3.type = 'text';
	  e3.tabIndex="1";
	  e3.name='toDate';
	  e3.id='toDate'+iteration
	  e3.readOnly=true;
	  cell3.appendChild(e3);
	  var e31 = document.createElement('img');
	  e31.src="/hms/jsp/images/cal.gif"
	  e31.onclick = function(){setdate('',document.getElementById('toDate'+iteration),event)}
	  cell3.appendChild(e31);

	  var cell4 = row.insertCell(3);
	  var e4 = document.createElement('input');
	  e4.type = 'text';
	  e4.tabIndex="1";
	  e4.name='route';
	  e4.id='route'+iteration
	  e4.maxLength= '50';
	  cell4.appendChild(e4);

	  var cell5 = row.insertCell(4);
	  var e5 = document.createElement('input');
	  e5.type = 'checkbox';
	  e5.tabIndex="1";
	  e5.name='indexCancer';
	  e5.id='indexCancer'+iteration
	  e5.className='radioAuto';
	  e5.value='y';
	  cell5.appendChild(e5);

	  var cell6 = row.insertCell(5);
	  var e6 = document.createElement('input');
	  e6.type = 'button';
	  e6.className = 'buttonAdd';
	  e6.name='Button'+iteration;
	  e6.setAttribute('onClick', 'addRow();'); 
	  e6.setAttribute('tabindex','1');
	  cell6.appendChild(e6);

	  var cell7 = row.insertCell(6);
	  var e7 = document.createElement('input');
	  e7.type = 'button';
	  e7.className = 'buttonDel';
	  e7.name='delete'+iteration;
	  e7.setAttribute('onClick', 'removeRow("hrtDt",this)'); 
	  e7.setAttribute('tabindex','1');
	  cell7.appendChild(e7);
	  
}

function removeRow(idName,obj)
{
	var tbl = document.getElementById(idName);
	  var lastRow = tbl.rows.length;
	  if (lastRow > 2){
	  //	tbl.deleteRow(lastRow - 1);
	    var i=obj.parentNode.parentNode.rowIndex;
	    tbl.deleteRow(i);
	  }
}
</script>
	