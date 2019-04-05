
<%@page import="jkt.hms.masters.business.MasItemClass"%>
<%@page import="jkt.hms.masters.business.MasStoreGroup"%>
<%@page import="jkt.hms.masters.business.MasItemCategory"%>
<%@page import="jkt.hms.masters.business.MasItemType"%>
<%@page import="java.util.*"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.masters.business.MasStoreSection"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<script type="text/javascript" language="javascript"	src="/hms/jsp/js/calendar.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/gridForPatient.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/ajax.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript" src="/hms/jsp/js/proto.js"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>
<script language="Javascript">
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
Map map = new HashMap();
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");	 
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}
	if (request.getAttribute("map") != null) 
	{
		map = (Map) request.getAttribute("map");
	}
	List<MasItemType> itemTypeList = new ArrayList<MasItemType>();
	List<MasItemCategory> itemCategoryList = new ArrayList<MasItemCategory>();
	List<MasStoreGroup> groupList = new ArrayList<MasStoreGroup>();
	List<MasItemClass> masItemClassList = new ArrayList<MasItemClass>();
	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}
	masItemClassList = (List<MasItemClass>)map.get("masItemClassList");
	if(map.get("groupList") != null){
		groupList = (List<MasStoreGroup>)map.get("groupList") ;
	}
	itemTypeList = (List<MasItemType>)map.get("itemTypeList");
	itemCategoryList = (List<MasItemCategory>)map.get("itemCategoryList");
	
	List<MasStoreSection> sectionList = new ArrayList<MasStoreSection>();
	if(map.get("sectionList") != null){
		sectionList= (ArrayList) map.get("sectionList");
	}
	Map<String, Object> actualStock = new HashMap<String, Object>();
	if (map.get("actualStock") != null) {
		
		actualStock = (Map<String, Object>)map.get("actualStock");
		System.out.println("in not null");
		
	}
	List objectList = new ArrayList();
		if (actualStock.get("objectList") != null) {
			objectList = (List)actualStock.get("objectList");

		}
		String reportType="";
		if(map.get("reportType") != null){
			reportType= (String) map.get("reportType");
			System.out.println("reportType "+reportType);
		}
	String message ="";
	if (map.get("message") != null) {
	             message = (String) map.get("message");
	      }
	if(!message.equalsIgnoreCase("")){
	%>
<h4><%=message %></h4>
<%} %>

<%if(objectList.size()==0){%>
<h4><%="" %></h4>
<%}%>

  

<form name="actualStockReport"  action="" method="post">
<input type="hidden" name="hospitalId" value="<%=hospitalId%>" />
<input type="hidden" name="deptId"value="<%=deptId%>"> 
<input type="hidden" value="" name="item_id" id="item_id">

<div class="clear"></div>
<div class="titleBg">
<h2>Stock Status Report</h2>
</div>
<div class="clear"></div>
<div class="Block">
<label>Mat Code: </label>
<%--<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv"  validate="PVMS/NIV No,alphanumeric1,no"/> --%> 
<input type="text"	value="" id="pvmsNiv"  name="pvmsNiv" validate="Mat Code,string,no" onblur="getPvmsID('actualStockReport',this.value);" />
<input type="hidden" name="pvmsId" value="" id="pvmsId" validate="PVMS/NIV NO.,metachar,num,no" /> 
<label>Nomenclature </label> 
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
if(validateMetaCharacters(this.value))
{new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'})};
</script> 
<input type="hidden"	value="" id="itemId"  name="itemId" /> 






<label> Group</label> 
<select id="<%= GROUP_ID %>"	name="<%= GROUP_ID %>" validate="Group,string,no" tabindex=1 onblur="submitProtoAjaxWithDivName('actualStockReport','stores?method=getItemTypeList&group='+this.value,'nameDiv');" >
	<option value="0">Select</option>
	<%
		for (MasStoreGroup masStoreGroup : groupList) {
	%>
	<option value="<%=masStoreGroup.getId ()%>"><%=masStoreGroup.getGroupName()%></option>
	<%
		}
	%>

	
</select>
<div class="clear"></div>
<div id="nameDiv">
<label>Item Type</label> 
<select id="<%= ITEM_TYPE_ID %>"	name="<%=ITEM_TYPE_ID %>" validate="Item Type,string,no" tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasItemType masItemType : itemTypeList) {
	%>
	<option value="<%=masItemType.getId ()%>"><%=masItemType.getItemTypeName()%></option>
	<%
		}
	%>

	
