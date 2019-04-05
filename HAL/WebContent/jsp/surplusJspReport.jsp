<%@ page import="static jkt.hms.util.RequestConstants.*"%>
<%@ page import="java.util.*"%>
<%@ page import="jkt.hms.masters.business.MasStoreSection"%>
<%@ page import="jkt.hms.masters.business.MasItemCategory"%>
<%@ page import="jkt.hms.util.HMSUtil"%>

<%--For AutoComplete Through Ajax--%>
<script type="text/javascript" language="javascript"src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>

<script type="text/javascript" language="javascript">

	<%
	//Object[] obj=null;
		Map<String, Object> map = new HashMap<String, Object>();
 			if (request.getAttribute("map") != null) {
 				map = (Map<String, Object>) request.getAttribute("map");
 		}	
 			
 		List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
 		List<MasItemCategory> subSectionList = new ArrayList<MasItemCategory>();
 		Map<String, Object> surplusItemList = new HashMap<String, Object>();
 		if (map.get("surplusItem") != null) {
 			
 			surplusItemList = (Map<String, Object>)map.get("surplusItem");
 			System.out.println("in not null");
 			
 		}
 		List objectList = new ArrayList();
 		if (surplusItemList.get("objectList") != null) {
 			objectList = (List)surplusItemList.get("objectList");
 			System.out.println("objectList in jsp "+objectList.size());

 		}
 		
 		List masManuList = new ArrayList();
 		if (surplusItemList.get("masManuList") != null) {
 			masManuList = (List)surplusItemList.get("masManuList");
 			System.out.println("manulist "+masManuList.size());

 		}
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
		String message ="";
		// System.out.println("--1----- "+surplusItemList.get("msg"));
		if (surplusItemList.get("msg") != null) {
		             message = (String) surplusItemList.get("msg");
		            // System.out.println("------- "+message);
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
<%if(objectList.size()==0){
	
	%>
<h4><%="No Record Found !" %></h4>
<%} %>


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
<!-- <input type="button" name="ExportToExel" value="ExportToExel" class="button" onClick="submitForm('PvmsSurplusReport','stores?method=showItemSurplus');" /> -->
</div>
<div class="clear"></div>
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
 <%if(objectList.size()>0){ %>
 <h2>ITEM DETAILS</h2>
 <div class="division"></div>
 
<table id="main">
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Name of Drug</th>
			<th>A/U </th>

			
			 <th>B/G</th>            
			 <th>MMF</th>
			<th >Stock Qty</th>
			<th >Surplus Qty</th>
			
		</tr>
	</thead>

		<%
		int count=0;
		
		
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		Iterator iterator1 = masManuList.iterator();
		Object[] object1=(Object[])iterator1.next();
		System.out.println(""+object1[1]);%>
		
	
<tr>
<td><%=++count%></td>
<td><div class="calcell"><%=object[3]%></div></td>
<td ><div class="calcell"><%=object[5]%></div></td>
<%if(object[4] != null) {%>
<td ><div class="calcell"><%=object[4]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>

<%if(object[0] != null) {%>
	<td ><div class="calcell"><%=object[0]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	
	<%if(object[1] != null) {%>
	<td ><div class="calcell"><%=object[1]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>
	
	<%if(object[2] != null) {%>
	<td ><div class="calcell"><%=object[2]%></div></td>
	<%}else{ %>
	<td ><div class="calcell">- </div></td>
	<%} %>


	
</tr>
<%}%>
</table>
<%} %>
