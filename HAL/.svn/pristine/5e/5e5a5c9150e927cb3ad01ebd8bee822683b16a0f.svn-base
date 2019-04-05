<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="jkt.hms.util.HMSUtil"%>
<%@page import="jkt.hms.util.PagedArray"%>
<%@page import="jkt.hms.masters.business.MasDepartment"%>
<%@page import="jkt.hms.masters.business.StoreItemBatchStock"%>
<%@page import="jkt.hms.masters.business.MasStoreItem"%>
<%@page import="jkt.hms.util.Box"%>
<%@page import="static jkt.hms.util.RequestConstants.*"%>
<link rel="stylesheet" type="text/css" href="/hms/jsp/css/pops.css"
	id="vbulletin_css" />

<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/IPDGrid.js"></script>

<script type="text/javascript" src="/hms/jsp/js/pops_global.js"></script>
<script type="text/javascript" src="/hms/jsp/js/pops_menu.js"></script>
<script type="text/javascript" language="javascript"
	src="/hms/jsp/js/proto.js"></script>
	
	


<%--For AutoComplete Through Ajax--%>
<script src="/hms/jsp/js/ajax.js" type="text/javascript"></script>
<script src="/hms/jsp/js/prototype.js" type="text/javascript"></script>
<script src="/hms/jsp/js/divideprototype.js" type="text/javascript"></script>

<script src="/hms/jsp/js/scriptaculous.js" type="text/javascript"></script>


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
	String time = "";
	String userName = "";
	int hospitalId = 0;
	int deptId = 0;
	Box box = HMSUtil.getBox(request);
	Map<String,Object> utilMap = new HashMap<String,Object>();
	utilMap = (Map)HMSUtil.getCurrentDateAndTime();
   	date = (String)utilMap.get("currentDate");
 	time = (String)utilMap.get("currentTime");
 	if(session.getAttribute("userName") != null)
 	{
		userName = (String)session.getAttribute("userName");
	}

  	Map map = new HashMap();
	if (request.getAttribute("map") != null)
	{
		map = (Map) request.getAttribute("map");

		if (map.get("message")!=null)
		{%>
<script>alert('<%=map.get("message").toString()%>');</script>
<%
		}
    }

	if (session.getAttribute("hospitalId") != null) {
		Integer temp =  (Integer)session.getAttribute("hospitalId");
		hospitalId = temp.intValue();
	}
	if (session.getAttribute("deptId") != null) {
		Integer temp =  (Integer)session.getAttribute("deptId");
		deptId = temp.intValue();
	}

	Map<String, Object> drugStockItem = new HashMap<String, Object>();
	if (map.get("drugStockItem") != null) {

		drugStockItem = (Map<String, Object>)map.get("drugStockItem");

	}
	List objectList = new ArrayList();
	List objectList1 = new ArrayList();
		if (drugStockItem.get("objectList") != null) {
			objectList = (List)drugStockItem.get("objectList");

		}

		if (drugStockItem.get("objectList1") != null) {
			objectList1 = (List)drugStockItem.get("objectList1");

		}

		List<MasDepartment> departmentList = new ArrayList<MasDepartment>();
		List<StoreItemBatchStock> batchStockList= new ArrayList<StoreItemBatchStock>();
		if (drugStockItem.get("departmentList") != null) {
			departmentList = (List)drugStockItem.get("departmentList");

		}

		List<MasStoreItem> itemList = new ArrayList<MasStoreItem>();
		if (drugStockItem.get("itemList") != null) {
			itemList = (List)drugStockItem.get("itemList");

		}

		if (drugStockItem.get("batchStockList") != null) {
			batchStockList = (List)drugStockItem.get("batchStockList");

		}
		Map itemValue  = new HashMap();
		if (drugStockItem.get("itemValue") != null) {
			itemValue = (Map)drugStockItem.get("itemValue");


		}
		String message="";
		if (drugStockItem.get("msg") != null) {
            message = (String)drugStockItem.get("msg");
     }
if(!message.equalsIgnoreCase("")){
%>
<h4><%=message %></h4>
<%} %>


<script language="Javascript">

