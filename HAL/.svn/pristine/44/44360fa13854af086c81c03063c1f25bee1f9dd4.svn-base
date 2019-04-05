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
	Map map = new HashMap();
	//String includedJsp = null;
	if (request.getAttribute("map") != null) {
	map = (Map) request.getAttribute("map");

	}

%>
<!--main content placeholder starts here-->
<form name="antenatalCard" action="" method="post">

<div class="titleBg">
<h2>IUD, Oral Pill and Others Distribution Register</h2>
</div>

<div class="clear"></div>
<h4>Service Personnel Details</h4>
<div class="clear"></div>

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

<div class="clear paddingTop15"></div>
<table cellpadding="0" cellspacing="2">
<tr>
<th>Name</th>
<th>Qty</th>
<th>Location</th>
<th>Issued to </th>
</tr>
<tr>
<td> <input type="text" name=""  /></td>
<td> <input type="text" name=""  /></td>
<td> <input type="text" name=""  /></td>
<td> <select><option>Tub</option></select></td>
</tr>

</table>

<div class="clear paddingTop15"></div>
<div class="Block">
<label>Remarks</label>
<textarea></textarea>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Button" class="button" value="Submit" />
<input type="button" name="Button" class="button" value="Reset" />

</form>