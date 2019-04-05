
<%@page import="jkt.hms.masters.business.StoreIssueM"%>
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>

<link rel="stylesheet" type="text/css" href="/hms/jsp/css/hms_style.css" />
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css" id="vbulletin_css" />
<script type="text/javascript" language="javascript"src="/hms/jsp/js/IPDGrid.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script type="text/javascript" language="javascript">

	<%
	
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}	
 			
 		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
 		List<MasItemCategory> subSectionList = new ArrayList<MasItemCategory>();
 		
 		if (map.get("sectionList") != null) {
 				sectionList = (List<MasStoreSection>) map.get("sectionList");
 	 	}
 		if (map.get("subSectionList") != null) {
 		 		subSectionList = (List<MasItemCategory>) map.get("subSectionList");
 	 	}	
 		List<StoreIssueM> storeIssueMList = new ArrayList<StoreIssueM>();
 		
 		if (map.get("storeIssueMList") != null) {
 			storeIssueMList = (List<StoreIssueM>) map.get("storeIssueMList");
	 	}	
 		
 		
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
			</script> <script>
function aa()
{
    if ( document.PvmsNivMasterReport.<%=SECTION_ID%>.checked == true )
    {
    	document.getElementById("sectionList").style.display='inline';
    	document.getElementById("subSectionList").style.display='none';
    	document.getElementById("SubSectionWise").checked=false;
    }
    else
    {
    	document.getElementById("sectionList").style.display='none';
    }
 }
 
function bb()
{    if ( document.getElementById('SubSectionWise').checked == true )
    {
    	document.getElementById("subSectionList").style.display='inline';
    	document.getElementById("sectionList").style.display='none';
    	document.getElementById("SectionWise").checked=false;
    }
    else
    {
    	document.getElementById("subSectionList").style.display='none';
    }
 }
</script> 

<div class="titleBg">
<h2>Issue Details for MR and RC</h2>
</div>
<form name="showIssueDetailsfrm" method="post" action="">
<div class="Block">
<label>Issue Reference No for MR/RC</label>
 <select id="civNo"
	name="civNo">
	<option value="0">Select</option>
	<%
		for(StoreIssueM storeIssueM :storeIssueMList){
			String MR = storeIssueM.getRequestNo() !=null?storeIssueM.getRequestNo().getDemandNo():"NA";
			String RC = storeIssueM.getRequestNo() !=null?storeIssueM.getRequestNo().getDemandNo():"NA";
			
			String NO= MR.equalsIgnoreCase("NA")?RC:MR;
		%>
	<option value="<%=storeIssueM.getId()%>"><%=storeIssueM.getIssueNo()%>-(<%=NO %>)</option>
	<%}%>
</select>

</div>
<div class="clear"></div>
<div class="paddingTop5"></div>
<div class="clear"></div>
<input type="button" name="OK" value="OK" class="button" onClick="submitForm('showIssueDetailsfrm','stores?method=showIssueDetails');" />
<input type="button" name="Cancel" value="Cancel" class="button" onClick="submitForm('showIssueDetails','stores?method=showIssueDetails');" accesskey="r" />
<!-- <input type="button" name="ExportToExel" value="ExportToExel" class="button" onClick="submitForm('showIssueDetails','stores?method=showIssueDetails');" /> -->

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<script type="text/javascript">
 function checkSection(){
	 var sectionId=document.getElementById('sectionListId').value
	 var subSectionId=document.getElementById('subSectionListId').value
	 if((sectionId !=0 || sectionId != "") && (subSectionId !=0 || subSectionId != "")){
		 alert("Either Select Section or Sub Section..."); 
	 }
 }
 </script>




