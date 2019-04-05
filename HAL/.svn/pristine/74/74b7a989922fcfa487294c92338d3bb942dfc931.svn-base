<%@page import="jkt.hms.util.HMSUtil"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"	src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/common.js?n=1"></script>
<link href="/hms/jsp/css/style.css?n=1" rel="stylesheet" type="text/css" />

<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Previous Surgery Report</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="">
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="if(validateMetaCharacters(this.value)){document.getElementById('testDiv').value='';getHinNo('search','opd?method=getHinNoForpatientpres&flag=previousSurgery')}" />

<div id="hinDiv">
<label> Patient Name </label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','opd?method=getvisitDetails')}"	 />
</div>
<!-- <label>Visit No for OPD</label> -->
<div class="clear"></div>
<div id="testDiv"> 

</div>
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<!-- <input type="button" name="OK" value="Case Sheet" class="button"
	onClick="submitForm('search','opd?method=showOpdCaseSheetReport&flagPrint=opd');" />
<input type="button" name="OK" value="Opd Question Print" class="button"
	onClick="submitForm('search','opd?method=showOpdCaseSheetReport&flagPrint=opdQuestion');" id="psyReport" style="display: none;"/>

	
<input name="
Ophthalmology Details" value="Ophthalmology Details" id="ophthalReport" class="button" onclick="submitForm('search','opd?method=showPatientEyeDetailsReport');" type="button" style="display: none;">
	
<input type="reset" name="Reset" value="Cancel" class="button"
	onclick="location.reload();" accesskey="r" /> -->
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="hidden" name="allSurgeryType" value="y">
</form>
