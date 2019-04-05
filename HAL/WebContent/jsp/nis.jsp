<%@ page import="static jkt.hms.util.RequestConstants.*"%>

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>

<div class="clear"></div>
<div class="clear"></div>
<div class="titleBg">
<h2>Prescription Report</h2>
</div>
<div class="clear"></div>

<form name="search"  method="post" action="" >
<div class="clear"></div>
<div class="Block">
<div class="clear"></div>
<label>Employee No. </label>
<input type="text" id="serviceNo." name="<%=SERVICE_NO%>" value=""	 MAXLENGTH="30"	onblur="if(validateMetaCharacters(this.value)){getHinNo('search','opd?method=getHinNoForpatientpresForNIS&flag=issueNo')}" />

<div id="hinDiv">
<label> Patient Name </label>
<input	type="text" name="<%=HIN_NO%>" value="" MAXLENGTH="30"	onchange="if(validateMetaCharacters(this.value)){submitProtoAjax('search','opd?method=getvisitDetails')}"	validate="Service No,String,yes" />
</div>
<label>Issue No.</label>
<div id="testDiv"> 
<input type="text" id="visitNo" name="<%=VISIT_NUMBER%>" value="" class="date" MAXLENGTH="6" />
</div>
</div>
<input type="hidden" id="visitId" name="<%=VISIT_ID%>" validate="Issue No.,string,yes" value=""  />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="add1" id="addbutton1" value="Prescription Report" class="button" onClick="submitForm('search','stores?method=printPricriptionIssue');" />
<input type="button" name="add1" id="addbutton1"  value="NIS" class="button" onClick="submitForm('search','stores?method=printPharmacyReport');" />
<input type="button" name="add1" id="addbutton1"  value="NIP" class="button" onClick="submitForm('search','stores?method=printPharmacyReport&flag=nip_slip_report');" />

<input type="reset" name="Reset" value="Cancel" class="button"	onclick="location.reload();" accesskey="r" />
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
	function getVisit(val){
		if(val!=''){
			var data = val.split('@');
			if(data[1]=='l'){
				document.getElementById("NIS").style.display='block';
				document.getElementById("visitId").value=data[0];
			}else{
				document.getElementById("NIS").style.display='none';
				document.getElementById("visitId").value=data[0];
			}
		}else{
			document.getElementById("NIS").style.display='none';
			document.getElementById("visitId").value='';
		}
	}
</script>