</select>


<label> Section</label> 
<select id="sectionId"	name="<%= SECTION_ID %>" validate="Section,string,no" 	tabindex=1>
	<option value="0">Select</option>
	<%
		for (MasStoreSection masStoreSection : sectionList) {
	%>
	<option value="<%=masStoreSection.getId ()%>"><%=masStoreSection.getSectionName()%></option>
	<%
		}
	%>

	
</select>
<label>Class</label> 
<select	name="<%= ITEM_CLASS_ID %>" id="<%=ITEM_CLASS_ID %>" validate="Class Name,string,no"	tabindex="1">
	<option value="0">Select</option>
	<%
			for (MasItemClass masItemClass : masItemClassList) {
		%>
	<option value="<%=masItemClass.getId ()%>"><%=masItemClass.getItemClassName()%></option>
	<%
			}
		%>
</select>
<label>Category</label> 
<select	name="<%= ITEM_CATEGORY_ID %>" id="<%=ITEM_CATEGORY_ID %>" validate="Category,string,no"	tabindex=1>
	<option value="0">Select</option>
	<%
			for (MasItemCategory masItemCategory : itemCategoryList) {
		%>
	<option value="<%=masItemCategory.getId ()%>"><%=masItemCategory.getItemCategoryName()%></option>
	<%
			}
		%>
</select>

</div>




<!-- -
<label>Item Name </label> <input type="text"
	value="" id="nomenclature" name="nomenclature" />
<div id="ac2update" style="display: none;"
			class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
					</script>
 -->
<div class="clear"></div>
<label class="">Summary</label> <input type="radio" name="reportType"
	value="<%=SUMMARY  %>" class="" checked="checked"
	maxlength="30" tabindex=1 /> 
	
	<label class="">Detail </label> <input
	type="radio" name="reportType" value="<%=DETAIL  %>" class=""
	maxlength="30" tabindex=1 />
	<div class="clear"></div>
</div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
<input type="button" name="report" onClick="methodForReport1();" value="Show Records" class="buttonBig">
<input type="button" name="report" onClick="methodForReport();" value="Print" class="button">
<input type="button" name="exportExcel" onClick="methodForExcel();" value="Export To Excel" class="buttonBig">
<input type="reset" name="Reset" id="reset" value="Reset" class="button" onclick="resetCheck();" accesskey="r" />

<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

</form>

<script>
function methodForReport(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	/* if(sectionName !=""){
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport');
	}else{ */
		if(document.actualStockReport.nomenclature.value != "")
		{
			var val = document.actualStockReport.nomenclature.value;
			document.actualStockReport.method="post";
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   		if (id!="")
	   	 	{
	    	document.getElementById("itemId").value=id;
	    	document.actualStockReport.method="post";
	    	submitForm('actualStockReport','stores?method=generateActualStockReport');
			document.getElementById("itemId").value="";
			}
			
		}
		else{
			submitForm('actualStockReport','stores?method=generateActualStockReport');
		}
		
		
		
	// } 
}

