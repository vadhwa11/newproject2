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
<form name="budgetAndExpense" action="" method="post">

<div class="titleBg">
<h2>Medical Information Database</h2>
</div>

<div class="clear paddingTop15"></div>
<div class="Block">

<label>Service No.</label>
<input type="text" name="serviceNo" />

<label>Rank</label>
<input type="text" name="rank" />

<label>Name</label>
<input type="text" name="name" />

<div class="clear"></div>

<label>Trade/Branch</label>
<input type="text" name="branchTrade" />

<label>Gender</label>
<select>
<option>Male</option>
<option>Female</option>
</select>

<label>Age</label>
<input type="text" name="age" />

<div class="clear"></div>

<label>DOC/DOE</label>
<input type="text" name="comm" />

<label >Height</label>
<input type="text" name="height" class="autoArial" size="15" />
<label class="unit2">cm</label>

<label >Weight</label>
<input type="text" name="weight" class="autoArial" size="15" />
<label class="unit2">kg</label>

<div class="clear"></div>

<label>Blood Group</label>
<input type="text" name="bloodGrp" />

<label>Date of Med Cat</label>
<input type="text" name="medCatDate" />

<label>Present Med Cat</label>
<input type="text" name="preMedCat" />

<div class="clear"></div>

<label>Last Medical At</label>
<input type="text" name="lastMedAt" />

<label>Period</label>
<input type="text" name="period" />

<label>DGMS(AIR) Waiver</label>
<input type="text" name="dgms" />

<div class="clear"></div>

<label>Command</label>
<input type="text" name="command" />

<label>Next Due Date</label>
<input type="text" name="nextDue" />

<label>Med Info</label>
<input type="text" name="medInfo" />

</div>

<div class="clear paddingTop15"></div>
<div class="division"></div>
<div class="clear paddingTop15"></div>

<input type="button" class="button" value="Add" name="add"/>
<input type="button" class="button" value="Edit" name="edit" />
<input type="button" class="button" value="Search" name="search" />
<input type="button" class="button" value="Print History" name="print" />

</form>