function showReport()
{
	//alert("Please Enter The value."+document.stockPosition.Item.checked)
		if(document.stockPosition.nomenclature.value != "")
		{
			var val = document.stockPosition.nomenclature.value;
			document.stockPosition.method="post";
	    var index1 = val.lastIndexOf("[");
	    var index2 = val.lastIndexOf("]");
	    index1++;
	    var pvms = val.substring(index1,index2);
	   		if (pvms!="")
	   	 	{
	    	document.getElementById("item_id").value=pvms;
	    	document.stockPosition.method="post";
			//submitForm('stockPosition','stores?method=generateStockPositionReport');
	    	submitForm('stockPosition','stores?method=generateDrugsStockPosition');
			document.getElementById("item_id").value="";
			}
			else
			{
			alert("Pl. select the Nomenclature!....");
			}
		}
	else if(document.stockPosition.pvms.value != "")
		{
		document.stockPosition.method="post";
		var pvms=document.getElementById("pvms").value;
		document.getElementById("item_id").value=0;
		//submitForm('stockPosition','stores?method=generateStockPositionReport&pvmsNo='+pvms);
		submitForm('stockPosition','stores?method=generateDrugsStockPosition&pvmsNo='+pvms);
		}

	else{
		if(document.stockPosition.Item.checked){
	 			 document.stockPosition.method="post";
				//submitForm('stockPosition','stores?method=generateStockPositionReport');
  				submitForm('stockPosition','stores?method=generateDrugsStockPosition');
		}
		else{
			alert("Pl. Fill the Nomenclature / PVMSNo.! OR \n Select radio Button.!");
		}
		}
}

</script>

<form name="stockPosition">
<input type="hidden" name="hospitalId" size="5" value="<%=hospitalId%>">
<input type="hidden" name="deptId" size="5" value="<%=deptId%>">
<input type="hidden" name="item_id" size="5" id="item_id"> <br />

<div class="titleBg">
<h2>Drugs Stock Position in SMC</h2>
</div>

<div class="Block">
<div id="ddd" >
<label>PVMS/NIV No. </label>
<input type="text" value="" id="pvms" class="textbox_size20" name="pvms" validate="PVMS/NIV No.,alphanumeric1,no" />
</div>
<label>Nomenclature </label>
<input type="text" value="" id="nomenclature" class="bigcaption1" name="nomenclature" onblur="submitProtoAjaxWithDivName('stockPosition','stores?method=getPVMS','ddd');" />
<div id="ac2update" style="display: none; " class="autocomplete"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
new Ajax.Autocompleter('nomenclature','ac2update','stores?method=getItemListForBINCardByAutocomplete',{parameters:'requiredField=nomenclature'});
</script>
<!-- -
<label>Common Name </label>
<input type="text" name="<%=COMMON_NAME %>" id = "<%=COMMON_NAME %>"  class="large" MAXLENGTH="30" />
<div id="ac3update" style="display: none; border: 1px solid black; padding-right: 450px; background-color: white;"></div>
<script type="text/javascript" language="javascript" charset="utf-8">
					new Ajax.Autocompleter('<%=COMMON_NAME %>','ac3update','stores?method=getItemListForBINCardByCommonNameAutocomplete',{parameters:'requiredField=<%=COMMON_NAME %>'});
</script> -->


	<label class="medium">ALL ITEMS</label> <input type="radio" name="Item"
	value="Item" class="radioAuto" maxlength="30" tabindex=1 />
</div>
<div class="clear"></div>
<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>

<input type="button" name="generateReport" value="Generate Report" class="buttonBig"  onClick="showReport();"/>
<input type="button" name="Reset" 	value="Reset" class="button" onclick="submitForm('stockPosition','stores?method=drugsStockPosition');" />

	<div class="clear"></div>
<div class="division"></div>
<div class="clear"></div>
</form>
<% if(objectList.size()>0){ %>

<table id="main">

	<thead>
		<tr>
		
		<th>PVMS/ NIV No.</th>
			<th>
			 Nomenclature</th>
			<%
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();%>

			<th><div class="calcell"><%= object[1]%></div></th>

			<%} %>
			<th>Total</th>

		</tr>
	</thead>
	<tr>
	