function methodForReport1(){

	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

/* 	if(sectionName !=""){
		
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport&flag=j');
		
	}else{ */
		if(document.actualStockReport.nomenclature.value != "")
		{
			var val = document.actualStockReport.nomenclature.value;
			document.actualStockReport.method="post";
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var id = val.substring(index1,index2);
	   		if (id!="")
	   	 	{
	    	document.getElementById("itemId").value=id;
	    	document.actualStockReport.method="post";
	    	//if(!validatePvms(flag))
	    	//{}
	    	submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
			document.getElementById("itemId").value="";
	    	
			}
			
		}
		else
		{ 
			submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
		 
		}		
		
		//submitForm('actualStockReport','stores?method=generateActualStockReport&flag=j');
	//}
}
function fillValues(){
	if(document.actualStockReport.nomenclature.value != "")
	{
	var val = document.actualStockReport.nomenclature.value;

    var index1 = val.lastIndexOf("[");
    var index2 = val.lastIndexOf("]");
    index1++;
    var pvms = val.substring(index1,index2);
   		 if (pvms!="")
   	 	{
    	document.getElementById("item_id").value=pvms;

		}
	}
		else
		{
			document.getElementById("item_id").value=0;

		}

	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;
    var item_id=document.getElementById('item_id').value;
	if(sectionName !=0  && (item_id !=0 ||  pvmsNo != "")){
		submitForm('actualStockReport','stores?method=generateActualStockSactionReport');
		
	}else{
		submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport');
	}
	
	//submitForm('actualStockReport','/hms/hms/stores?method=generateActualStockReport&deptName='+departmentName+'');

}



function methodForExcel(){
	var sectionName=document.getElementById('sectionId').value;
	var pvmsNo=document.getElementById('pvmsNiv').value;

	if(document.actualStockReport.nomenclature.value != "")
	{
	var val = document.actualStockReport.nomenclature.value;
	document.actualStockReport.method="post";
    var index1 = val.lastIndexOf("(");
    var index2 = val.lastIndexOf(")");
    index1++;
    var id = val.substring(index1,index2);
   		if (id!="")
   	 	{
    	document.getElementById("pvmsNiv").value=id;
   	 	}
	}
 	/*  if(sectionName !=""){
		submitForm('actualStockReport','stores?method=generateActualStockSactionExcel');
	}else{   */
		submitForm('actualStockReport','stores?method=generateActualStockExcel');
	//}
}



</script>

<%if(objectList.size()>0){ %>

<!-- <div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;"> -->
<div class="cmntableWithHeight">
<table >
	<thead>
		<tr>
			<th>Sl No.</th>
			<th>Mat Code.</th>
			<th class="fixedNomen" >Nomenclature</th>
			<th>A/U </th>
			<%if(reportType.equals("detail")){ %>
			<th>Batch No.</th>
			 <th>DOM</th> 
			<th>DOE</th>
			<th>Manufacturer</th> 
			<%} %>
			<th>Stock Qty</th> 	
		</tr>
	</thead>
	

		<%
		System.out.println("in jsp------");
		int count=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>
		
	
<tr>
<td><%=++count%></td>
<td><%= object[0]%></td>
<td ><%=object[1]%></td>




<%if(reportType.equals("detail")){ %>
<%if(object[6] != null) {%>
<td ><%=object[6]%></td>
	<%}else{ %>
	<td >- </td>
	<%} }else{%>
	<td ><%=object[3]%></td>
	<%}%>
	
	
	
	
<%if(reportType.equals("detail")){ %>
<td><%= object[4]%></td>
<%if(object[7] != null) {%>
	<td ><%=HMSUtil.changeDateToddMMyyyy((Date)object[7])%></td>
	<%}else{ %>
	<td >-</td>
	<%} %>
<%if(object[5] != null) {%>
	<td ><%=object[5]%></td>
	<%}else{ %>
	<td >-</td>
	<%} %>
<%if(object[8] != null) {%>
	<td ><%=object[8]%></td>
	<%}else{ %>
	<td >-</td>
	<%} %>
<%} %>





<%if(object[2] != null) {%>
	<td ><%=object[2]%></td>
	<%}else{ %>
	<td >-</td>
	<%} %>


</tr>
<%}%>
</table>
</div>
<!-- </div> -->
<%} %>
