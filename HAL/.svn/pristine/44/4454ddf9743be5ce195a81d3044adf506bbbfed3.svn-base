<%@page import="static jkt.hms.util.RequestConstants.*"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasIcd"%>
<%@page import="jkt.hms.masters.business.MasIcdSubCategory"%>
<%@page import="java.util.Iterator"%>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/proto.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script src="/hms/jsp/js/unittest.js" type="text/javascript"></script>
<script type="text/javascript">
var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
var IMGDIR_MISC = "images/misc";
var vb_disable_ajax = parseInt("0", 10);
</script>
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
	
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
	String currentDate = (String)utilMap.get("currentDate");  
	String time = (String)utilMap.get("currentTime");
	List<MasIcd> masIcdList= new ArrayList<MasIcd>();
	
 %> 
 <div class="titleBg">
<h2>Disease Wise Patient Details</h2>
</div> 
<div class="clear"></div>
<form name="diseaseWisePatientDetails" method="post" >
<div class="Block">
<div class="clear"></div>
<label><span>*</span> From Date </label>
<input	type="text" name="<%=FROM_DATE%>" value="<%=currentDate%>"	validate="From Date,dateOfAdmission,yes" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"	onclick="setdate('<%=currentDate%>',document.diseaseWisePatientDetails.<%=FROM_DATE%>,event);" />
<label> To Date </label>
<input type="text"	name="<%=TO_DATE%>" value="<%=currentDate%>"	validate="To Date,dateOfAdmission,no" MAXLENGTH="30"	readonly="readonly" />
<img id="calendar"	src="/hms/jsp/images/cal.gif" width="16" height="16" border="0"	validate="Pick a date"onclick="setdate('<%=currentDate%>',document.diseaseWisePatientDetails.<%=TO_DATE%>,event);" />
<div class="clear"></div>
<div class="clear"></div>
<label><span>*</span> ICD Name 1</label>
<input type="text"	name="icdName1" value=""	validate="ICD Name 1,string,no" MAXLENGTH="30"/>
<label><span>*</span> ICD Name 2</label>
<input type="text"	name="icdName2" value=""	validate="ICD Name 2,string,no" MAXLENGTH="30"/>
<div class="clear"></div>
 
<label>Summary </label> 
<input type="radio" name="reportId" name="reportId" value="1"  class="radioCheck" onclick="fillRadio(this)"/>
<label>Detail</label> 
<input type="radio" name="reportId" name="reportId" value="2"  class="radioCheck" onclick="fillRadio(this)"/>
<input type="hidden" name="summary" id="summary" value="0" />
</div>
<script type="text/javascript">
function fillRadio(printValueObj){
	var allValues = printValueObj.value;
	document.getElementById('summary').value = allValues;
}
function getDeseaseDetails(icdName,icdName1,icdName2,fromDate,toDate)
{
	//document.getElementById('summary').value =3;
	//document.getElementById('icdNameForSearch').value =icdName;
 var url="/hms/hms/opd?method=showDiseaseWisePatient&icdName1="+icdName1+"&icdName2="+icdName2+"&fromDate="+fromDate+"&toDate="+toDate+"&summary=3&icdNameForSearch="+icdName;
 window=window.open(url,'name',"left=2,top=100,height=600,width=1010,status=1,scrollbars=1,resizable=0");
	 //alert("Detention Advice ....");
}
</script>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="Submit" value="Generate Report" class="buttonBig" onclick="submitProtoAjaxWithDivName('diseaseWisePatientDetails','/hms/hms/opd?method=showDiseaseWisePatient','patientDetails')"></input>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<div id="patientDetails"></div>

</form>
