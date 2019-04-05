
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>


<script type="text/javascript" language="javascript"	src="/hms/jsp/js/proto.js"></script>
<script type="text/javascript"
	language="javascript">
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
<h2>PVMS/NIV Master report</h2>
</div>
<form name="PvmsNivMasterReport" method="post" action="">
<div class="Block">
<label>Section Wise </label>
<input	type="checkbox" class="radioAuto" id="SectionWise" name="<%=SECTION_ID%>" value=1	onclick="aa();">
<div id="sectionList" style="display: none;">
<label>Select Section </label>
<select id="sectionListId"	name="<%=SECTION_LIST %>" validate="Category,string,no">
	<option value="">Select</option>
	<%	for (MasStoreSection masStoreSection : sectionList) {%>
	<option value="<%=masStoreSection.getId() %>"><%=masStoreSection.getSectionName()%></option>
	<%}	%>
</select>
</div>
<div class="clear"></div>
<label>PVMS List</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO%>" value=1 checked="checked">

<div class="clear"></div>
<label>NIV List</label>
<input type="radio" class="radioAuto" name="<%=SELECTED_RADIO %>" value=2>
<div class="clear"></div>
<%--<label>SUB-Section Wise PVMS/NIV List</label>
<input type="checkbox"  class="radioAuto" id="SubSectionWise" name="<%=SECTION_ID_DEPENDENT_INDENT%>" value=1 onclick="bb();"> --%>
<div id="subSectionList" style="display: none;">
<label>Select Sub Section </label>
<select	id="subSectionListId" name="<%=SUB_SECTION_LIST %>"	validate="Category,string,no">
<option value="">Select</option>
	<%		for (MasItemCategory masItemCategory : subSectionList) {	%>
<option value="<%=masItemCategory.getId() %>"><%=masItemCategory.getItemCategoryName()%></option>
	<%	}	%>
</select></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="OK" value="Generate Report" class="buttonBig"  onClick="submitForm('PvmsNivMasterReport','stores?method=showItemCatalogue');" />
<input type="button" name="Cancel" value="Cancel" class="button" onClick="submitForm('PvmsNivMasterReport','stores?method=showItemCatalogueJsp');" accesskey="r" />
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




