
<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>

<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
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

<script type="text/javascript" language="javascript">
function fillValues(){
	//alert("in fill");
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=j');
    
}
function fillValues1(){
	var content_id=document.getElementById("nomenclature").value;
	var index1 = content_id.lastIndexOf("[");
    var index2 = content_id.lastIndexOf("]");
    index1++;
    var nom = content_id.substring(index1,index2);
    var item_name=document.getElementById("item_id").value=nom;
    submitForm('PvmsSurplusReport','stores?method=showItemSurplus&flag=p');
    
}
</script>




<div class="titleBg">
<h2>SurPlus Report</h2>
</div>
<form name="PvmsSurplusReport" method="post" action="">
<div class="clear"></div>
<div class="clear"></div>
<div class="Block">
<label>PVMS/NIV No. </label>
<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv" validate="PVMS/NIV No.,alphanumeric1,no" /> 

<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" name="nomenclature" />
<div id="ac2update" style="display: none;" class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
	new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script>
	<label>Life Span</label> 
		<select name="lifeSpan"  validate="Life Span,string,no" tabindex=1>
		<option value="">Select</option>
		<option value="LL">LL</option>
		<option value="SL">SL</option>

		</select>
<div class="clear"></div>
 </div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<div class="clear"></div>
<input type="hidden" id="item_id"  name="item_name"/>
<input type="button" name="OK" value="Generate Report" class="buttonBig" onClick="fillValues();" />
<input type="button" name="OK1" value="Print" class="button" onClick="fillValues1();" /> 
<input type="button" name="Cancel" value="Reset" class="button" onClick="submitForm('PvmsSurplusReport','stores?method=showSurPlusJsp');" accesskey="r" />
<!-- <input type="button" name="ExportToExel" value="ExportToExel" class="button" onClick="submitForm('PvmsSurplusReport','stores?method=showItemSurplus');" />
 -->

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