<%
		int count=0;
		int tot=0;
		for (Iterator iterator = objectList.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		count++;
		 tot +=((BigDecimal)object[0]).intValue();
		%>
	<%if(count==1){ %>
<td><div class="calcell"><%=object[2]%></div></td>
<td><div class="calcell"><%=object[3]%></div></td>
<%} %>
<td ><div class="calcell"><%=object[0]%></div></td>
<%}%>
<%if(objectList.size()==count){ %>
<td><%=tot%></td>
<%} %>


</tr>


</table>
<%} %>





<% if(objectList1.size()>0){ %>
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="main">

	<thead>
		<tr>
			<th>Department/Ward </br>
			PVMS No./Nomenclature</th>
			<%

			for (Iterator iterator = departmentList.iterator(); iterator.hasNext();) {
				MasDepartment object2 = (MasDepartment) iterator.next();

				%>
				<th><div class="calcell"><%=object2.getDepartmentName()%></div></th>
				<%} %>

			<th>Total</th>

		</tr>


	</thead>


<%
		int count=0;
		//int tot=0;
		int j=0;
		for (Iterator iterator = objectList1.iterator(); iterator.hasNext();) {
		Object[] object = (Object[]) iterator.next();
		count++;
		int tot=0;
		// tot +=((BigDecimal)object[3]).intValue();
		%>
	<tr>

<td><div class="calcell"><%=object[5]%></div></td>
<%

	//for (Iterator iterator2 = objectList1.iterator(); iterator2.hasNext();) {
			//	Object[] object3 = (Object[]) iterator2.next();

					//System.out.println(((BigDecimal)object[1]).intValue()+" <><><><><><><><><><> "+((BigDecimal)object3[1]).intValue());
						//if(((BigDecimal)object[1]).intValue()==((BigDecimal)object3[1]).intValue()){
						//	System.out.println("equal 1");
							for (Iterator iterator1 = departmentList.iterator(); iterator1.hasNext();) {
								MasDepartment object2 = (MasDepartment) iterator1.next();
			%>

			<%//System.out.println(object2.getDepartmentName()+" equal "+object3[3].toString());
			if(object2.getDepartmentName().equals(object[3].toString())){//System.out.println("equal 2");
			//j=1;
			tot+=((BigDecimal)object[2]).intValue();
			%>
<td ><div class="calcell"><%=object[2]%></div></td>
<%}else{%>
<td ><div class="calcell"><%="0"%></div></td>

<%}%>
<%}%>


<td><%=tot%></td>



</tr>
<%} %>
</table>
</div>
<%} %>




<% if(itemValue .size()>0){ %>
<div STYLE=" height:400px; width: 1000px; font-size: 12px; overflow: auto;">
<table id="main">

	<thead>
		<tr>
			<th>Department/Ward </br>
			PVMS No./Nomenclature</th>
			<%

			for (Iterator iterator = departmentList.iterator(); iterator.hasNext();) {
				MasDepartment object2 = (MasDepartment) iterator.next();

				%>
				<th><div class="calcell"><%=object2.getDepartmentName()%></div></th>
				<%} %>

			<th>Total</th>

		</tr>


	</thead>


<%
		int count=0;
		//int tot=0;
		int j=0;
		//for (int i=0;i<itemValue.size(); i++) {
		Set s=itemValue.keySet();
		Iterator itr=s.iterator();
		while (itr.hasNext()) {
		int k=(Integer)itr.next();
		count++;
		int tot=0;
		for(MasStoreItem item : itemList){

			//System.out.println(item.getId()+"  test -----  "+k);
		if(item.getId()==k){
			//System.out.println("true");

		%>
	<tr>

<td ><div class="calcell"><b><%=item.getNomenclature()%></b></div></td>
<%} }%>
<%
int total=0;
String value=(String) itemValue.get(k);
//System.out.println(value);
String value1[]=value.split("#");
for(int n=0; n<value1.length; n++)
{
	//System.out.println("sec   "+value1[n]);
	String value2[]=value1[n].split("@");
	System.out.println("third   "+value2.length);
	//System.out.println("third   "+value2[0]+"  "+value2[1]);
	//total+=Integer.parseInt(value2[1]);
	%>
	<td ><div class="calcell"><%=value2[1]%></div></td>

<%}%>
<td ><div class="calcell"><%=total%></div></td>
<% } %>
</tr>
</table>
</div>
<%}%>




