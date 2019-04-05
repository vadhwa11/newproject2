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
<h2>Issued Linen List Report</h2>
</div>
<form name="cashSheet" target="_blank" action="" method="post">
<div class="Block">
<div class="clear"></div>
<label>Employee No. <span>*</span></label> 
<input type="text" id="serviceNo" name="serviceNo" value="" validate="Service No.,String,yes" MAXLENGTH="30" onblur="getPatientName(this.value)"/> 
<!--<div id=patient>
<label>Patient Name.</label> 
<input type="text" id="patientName" name="patientName" value="" MAXLENGTH="30" /> 
</div>

-->
<div id="hinDiv"><label> Patient <span>*</span></label> <input type="text"
	name="<%=HIN_NO%>" value="" MAXLENGTH="50"
	onchange="getAdNo(this.value);" /></div>
<div id=adDiv>
<label>A&D No. <span>*</span></label> 
<input type="text" id="adNo" name="adNo" value="" MAXLENGTH="30" onblur="setHinNo();"/> 
</div>
<div class="Clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('cashSheet','ipd?method=printIssuedKitListReport');" />
<input type="reset"	name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script	type="text/javascript">

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

function submitProtoAjaxforPatientName(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
    	   	
        	new Ajax.Updater('patient',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}    	


function submitProtoAjaxforAdNo(formName,action){
	errorMsg = "";
	ob1 = true;
	ob2 = true;
	ob3 = true;
	
	obj = eval('document.'+formName)
	       	obj.action = action;
    	   	 var url=action+"&"+getNameAndData(formName)
    	   	
        	new Ajax.Updater('adDiv',url,
			   {asynchronous:true, evalScripts:true });
	       	return true;
    	}    	



</script>