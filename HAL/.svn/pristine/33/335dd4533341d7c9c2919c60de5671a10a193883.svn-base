<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<!-- <script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script> -->
<!-- <META HTTP-EQUIV="REFRESH" CONTENT="20"> -->
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>

<!--  <script type="text/javascript" language="javascript" src="/hms/jsp/js/IPDGrid.js"></script>-->

<script type="text/javascript" language="javascript"src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
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
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

%>
<!--main content placeholder starts here-->
<form name="antenatalCard" action="" method="post">

<div class="titleBg">
<h2>CONCEPTION CASE</h2>
</div>

<div class="clear"></div>

<h4>PATIENT DETAILS</h4>
<div class="clear paddingTop15"></div>
<div class="Block">

<label>Service No.</label>
<input type="text" name="serviceNo"></input>

<label>Patient Name</label>
<input type="text" name="patientName"></input>

<label>Relation</label>
<input type="text" name="relation"></input>

<div class="clear"></div>

<label>Rank</label>
<input type="text" name="rank"></input>

<label>Name</label>
<input type="text" name="name"></input>

<label>Trade/Branch</label>
<input type="text" name="tradeBranch"></input>

<div class="clear"></div>

<label>Unit</label>
<input type="text" name="unit"></input>

<label>Age</label>
<input type="text" name="age"></input>

<label>Gender</label>
<input type="text" name="gender"></input>

<div class="clear"></div>

<label>Occupation</label>
<input type="text" name="occupation"></input>

<label>Marital Status</label>
<input type="text" name="meritalStatus"></input>

<label>Blood Group</label>
<input type="text" name="bloodGroup"></input>

<div class="clear"></div>

<label>Medical Category</label>
<input type="text" name="medicalCategory"></input>

<label>Date</label>
<input type="text" name="date"></input>

<label>Medical Disability</label>
<input type="text" name="medicalDisability"></input>

</div>
<div class="clear"></div>
<div class="clear paddingTop15"></div>
<h4>Sterilisation Details</h4>
<div class="clear"></div>

<div class="Block">

<label>Year No.</label>
<input type="text" name="yearNo" />

<label>Month No.</label>
<input type="text" name="monthNo" />

<label>Family Planning</label>
<select>
<option>Vascotomy</option>
<option>Tubectomy</option>
</select>

<div class="clear"></div>

<label>Registration No.</label>
<input type="text" name="regNo" class="" size="" />

<label class="">Date</label>
<input type="text" name="date" class="date" />
<img src="/hms/jsp/images/cal.gif" width="16" height="16" border="0" validate="" class="calender" onclick="" />

<label class="">Time</label>
<input type="text" name="time" />

<div class="clear"></div>

<label class="">Age</label>
<label class="auto">Husband</label>
<input type="text" name="husband" class="auto" size="5" /><label class="unit">years</label>

<!--  <input class="transparent" size="1" /> -->

<label class="">Wife</label>
<input type="text" name="wife" class="auto" size="17" /><label class="unit2">years</label>



<label>Religion</label>
<select>
<option>Select</option>
<option>Hindu</option>
<option>Muslim</option>
<option>Christan</option>
<option>Sikh</option>
<option>Budhist</option>
</select>

<div class="clear"></div>

<label>Education</label>
<label class="auto">Husband</label>
<select class="small">
<option>Select</option>
</select>

<!-- <input class="transparent" size="1"></input> -->

<label class="">Wife</label>
<select class="">
<option>Select</option>
</select>



<label>No. of Children</label>
<input type="text" name="noOfChildren" />
<div class="clear"></div>
<label>Doctor's Name</label>
<input type="text" name="doctorName" />

<label>Hospital Name</label>
<input type="text" name="hospitalName" />

<label>Address</label>
<textarea rows="" cols="" name="address"></textarea>
<div class="clear"></div>

<label>Remarks</label>
<textarea rows="" cols="" name="Remarks"></textarea>
</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Button" class="button" value="SAVE"/>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>