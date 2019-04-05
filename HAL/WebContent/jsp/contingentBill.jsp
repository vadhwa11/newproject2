
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
<h2>Contingent Bill</h2>
</div>

<div class="clear"></div>

<div class="Block">

<label>Name</label>
<input type="text" name="name" />

<label>Age</label>
<input type="text" name="age" />

<label>No. of Children</label>
<input type="text" name="noOfChild" />

<div class="clear" ></div>

<label>Wife of Service No.</label>
<input type="text" name="wifeOfServiceNo" />

<label>Rank</label>
<input type="text" name="rank" />

<label>Name</label>
<input type="text" name="name" />

<div class="clear"></div>

<label>Branch/Trade</label>
<input type="text" name="branchTrade" />

<label>Unit</label>
<input type="text" name="unit" />

<label>Contact No.</label>
<input type="text" name="contactNo" />

<div class="clear"></div>

<label>Address</label>
<input type="text" name="address" />

<label>Service Rendered</label>
<select><option>Tubectomy</option></select>

<label>Done at</label>
<input type="text" name="doneAt" />

<div class="clear"></div>

<label>Date</label>
<input type="text" name="date" />

<label>Payment of Acceptor</label>
<input type="text" name="paymentAcceptor" />

<label>Signature of Acceptor</label>
<input type="text" name="signatureOfAcceptor" />

<div class="clear"></div>

<label>Motivator</label>
<input type="text" name="motivator" />

<label class="">Drugs/ Dressing Charges</label>
<input type="text" name="drugs" />

<label class="">Total</label>
<input type="text" name="total" />

</div>

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="Button" class="button" value="Submit" />
<input type="Reset" class="button" value="Reset" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>