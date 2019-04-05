<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" src="/hms/jsp/js/autoComplete1.js"></script>
<script type="text/javascript" src="/hms/jsp/js/autoComplete2.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/addRow.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/stores.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/calendar.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<%@page import="java.net.URL"%>
<script>
		 var nameArray=new Array();
		 var itemsArray1=new Array();
	</script>

<script type="text/javascript">
	<!--
	var SESSIONURL = "s=cccfbaab0a70ed43fad9de8e3733112d&";
	var IMGDIR_MISC = "images/misc";
	var vb_disable_ajax = parseInt("0", 10);
	// -->
	</script>
<script>
	<%

		Calendar calendar=Calendar.getInstance();
		String month1=String.valueOf((calendar.get(Calendar.MONTH))+1);
		String date=String.valueOf(calendar.get(Calendar.DATE));
		int year1=calendar.get(calendar.YEAR);
		if(month1.length()<2){
			month1="0"+month1;
		}
		if(date.length()<2){
			date="0"+date;
		}
	%>
		serverdate = '<%=date+"/"+month1+"/"+year1%>'
	</script>


<%
	 	Box box = HMSUtil.getBox(request);
		Map<String, Object> utilMap = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
	 	utilMap = (Map) HMSUtil.getCurrentDateAndTime();
	 	String currentDate = (String)utilMap.get("currentDate");  
	%>
	

<div class="titleBg">
<h2>Date Wise Patient Wise Drug Issued Details</h2>
</div>
<form name="cashSheet" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>
<label>From Date <span>*</span></label>
<input	type="text" name="<%= FROM_DATE %>" readonly="readonly" class="date" maxlength="30" tabindex=1 value="<%=currentDate %>" />
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.cashSheet.<%=FROM_DATE%>,event)" />
<label>To Date <span>*</span></label>
<input	type="text" name="<%= TO_DATE %>" class="date" maxlength="30" readonly="readonly" tabindex=1 value="<%=currentDate %>"/>
<img id="calendar" src="/hms/jsp/images/cal.gif" width="16" height="16"	border="0" validate="Pick a date"  tabindex="1"	onClick="setdate('<%=currentDate%>',document.cashSheet.<%=TO_DATE%>,event)" />
<div class="clear"></div>
<!--<label>Select Nomenclature</label>
 <input type="text" value="" tabindex="1" id="nomenclature1" size="35"  name="nomenclature1" style="width: 700px"/>
<div id="ac2update1" style=" display:none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature1','ac2update1','opd?method=getItemListForAutoCompleteItem',{parameters:'requiredField=nomenclature1&flag=k'});
</script>
-->
<label>Service No. <span>*</span></label> 
<input type="text" id="serviceNo" name="serviceNo" value="" validate="Service No.,String,yes" MAXLENGTH="30" onblur="getPatientName(this.value)"/>
<div id="hinDiv"><label> HIN <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="getAdNo(this.value);" /></div>
<div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" value="" MAXLENGTH="30" onblur="setHinNo();"/> 
</div> 
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('cashSheet','ipd?method=printDateWisePatientWiseDrugIssuedReport');" />
<input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script>
function getPatientName(val)
{
	submitProtoAjaxWithDivName('cashSheet','/hms/hms/ipd?method=showPatientHinNo&paramName='+val,'hinDiv');
//	submitProtoAjaxforPatientName('cashSheet','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=s');
}

function getAdNo(val)
{
	//submitProtoAjaxforAdNo('cashSheet','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p');
	submitProtoAjaxWithDivName('cashSheet','/hms/hms/ipd?method=showPatientName&paramName='+val+'&flag=p','adDiv');
}
function setHinNo(val)
{
	document.getElementById('hinNo12').value=document.getElementById('hinNo').value;
}
</script>